package models;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {
	
	private static final String USER_NAME = "vasu";
	private static final String LOCATION = "montreal";
	private static final String USER_SCREEN_NAME = "Manik";

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
		user.setName("vasu");
		user.setLocation("montreal");
		user.setScreenName("Manik");

	}

	@After
	public void tearDown() throws Exception {
		user = null;
	}

	/**
	 * Test method for used to test using Mockito Framework of User.Class
	 */
	@Test
	public final void mockedUserScreenNameTest() {
		User user = mock(User.class);
		when(user.getScreenName()).thenReturn("iAmManik");
		assertEquals("iAmManik", user.getScreenName());
		verify(user).getScreenName();

	}
	
	
	/**
	 * Test User class of twitter4j.User class using Mockito Framework
	 * 
	 * Author: Md Manik Hossain
	 */
	@Test
	public final void mockedUserTest() {
	twitter4j.User user = mock(twitter4j.User.class);
	
	when(user.getStatusesCount()).thenReturn(1234);
	assertEquals(1234, user.getStatusesCount());
	
	when(user.getFavouritesCount()).thenReturn(100);
	assertEquals(100, user.getFavouritesCount());
	
	when(user.getFollowersCount()).thenReturn(101);
	assertEquals(101, user.getFollowersCount());
	
	when(user.getFriendsCount()).thenReturn(10111);
	assertEquals(10111, user.getFriendsCount());
	
	when(user.getDescription()).thenReturn("Rovers Supporter....Living in Hope");
	assertEquals("Rovers Supporter....Living in Hope", user.getDescription());
	
	verify(user).getStatusesCount();
	verify(user).getFavouritesCount();
	verify(user).getFollowersCount();
	verify(user).getFriendsCount();
	verify(user).getDescription();

	}

	/**
	 * Test method for {@link models.User#getName()}.
	 */
	@Test
	public final void testGetName() {
		assertEquals(USER_NAME, user.getName());
	}

	@Test
	public final void testsetName() {

		// Nothing to do
	}

	@Test
	public final void testgetLocation() {
		assertEquals(LOCATION, user.getLocation());
	}

	@Test
	public final void testsetLocation() {

		// Nothing to do
	}

	/**
	 * Test method for {@link models.User#getScreenName()}.
	 * 
	 * Author: Md Manik Hossain
	 */
	@Test
	public final void testgetScreenName() {
		assertEquals(USER_SCREEN_NAME, user.getScreenName());
	}

	@Test
	public final void testsetScreenName() {

		// Nothing to do
	}

}
