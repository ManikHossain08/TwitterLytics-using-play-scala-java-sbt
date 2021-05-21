package controllers;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Http.RequestBuilder;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;
import play.twirl.api.Content;

import static play.test.Helpers.GET;
import static play.test.Helpers.POST;
import static play.mvc.Http.Status.BAD_REQUEST;
import static play.mvc.Http.Status.OK;
import static play.mvc.Http.Status.SEE_OTHER;



import static org.junit.Assert.assertEquals;
import static play.test.Helpers.route;

import java.util.HashMap;
import java.util.Map;

public class TweetControllerTest  extends WithApplication {


    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }
    
    /**
	 * this method will test listTweets by assertEquals method
	 * 
	 * {@link controllers.TweetController#index(java.lang.string)}
	 * 
	 * @author Kunjal Kotadia
	 */
    @Test
    public void testIndex() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/");

        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertEquals("text/html", result.contentType().get());
 	    assertEquals("utf-8", result.charset().get());
	
    }
    
    /**
	 * this method will test listTweets by assertEquals method
	 * 
	 * {@link controllers.TweetController#listTweets(java.lang.string)}
	 * 
	 * @author Vasu Dadhania
	 */
    @Test
    public void testlistTweets() {
    	Map<String, String> data = new HashMap<>();
		data.put("keyword", "vasu");

		RequestBuilder request = Helpers.fakeRequest().method(GET).bodyForm(data).uri("/welcome");
		Result result = route(app, request);
		assertEquals(OK, result.status());
		assertEquals("text/html", result.contentType().get());
 	    assertEquals("utf-8", result.charset().get());
	
    }
    
    /**
	 * this method will test fetchTweets by assertEquals method
	 * 
	 * {@link controllers.TweetController#fetchTweets(java.lang.string)}
	 * 
	 * @author Vasu Dadhania
	 */
    @Test
    public void testfetchTweets() {
        
    	Map<String, String> data = new HashMap<>();
		data.put("keyword", "vasu");
			
			
		RequestBuilder request = Helpers.fakeRequest().method(POST).bodyForm(data).uri("/welcome");
		Result result = route(app, request);
		assertEquals(SEE_OTHER, result.status());
    	
    }
     @Test(expected = Exception.class)
	public void testFetchTweetsForBadRequest() {
		Map<String, String> data = new HashMap<>();
		data.put("csrfToken", "465464862313dvsfdsfds");

		RequestBuilder request = Helpers.fakeRequest().method(POST).bodyForm(data).uri("/welcome");
		Result result = route(app, request);
		assertEquals(BAD_REQUEST, result.status());
	}
     
	/**
	 * this method will test fetchHastags by assertEquals method
	 * 
	 * {@link controllers.TweetController#fetchHashtag(java.lang.string)}
	 * 
	 * @author Vasu Dadhania
	 */
	@Test
	public void testfetchHashtags() {
		RequestBuilder request = Helpers.fakeRequest().method(GET).uri("/location?hashtag=vasu");
		Result result = route(app, request);
		assertEquals(OK, result.status());
	}
    
    
    
	/**
 	 * this method will test fetchUsers(java.lang.String) by assertThat Method along with 
 	 * org.hamcrest.Matchers.equalTo(Integer operand) from hamcrest-core library
 	 * 
 	 * {@link controllers.TweetController#fetchUsers(java.lang.String)}.
 	 * 
 	 * Author: Md Manik Hossain
 	 * 
 	 */
 	@Test
 	public void testGetUserInfo() {
 		RequestBuilder request = Helpers.fakeRequest().method(GET).uri("/users?users=JasonJason267");
 		Result result = route(app, request);
 		assertThat(OK, is(equalTo(result.status())));
 		assertEquals("text/html", result.contentType().get());
 	    assertEquals("utf-8", result.charset().get());
 	}
 	
 	
 	/**
 	 * this method will test fetchUsers(java.lang.String) by assertEquals Method
 	 * 
 	 * {@link controllers.TweetController#fetchUsers(java.lang.String)}.
 	 * 
 	 * Author: Md Manik Hossain
 	 * 
 	 */
 	@Test
 	public void testGetUserInfoWithAssertEqual() {
 		RequestBuilder request = Helpers.fakeRequest().method(GET).uri("/users?users=JasonJason267");
 		Result result = route(app, request);
 		assertEquals(OK, result.status());
 		assertEquals("text/html", result.contentType().get());
 	    assertEquals("utf-8", result.charset().get());
 	}
     
 	
 	/**
 	 * this method will test getUserTweets(java.lang.String) by assertThat Method along with 
 	 * org.hamcrest.Matchers.equalTo(Integer operand) from hamcrest-core library
 	 * 
 	 * {@link controllers.TweetController#getUserTweets(java.lang.String)}.
 	 * 
 	 * Author: Md Manik Hossain
 	 * 
 	 */
 	@Test
 	public void testGetUserStatusList() {
 		RequestBuilder request = Helpers.fakeRequest().method(GET).uri("/userTweets?users=Glass1ncision");
 		Result result = route(app, request);
 		assertThat(OK, is(equalTo(result.status())));
 		assertEquals("text/html", result.contentType().get());
 	    assertEquals("utf-8", result.charset().get());
 	}
 	
 	
 	/**
 	 * this method will test getUserTweets(java.lang.String) by assertEquals Method
 	 * 
 	 * {@link controllers.TweetController#getUserTweets(java.lang.String)}.
 	 * 
 	 * Author: Md Manik Hossain
 	 * 
 	 */
 	@Test
 	public void testGetUserStatusListWithAssertEqual() {
 		RequestBuilder request = Helpers.fakeRequest().method(GET).uri("/userTweets?users=Glass1ncision");
 		Result result = route(app, request);
 		assertEquals(OK, result.status());
 		assertEquals("text/html", result.contentType().get());
 	    assertEquals("utf-8", result.charset().get());
 	}
 	
 	/**
 	 * this method will do Unit testing for viewing templates
 	 * 
 	 * Author: Md Manik Hossain
 	 * 
 	 */
 	@Test
 	public void renderIndexTemplate() {
 	    Content html = views.html.index.render();
 	    assertEquals("text/html", html.contentType());
 	    
 	}
 	

 	/**
 	 * this method will test wordLevelStatistics(java.lang.String) for a non empty keyword 
 	 * by assertEquals Method
 	 * 
 	 * {@link controllers.TweetController#wordLevelStatistics(java.lang.String)}.
 	 * 
 	 * Author: Samuel Vineeth
 	 * 
 	 */
 	@Test
 	public void testWordLevelStatsForPass() {
 		RequestBuilder request = Helpers.fakeRequest().method(GET).uri("/statistics?keyword=india");
 		Result result = route(app, request);
 		assertEquals(OK, result.status());
 		assertEquals("text/html", result.contentType().get());
 	    assertEquals("utf-8", result.charset().get());
 	}
 	
 	/**
 	 * this method will test wordLevelStatistics(java.lang.String) for a null keyword 
 	 * by assertEquals Method
 	 * 
 	 * {@link controllers.TweetController#wordLevelStatistics(java.lang.String)}.
 	 * 
 	 * Author: Samuel Vineeth
 	 * 
 	 */
 	@Test
 	public void testWordLevelStatsForNull() {
 		RequestBuilder request = Helpers.fakeRequest().method(GET).uri("/statistics?keyword=null");
 		Result result = route(app, request);
 		assertEquals(OK, result.status());
 		assertEquals("text/html", result.contentType().get());
 	    assertEquals("utf-8", result.charset().get());
 	}

 	/**
 	 * this method will test wordLevelStatistics(java.lang.String) for an empty keyword 
 	 * by assertEquals Method
 	 * 
 	 * {@link controllers.TweetController#wordLevelStatistics(java.lang.String)}.
 	 * 
 	 * Author: Samuel Vineeth
 	 * 
 	 */
 	@Test(expected = Exception.class)
 	public void testWordLevelStatsForEmpty() {
 		RequestBuilder request = Helpers.fakeRequest().method(GET).uri("/statistics?keyword=");
 		Result result = route(app, request);
 		assertEquals(BAD_REQUEST, result.status());
 	}
}

 	


