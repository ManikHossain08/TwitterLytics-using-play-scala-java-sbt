package controllers;

import models.Tweet;
import models.User;

import play.cache.SyncCacheApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.*;
import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.Place;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Objects;

import play.mvc.Http.Session;
import play.mvc.Result;

import static java.util.stream.Collectors.toList;
import static play.libs.Scala.asScala;

/**
 * An example of form processing.
 *
 * https://playframework.com/documentation/latest/JavaForms
 */
@Singleton
public class TweetController extends Controller {

	private final Form<TweetData> form;
	private MessagesApi messagesApi;
	private List<Tweet> tweets;
	private final List<Tweet> tweetsLocation;
	private static Twitter twitter;
	private final Config config;
	private static List<List<Tweet>> orderedTweets = null;
	private Map<String, Long> finalMap; //for wordLevelStats
	private List<CompletableFuture<Tweet>> tweethashtags; //for fetchHashtags

	
	@Inject
	private SyncCacheApi cache;
	
	/**
	 * This constructor is for authentication of twitter API and initiates variables
	 * 
	 * @param formFactory
	 * @param messagesApi
	 * @param cache
	 * 
	 * @author Md Manik Hossain
	 */
	@Inject
	public TweetController(FormFactory formFactory, MessagesApi messagesApi, SyncCacheApi cache) {
		this.tweets = new ArrayList<>();
		this.tweetsLocation = new ArrayList<>();
		this.form = formFactory.form(TweetData.class);
		this.messagesApi = messagesApi;
		config = ConfigFactory.load();
		this.orderedTweets = new ArrayList<>();
		this.cache = cache;

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(config.getString("CONSUMER_KEY"))
				.setOAuthConsumerSecret(config.getString("CONSUMER_SECRET"))
				.setOAuthAccessToken(config.getString("ACCESS_TOKEN"))
				.setOAuthAccessTokenSecret(config.getString("ACCESS_TOKEN_SECRET"));
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();

	}
	
	/**
	 * This will give the welcome link
	 * 
	 * @return the index page
	 * 
	 * @author Kunjal Kotadia
	 */
	public Result index() {
		this.tweets = new ArrayList<>();
		this.orderedTweets = new ArrayList<>();
		return ok(views.html.index.render());
	}

	// display the list
	public CompletionStage<Result> listTweets(Http.Request request) {
		return CompletableFuture.completedFuture(ok(views.html.listTweet.render(tweets, form, request, messagesApi.preferred(request))));
	}
	
	/**
	 * This method work as main method for controller, which get the keyword enter by the user
	 * and query will execute using this keyword to fetch the 10 tweets related to that word.
	 * Also it will give the User, location, Hyperlinked hashtags and sentiments of each tweets
	 * 
	 * @param request
	 * 
	 * @return Result and will be redirect on listTweet page
	 * 
	 * @author Vasu Dadhania
	 */
	
	public CompletionStage<Result> fetchTweets(Http.Request request) {
		final Form<TweetData> boundForm = form.bindFromRequest(request);

		if (boundForm.hasErrors()) {
			// logger.error("errors = {}", boundForm.errors());
			return CompletableFuture.completedFuture(badRequest(views.html.listTweet.render(tweets, boundForm, request, messagesApi.preferred(request))));
		} else {
			CompletableFuture<List<Tweet>> sessionComp = CompletableFuture.supplyAsync(() -> {
			TweetData data = boundForm.get();
			data.setkeyword(data.getkeyword());
			System.out.println("keyword" + data.getkeyword());
			Query query = new Query("\\\"" + data.getkeyword() + "\\\"" + " +exclude:retweets");
			query.setCount(10);

			List<Tweet> resultTweets = null;
			try {

				QueryResult result = twitter.search(query);

				List<Status> tweets = result.getTweets();
				User user;
				Tweet tweet;
				ArrayList<String> h = new ArrayList<String>();

				resultTweets = new ArrayList<>();

				Session session = new Session();
				session.adding(data.getkeyword(), "vasu");

				Optional<List<Tweet>> cacheData = cache.get(data.getkeyword());

				if (cacheData.isPresent()) {

					resultTweets = cacheData.get();

					System.out.println("from the cache");
				} else {

					for (Status t : tweets) {

						
						String tweetData = t.getText();
//						System.out.println("keyword" + data.getkeyword());
//						System.out.println("tweet" + tweetData);

						user = new User();
						user.setName(t.getUser().getName());
						user.setLocation(t.getUser().getLocation());
						user.setScreenName(t.getUser().getScreenName());

						tweet = new Tweet(data.getkeyword());
						tweet.setUser(user);
						tweet.setTweet(t.getText());
						tweet.setArrayoftags(t.getHashtagEntities());
						tweet.setSentimentRatings(tweetSentiments(t.getText()));

						HashtagEntity[] tags = t.getHashtagEntities();
						for (HashtagEntity hashtagEntity : tags) {

							String hashtag = "#" + hashtagEntity.getText();

							h.add(hashtag);
							tweet.setHashtag(hashtag);

						}

						resultTweets.add(tweet);
						this.tweets.add(tweet);
					}

					// else end
				}
				cache.set(data.getkeyword(), resultTweets, 60 * 15);

				orderedTweets.add(resultTweets);
				organizeTweetList();
				return this.tweets;
			} catch (TwitterException exp) {
				// logger.error("Exception in queryApi method", exp);
				return this.tweets;
			}
			});
			return sessionComp.thenApply(m -> redirect(routes.TweetController.listTweets()).addingToSession(request, boundForm.get().getkeyword(), "vasu"));
		}
	}
	/**
	 * This method has been implemented as a helper method of the fetchTweets() because we need organize our tweets
	 * on home page in ordered way (new search list on top of lists). Hence this method will organize the tweets 
	 * in the this.tweets variable.
	 * 
	 * @param no parameter need because we have global variable in the controller.
	 *            
	 * @return nothing will be returned because we are setting value to the global variable.
	 * 
	 * @author Md Manik Hossain
	 */
	
