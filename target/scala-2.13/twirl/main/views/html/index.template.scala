
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
  """),_display_(/*3.4*/main("Welcome to Tweetanalyis")/*3.35*/ {_display_(Seq[Any](format.raw/*3.37*/("""

"""),format.raw/*5.1*/("""<html>
<style>
div"""),format.raw/*7.4*/("""{"""),format.raw/*7.5*/("""
  """),format.raw/*8.3*/("""margin:0 auto;
  width:400px;
  text-align:center;
"""),format.raw/*11.1*/("""}"""),format.raw/*11.2*/("""

"""),format.raw/*13.1*/("""</style>

    <div>
      	 <h2>Welcome to Tweeterlytics</h2>
         <h4>Please click <a href=""""),_display_(/*17.37*/routes/*17.43*/.TweetController.listTweets),format.raw/*17.70*/(""""> HERE </a> to continue</h4>
     

    </div>
	</html>
  """)))}),format.raw/*22.4*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-11-13T13:29:45.756042
                  SOURCE: /Users/manikhossain/Downloads/SOEN6441Project/app/views/index.scala.html
                  HASH: 0bdf23db7ce976bc546de54b95a837c3462eac1e
                  MATRIX: 900->1|996->4|1025->8|1064->39|1103->41|1131->43|1175->61|1202->62|1231->65|1309->116|1337->117|1366->119|1491->217|1506->223|1554->250|1644->310
                  LINES: 27->1|32->2|33->3|33->3|33->3|35->5|37->7|37->7|38->8|41->11|41->11|43->13|47->17|47->17|47->17|52->22
                  -- GENERATED --
              */
          