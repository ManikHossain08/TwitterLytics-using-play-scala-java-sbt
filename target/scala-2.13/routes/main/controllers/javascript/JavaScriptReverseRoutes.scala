// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/manikhossain/Downloads/SOEN6441Project/conf/routes
// @DATE:Fri Nov 13 13:29:45 EST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseTweetController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def fetchUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TweetController.fetchUsers",
      """
        function(users0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("users", users0)])})
        }
      """
    )
  
    // @LINE:9
    def listTweets: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TweetController.listTweets",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "welcome"})
        }
      """
    )
  
    // @LINE:13
    def getUserTweets: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TweetController.getUserTweets",
      """
        function(users0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userTweets" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("users", users0)])})
        }
      """
    )
  
    // @LINE:10
    def fetchTweets: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TweetController.fetchTweets",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "welcome"})
        }
      """
    )
  
    // @LINE:14
    def wordLevelStatistics: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TweetController.wordLevelStatistics",
      """
        function(keyword0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "statistics" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("keyword", keyword0)])})
        }
      """
    )
  
    // @LINE:11
    def fetchHashtags: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TweetController.fetchHashtags",
      """
        function(hashtag0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "location" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("hashtag", hashtag0)])})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TweetController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
