
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

object wordLevelStats extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Map[String, Long],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(finalMap:Map[String, Long]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.30*/("""

"""),_display_(/*3.2*/main("statistics")/*3.20*/ {_display_(Seq[Any](format.raw/*3.22*/("""
	
	"""),format.raw/*5.2*/("""<h2>Word Level Statistics</h2>
	
	<table>
     	<thead>
	 		<tr>
		       <td><h3>Word</h3></td>
		       <td><h3>Count</h3></td>
       		</tr>    
        </thead>
        <tbody>
        """),_display_(/*15.10*/for((key, value) <- finalMap) yield /*15.39*/ {_display_(Seq[Any](format.raw/*15.41*/("""
		    """),format.raw/*16.7*/("""<tr><td>"""),_display_(/*16.16*/key),format.raw/*16.19*/("""</td><td>"""),_display_(/*16.29*/value),format.raw/*16.34*/("""</td></tr>
		""")))}),format.raw/*17.4*/("""
        """),format.raw/*18.9*/("""</tbody>
     </table>
	
	
	
""")))}))
      }
    }
  }

  def render(finalMap:Map[String, Long]): play.twirl.api.HtmlFormat.Appendable = apply(finalMap)

  def f:((Map[String, Long]) => play.twirl.api.HtmlFormat.Appendable) = (finalMap) => apply(finalMap)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-05-21T10:31:02.163
                  SOURCE: /Users/manikhossain/Downloads/TwitterLytics-using-play-scala-java-sbt/app/views/wordLevelStats.scala.html
                  HASH: c05ac727c4cb788b818f92855a82d34c5fadb2c4
                  MATRIX: 927->1|1050->29|1080->34|1106->52|1145->54|1177->60|1405->261|1450->290|1490->292|1525->300|1561->309|1585->312|1622->322|1648->327|1693->342|1730->352
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|46->15|46->15|46->15|47->16|47->16|47->16|47->16|47->16|48->17|49->18
                  -- GENERATED --
              */
          