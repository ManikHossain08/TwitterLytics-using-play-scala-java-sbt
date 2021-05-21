// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/manikhossain/Downloads/SOEN6441Project/conf/routes
// @DATE:Fri Nov 13 13:29:45 EST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  TweetController_1: controllers.TweetController,
  // @LINE:17
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    TweetController_1: controllers.TweetController,
    // @LINE:17
    Assets_0: controllers.Assets
  ) = this(errorHandler, TweetController_1, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, TweetController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.TweetController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """welcome""", """controllers.TweetController.listTweets(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """welcome""", """controllers.TweetController.fetchTweets(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """location""", """controllers.TweetController.fetchHashtags(hashtag:String, request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.TweetController.fetchUsers(users:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userTweets""", """controllers.TweetController.getUserTweets(users:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """statistics""", """controllers.TweetController.wordLevelStatistics(keyword:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_TweetController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_TweetController_index0_invoker = createInvoker(
    TweetController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TweetController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_TweetController_listTweets1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("welcome")))
  )
  private[this] lazy val controllers_TweetController_listTweets1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TweetController_1.listTweets(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TweetController",
      "listTweets",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """welcome""",
      """ Widgets""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_TweetController_fetchTweets2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("welcome")))
  )
  private[this] lazy val controllers_TweetController_fetchTweets2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TweetController_1.fetchTweets(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TweetController",
      "fetchTweets",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """welcome""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_TweetController_fetchHashtags3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("location")))
  )
  private[this] lazy val controllers_TweetController_fetchHashtags3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TweetController_1.fetchHashtags(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TweetController",
      "fetchHashtags",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """location""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_TweetController_fetchUsers4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_TweetController_fetchUsers4_invoker = createInvoker(
    TweetController_1.fetchUsers(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TweetController",
      "fetchUsers",
      Seq(classOf[String]),
      "GET",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_TweetController_getUserTweets5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userTweets")))
  )
  private[this] lazy val controllers_TweetController_getUserTweets5_invoker = createInvoker(
    TweetController_1.getUserTweets(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TweetController",
      "getUserTweets",
      Seq(classOf[String]),
      "GET",
      this.prefix + """userTweets""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_TweetController_wordLevelStatistics6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("statistics")))
  )
  private[this] lazy val controllers_TweetController_wordLevelStatistics6_invoker = createInvoker(
    TweetController_1.wordLevelStatistics(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TweetController",
      "wordLevelStatistics",
      Seq(classOf[String]),
      "GET",
      this.prefix + """statistics""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_Assets_versioned7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned7_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_TweetController_index0_route(params@_) =>
      call { 
        controllers_TweetController_index0_invoker.call(TweetController_1.index)
      }
  
    // @LINE:9
    case controllers_TweetController_listTweets1_route(params@_) =>
      call { 
        controllers_TweetController_listTweets1_invoker.call(
          req => TweetController_1.listTweets(req))
      }
  
    // @LINE:10
    case controllers_TweetController_fetchTweets2_route(params@_) =>
      call { 
        controllers_TweetController_fetchTweets2_invoker.call(
          req => TweetController_1.fetchTweets(req))
      }
  
    // @LINE:11
    case controllers_TweetController_fetchHashtags3_route(params@_) =>
      call(params.fromQuery[String]("hashtag", None)) { (hashtag) =>
        controllers_TweetController_fetchHashtags3_invoker.call(
          req => TweetController_1.fetchHashtags(hashtag, req))
      }
  
    // @LINE:12
    case controllers_TweetController_fetchUsers4_route(params@_) =>
      call(params.fromQuery[String]("users", None)) { (users) =>
        controllers_TweetController_fetchUsers4_invoker.call(TweetController_1.fetchUsers(users))
      }
  
    // @LINE:13
    case controllers_TweetController_getUserTweets5_route(params@_) =>
      call(params.fromQuery[String]("users", None)) { (users) =>
        controllers_TweetController_getUserTweets5_invoker.call(TweetController_1.getUserTweets(users))
      }
  
    // @LINE:14
    case controllers_TweetController_wordLevelStatistics6_route(params@_) =>
      call(params.fromQuery[String]("keyword", None)) { (keyword) =>
        controllers_TweetController_wordLevelStatistics6_invoker.call(TweetController_1.wordLevelStatistics(keyword))
      }
  
    // @LINE:17
    case controllers_Assets_versioned7_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned7_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