	private void organizeTweetList() {
		this.tweets = new ArrayList<>();
		for (int i = orderedTweets.size() - 1; i >= 0; i--) {
			for (Tweet list : orderedTweets.get(i)) {
				this.tweets.add(list);
			}
		}

	}
	
	/**
	 * This method will filter out the hashtags of the tweet and make it hyperlinked,
	 * to fetch other tweets using that hashtag
	 * 
	 * @param hashtag
	 * @param request
	 * @return tweets which include the particular hashtags
	 * 			<code>Result</code> 
	 * @author Vasu Dadhania
	 */
	
	public CompletionStage<Result> fetchHashtags(final String hashtag, Http.Request request) {
    	
    	System.out.println("location"+hashtag);
    	
    	Query query = new Query(hashtag);
		query.setCount(10);
		try {
		    QueryResult result;
		    result = twitter.search(query);
			
			tweethashtags = result.getTweets().stream().map(t -> CompletableFuture.supplyAsync(
					() -> new Tweet(new User(t.getUser().getName(), t.getUser().getLocation()), t.getText(), hashtag)))
			.collect(Collectors.toList());
		} catch (TwitterException exp) {
			//logger.error("Exception in queryApi method", exp);
		}
		return CompletableFuture.completedFuture(Results.ok(views.html.location.render(tweethashtags.stream().map(CompletableFuture::join).collect(Collectors.toList()))));
    }
	
	/**
	 * Takes the user screenName and fetch the user object and list of tweets for that user asynchronously
	 * 
	 * @param screenName the users screenName
	 *            
	 * @return user's profile and its recent posts as a completableFuture of type
	 *         <code>Result</code>
	 * @author Md Manik Hossain
	 */
	
	public CompletionStage<Result> fetchUsers(final String screenName) {

		CompletableFuture<twitter4j.User> userInfo;

		userInfo = CompletableFuture.supplyAsync(() -> {
			twitter4j.User user = null;
			try {
				user = twitter.showUser(screenName);
			} catch (TwitterException exp) {
				// logger.error("Exceptin while fetching user");
			}
			return user;
		});
		
		
		CompletableFuture<ResponseList<Status>> latestPost;

		latestPost = CompletableFuture.supplyAsync(() -> {
			ResponseList<Status> recentPost = null;
			try {
				recentPost = twitter.getUserTimeline(screenName);
				recentPost.stream().limit(10).collect(toList());
			} catch (TwitterException exp) {
				// logger.error("Exceptin while fetching user status");
			}
			return recentPost;
		});


		return userInfo.thenCombine(latestPost, (user, post) -> ok(views.html.users.render(user, post)));

	}
	
