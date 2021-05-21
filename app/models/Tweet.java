package models;

import twitter4j.HashtagEntity;

/**
 * Presentation object used for displaying data in a template.
 *
 * Note that it's a good practice to keep the presentation DTO,
 * which are used for reads, distinct from the form processing DTO,
 * which are used for writes.
 */
public class Tweet {
    
	public User user;
	private String tweet;
	public String keyword;
	public String hashtag;
	public String SentimentData;
	public int SentimentRatings; 
	//public ArrayList<String> listTags = new ArrayList<String>();
	public HashtagEntity[] arrayoftags ;
	
	/**
	 * @return the array of hashtag 
	 */
	public HashtagEntity[] getArrayoftags() {
		return arrayoftags;
	}

	/**
	 * @param arrayoftags   array of hashtags
	 */
	public void setArrayoftags(HashtagEntity[] arrayoftags) {
		this.arrayoftags = arrayoftags;
	}

	/**
	 * 
	 * @param user 	user of tweets
	 * @param tweet	  tweet of user
	 * @param keyword	search word for tweets
	 */
	public Tweet(User user, String tweet, String keyword) { // for fetchHashtags
		this.user = user;
		this.tweet = tweet;
		this.keyword = keyword;
	}
	
	/**
	 * 
	 * @param keyword	search word for tweets
	 */
	public Tweet(String keyword) {
		this.keyword=keyword;
	}

	/**
	 * @return the hashtag of the tweet
	 */
	public String getHashtag() {
		return hashtag;
	}
	
	/**
	 * @param hashtag  hashtag of the tweet
	 */
	public void setHashtag(String hashtag) {
		
		this.hashtag = hashtag;
	}

	
	/**
	 * @return the user of the of particular tweet
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * @param user  tweet of the user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * @return the tweet of the particular user
	 */
	public String getTweet() {
		return tweet;
	}
	
	/**
	 * @param tweet  tweet of the user
	 */
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	
	/**
	 * @return the data from dataset present in tweet
	 */
	public String getSentimentData() {
		return SentimentData;
	}
	
	/**
	 * @return the rating of the words of tweet
	 */
	public int getSentimentRatings() {
		return SentimentRatings;
	}
	
	/**
	 * @param sentimentData  data of the tweet
	 */
	public void setSentimentData(String sentimentData) {
		SentimentData = sentimentData;
	}
	
	/**
	 * @param sentimentRatings  rating of tweet's word
	 */
	public void setSentimentRatings(int sentimentRatings) {
		SentimentRatings = sentimentRatings;
	}

	
	
}
