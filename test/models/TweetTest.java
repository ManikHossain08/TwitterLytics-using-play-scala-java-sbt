package models;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import twitter4j.HashtagEntity;
import static org.mockito.Mockito.*;

public class TweetTest {
	
	private static final String USER_NAME = "vasu";
	private static final String TWEET = "SOEN_6411";
	private static final String KEYWORD = "COVID-19 2020";
	private static final String HASHTAG = "USA";
	private static final String LOCATION = "toronto";
	private static HashtagEntity[] arrayoftags ;
	

	private Tweet tweet;
	private User user;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		user = new User();
		user.setName(USER_NAME);
		user.setLocation(LOCATION);
		
		tweet = new Tweet(KEYWORD);
		tweet.setUser(user);
		tweet.setTweet("SOEN_6411");
		tweet.setHashtag(HASHTAG);
		tweet.setArrayoftags(arrayoftags);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tweet = null;
	}

	
	@Test
	public final void testgetUser() {

		User usr = new User();
		usr.setName(USER_NAME);
		usr.setLocation(LOCATION);
		System.out.println("User"+usr.getName());
		System.out.println("Tweet"+tweet.getUser().getName());
		

		assertEquals(usr.getName(),tweet.getUser().getName());

	}
	
	@Test
	public final void testsetUser() {
		// nothing to do here
	}
	
	
	
	@Test
	public final void testgetTweet() {

		assertEquals(TWEET, tweet.getTweet());

	}
	@Test
	public final void testsetTweet() {
		// nothing to do here
	}
	
	
	@Test
	public final void testgethashTag() {

		assertEquals(HASHTAG, tweet.getHashtag());

	}
	@Test
	public final void testsethashTag() {
		// nothing to do here
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public final void testgetarrayofTag() {

		assertEquals(arrayoftags, tweet.getArrayoftags());
	}
	
	/**
	 * Test of Tweet class of using Mockito Framework
	 * 
	 * Author: Md Manik Hossain
	 */
	@Test
	public final void mockedTweetClassTest() {
		
	Tweet tweet = mock(Tweet.class);
	when(tweet.getTweet()).thenReturn("first tweet");
	assertEquals("first tweet", tweet.getTweet());
	
	when(tweet.getHashtag()).thenReturn("#SOEN6441");
	assertEquals("#SOEN6441", tweet.getHashtag());
	
	
	when(tweet.getSentimentRatings()).thenReturn(70);
	assertEquals(70, tweet.getSentimentRatings());
	
	when(tweet.getSentimentData()).thenReturn("I an not felling happy today");
	assertEquals("I an not felling happy today", tweet.getSentimentData());
	
	verify(tweet).getTweet();
	verify(tweet).getHashtag();
	verify(tweet).getSentimentRatings();
	verify(tweet).getSentimentData();
	
	}
	

}
