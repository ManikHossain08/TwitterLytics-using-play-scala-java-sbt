// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/manikhossain/Downloads/TwitterLytics-using-play-scala-java-sbt/conf/routes
// @DATE:Fri May 21 10:31:01 EDT 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseTweetController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def fetchUsers(users:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("users", users)))))
    }
  
    // @LINE:9
    def listTweets(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "welcome")
    }
  
    // @LINE:13
    def getUserTweets(users:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "userTweets" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("users", users)))))
    }
  
    // @LINE:10
    def fetchTweets(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "welcome")
    }
  
    // @LINE:14
    def wordLevelStatistics(keyword:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "statistics" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("keyword", keyword)))))
    }
  
    // @LINE:11
    def fetchHashtags(hashtag:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "location" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("hashtag", hashtag)))))
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:17
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
