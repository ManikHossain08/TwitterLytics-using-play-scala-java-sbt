// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/manikhossain/Downloads/TwitterLytics-using-play-scala-java-sbt/conf/routes
// @DATE:Fri May 21 10:31:01 EDT 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
