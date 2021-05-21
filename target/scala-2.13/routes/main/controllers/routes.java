// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/manikhossain/Downloads/SOEN6441Project/conf/routes
// @DATE:Fri Nov 13 13:29:45 EST 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseTweetController TweetController = new controllers.ReverseTweetController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseTweetController TweetController = new controllers.javascript.ReverseTweetController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