	/**
	 * Takes the user screenName list of recent tweets for that user asynchronously
	 * 
	 * This method has been implemented to serve a purpose of viewing all the latest in a separate page.   
	 * 
	 * @param screenName the users screenName
	 *            
	 * @return recent posts of a pecific user as a completableFuture of type
	 *         <code>Result</code>
	 * @author Md Manik Hossain
	 */
	public CompletionStage<Result> getUserTweets(final String screenName) {

		CompletableFuture<ResponseList<Status>> latestPost;

		latestPost = CompletableFuture.supplyAsync(() -> {
			ResponseList<Status> recentPost = null;
			try {
				recentPost = twitter.getUserTimeline(screenName);
			} catch (TwitterException exp) {
				// logger.error("Exceptin while fetching user");
			}
			return recentPost;
		});

		return latestPost.thenApply(post -> ok(views.html.usersTweetList.render(post)));
	}
	
	
	/**
	 * This method will analyze the sentiments of the tweet.
	 * It will calculate the count of happy and sad words and calculate the average according to their ratings given in dataset
	 * 
	 * @param text tweet that need to analyze
	 * 
	 * @return sum of ratings to analyze the sentiment
	 * 
	 * @author Kunjal Kotadia
	 */
	public static int tweetSentiments(String text) {

		Scanner sc = null;

		try {
			sc = new Scanner(new FileInputStream("public//dataSet//SentimentData.txt"));
		} catch (Exception e) {
			System.out.println("In Catch");
		}

		String s;
		Tweet[] tData = new Tweet[2477];
		int i = 0;

		while (sc.hasNextLine()) {
			s = sc.nextLine();
			String finalString = "";
			String tempArr[] = s.split("\\s+");
			Tweet t = new Tweet(text);

			if (tempArr.length > 2) {
				for (int j = 0; j < tempArr.length - 1; j++) {
					if (j != tempArr.length - 2) {
						finalString = finalString.concat(tempArr[j] + " ");
					} else {
						finalString = finalString.concat(tempArr[j]);
					}
				}
			} else {
				finalString = tempArr[0];
			}
			t.setSentimentData(finalString);
			t.setSentimentRatings(Integer.parseInt(tempArr[tempArr.length - 1]));
			tData[i] = t;
			i++;
		}
		sc.close();

		text = text.toLowerCase();
		int sum = 0;

		Map<String, Integer> map = new HashMap<>();
		String[] tArr = text.split(" ");

		for (int m = 0; m < tArr.length; m++) {
			if (tArr[m].contains(",")) {
				tArr[m].replace(",", "");
			}

			if (tArr[m].contains("!")) {
				tArr[m].replace("!", "");
			}

			if (tArr[m].contains(".")) {
				tArr[m].replace(".", "");
			}

			if (tArr[m].contains("#")) {
				tArr[m].replace("#", "");
			}
			if (tArr[m].contains("@")) {
				tArr[m].replace("@", "");
			}
			if (tArr[m].contains(";")) {
				tArr[m].replace(";", "");
			}
		}

		for (String str : tArr) {
			map.putIfAbsent(str, 0);
			map.put(str, map.get(str) + 1);
		}

		for (Map.Entry mapElement : map.entrySet()) {
			String str = (String) mapElement.getKey();
			int factor = (int) mapElement.getValue();
			for (int p = 0; p < tData.length; p++) {
				if (tData[p].getSentimentData().equals(str)) {
					sum = sum + factor * tData[p].getSentimentRatings();
				}
			}
		}
		return sum;
	}
	
	/**
	 * Takes the search word and provides a count of unique words from 250 tweets in descending order.
	 * 
	 * This method has been implemented to provide an analysis of the most common words used while tweeting.   
	 * 
	 * @param Utilizes a string variable keyword
	 *            
	 * @return returns of map of key (String) and value (Long) pairs, encapsulated in CompletionStage type.
	 *         <code>Map<String, Long></code>
	 * @author Samuel Vineeth
	 */
	public CompletionStage<Result> wordLevelStatistics(String keyword) {
		
		CompletableFuture<Map<String, Long>> mapper;
		finalMap = new LinkedHashMap<>();
		mapper = CompletableFuture.supplyAsync(() -> {
    	if(keyword.equals("")==false && keyword.equals("")==false) {
	      Query query = new Query(keyword);
	  	  int numberOfTweets = 250;
	  	  long lastID = Long.MAX_VALUE;
	  	  ArrayList<Status> tweets = new ArrayList<Status>();
	  	  List<Map<String, Long>> distinctWords = new ArrayList<Map<String, Long>>();
	  	  while (tweets.size () < numberOfTweets) {
	  	    if (numberOfTweets - tweets.size() > 1)
	  	      query.setCount(100);
	  	    else 
	  	      query.setCount(numberOfTweets - tweets.size());
	  	    try {
	  	      QueryResult result = twitter.search(query);
	  	      tweets.addAll(result.getTweets());
	  	      distinctWords = Stream.concat(distinctWords.parallelStream(), tweets.parallelStream()
	  	    	        .map(t -> Arrays.asList(t.getText().toLowerCase().split(" ")).parallelStream().collect(Collectors.groupingBy(
	                              Function.identity(), Collectors.counting()
	                      ))).collect(Collectors.toList()).parallelStream()).collect(Collectors.toList());
	  	      for (Status t: tweets) 
	  	        if(t.getId() < lastID) lastID = t.getId();
	  	    }

	  	    catch (TwitterException te) {
	  	    	System.out.println("Couldn't connect: " + te);
	  	    }; 
	  	    query.setMaxId(lastID-1);
	  	  }
	  	  	Optional<Map<String, Long>> tempMaps = distinctWords.stream().reduce((m1, m2) -> {
	            return Stream.concat(m1.entrySet().parallelStream(), m2.entrySet().parallelStream())
	                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                            (m1Num, m2Num) -> m1Num + m2Num));
		  	    });
		  	     
		  	    tempMaps.get().entrySet().parallelStream().sorted(Map.Entry.<String, Long>comparingByValue()
		                .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
		  	    //System.out.println(finalMap.entrySet());
		  	    if(finalMap.containsKey("rt")) {
		  	    	finalMap.remove("rt");
		  	    }
    	}
    			
		  	    return finalMap;
		});

		return mapper.thenApply(map -> ok(views.html.wordLevelStats.render(map)));
			
	 }

}
