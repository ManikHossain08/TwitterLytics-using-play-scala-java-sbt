package controllers;

import play.data.validation.Constraints;

/**
 * A form processing DTO that maps to the widget form.
 *
 * Using a class specifically for form binding reduces the chances
 * of a parameter tampering attack and makes code clearer, because
 * you can define constraints against the class.
 */
public class TweetData {

    @Constraints.Required
    public String keyword;

   
    public TweetData() {
    }
    
    /**
     * 
     * @return keyword the search word for tweet
     */
    public String getkeyword() {
        return keyword;
    }
    /**
     * 
     * @param keyword	search word for tweets
     */
    public void setkeyword(String keyword) {
        this.keyword = keyword;
    }

}
