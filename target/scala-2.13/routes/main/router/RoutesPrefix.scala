// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/manikhossain/Downloads/SOEN6441Project/conf/routes
// @DATE:Fri Nov 13 13:29:45 EST 2020


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
