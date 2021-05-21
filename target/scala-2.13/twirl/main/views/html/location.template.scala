
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

object location extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[Tweet],play.twirl.api.HtmlFormat.Appendable] {

  /* location Template File */
  def apply/*2.2*/(tweetsLocation:List[Tweet]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""



"""),_display_(/*7.2*/main("Hashtag")/*7.17*/ {_display_(Seq[Any](format.raw/*7.19*/("""
	
	"""),format.raw/*9.2*/("""<h2>Hashtag</h2>
	
	 <table border="1">
        <thead>
        
       <tr>
       <td><b>NAME</b></td>
       <td><b>LOCATION</b></td>
       <td><b>TWEETS</b></td>
       <td><b>SENTIMENTS</b></td>
       
       </tr>
           
        </thead>
        <tbody>
        
        
        """),_display_(/*26.10*/for(t <- tweetsLocation) yield /*26.34*/ {_display_(Seq[Any](format.raw/*26.36*/("""
        
        	
            """),format.raw/*29.13*/("""<tr>
            
            <td>"""),_display_(/*31.18*/t/*31.19*/.getUser.getName),format.raw/*31.35*/("""</td>
            <td>"""),_display_(/*32.18*/t/*32.19*/.getUser.getLocation),format.raw/*32.39*/("""</td>
            <td>"""),_display_(/*33.18*/t/*33.19*/.getTweet),format.raw/*33.28*/("""</td>
             """),_display_(/*34.15*/{
        if(t.getSentimentRatings <0){
             <td>:-(</td>
            }
        else if(t.getSentimentRatings == 0){
            <td>:-|</td>
            }
         else if(t.getSentimentRatings >0){
             <td>:-)</td>
            }
        }),format.raw/*44.10*/("""
            
            """),format.raw/*46.13*/("""</tr>
            
        """)))}),format.raw/*48.10*/("""
       
        """),format.raw/*50.9*/("""</tbody>
        
    </table>
	
	""")))}),format.raw/*54.3*/("""
"""))
      }
    }
  }

  def render(tweetsLocation:List[Tweet]): play.twirl.api.HtmlFormat.Appendable = apply(tweetsLocation)

  def f:((List[Tweet]) => play.twirl.api.HtmlFormat.Appendable) = (tweetsLocation) => apply(tweetsLocation)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-05-21T10:31:02.169
                  SOURCE: /Users/manikhossain/Downloads/TwitterLytics-using-play-scala-java-sbt/app/views/location.scala.html
                  HASH: 4546ff1ca50cd0ef15d0312b638a2691c0b08838
                  MATRIX: 939->30|1061->59|1091->64|1114->79|1153->81|1183->85|1504->379|1544->403|1584->405|1644->437|1706->472|1716->473|1753->489|1803->512|1813->513|1854->533|1904->556|1914->557|1944->566|1991->586|2269->843|2323->869|2382->897|2426->914|2491->949
                  LINES: 27->2|32->3|36->7|36->7|36->7|38->9|55->26|55->26|55->26|58->29|60->31|60->31|60->31|61->32|61->32|61->32|62->33|62->33|62->33|63->34|73->44|75->46|77->48|79->50|83->54
                  -- GENERATED --
              */
          