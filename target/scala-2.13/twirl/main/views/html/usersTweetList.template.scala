
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

object usersTweetList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[twitter4j.Status],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(recentPost:List[twitter4j.Status]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main("User TweetList of Recent Posts")/*2.40*/ {_display_(Seq[Any](format.raw/*2.42*/("""

	"""),format.raw/*4.2*/("""<h2>User TweetList of Recent Posts:</h2>
	<hr/>
	"""),_display_(/*6.3*/if(!recentPost.isEmpty)/*6.26*/{_display_(Seq[Any](format.raw/*6.27*/("""
		"""),_display_(/*7.4*/for(status <- recentPost) yield /*7.29*/{_display_(Seq[Any](format.raw/*7.30*/("""
			"""),format.raw/*8.4*/("""<div class="panel panel-primary tweet">
					<div class="media">
						<div class="media-right" style="padding-top:15px;">
							<img class="avatar media-object" alt=""""),_display_(/*11.47*/status/*11.53*/.getUser().getScreenName()),format.raw/*11.79*/("""" src='"""),_display_(/*11.87*/status/*11.93*/.getUser().getProfileImageURLHttps()),format.raw/*11.129*/("""'>
						</div>
						<div class="media-body">
							<div class="panel-heading">
								<strong>"""),_display_(/*15.18*/status/*15.24*/.getUser().getName()),format.raw/*15.44*/("""</strong>
								<br/>&#64<i>"""),_display_(/*16.22*/status/*16.28*/.getUser().getScreenName()),format.raw/*16.54*/("""</i>
							</div>
							<div class="panel-body">	
								<p> """),_display_(/*19.14*/status/*19.20*/.getText),format.raw/*19.28*/("""</p>
								<span>"""),_display_(/*20.16*/status/*20.22*/.getCreatedAt),format.raw/*20.35*/("""</span>
								<p>
									<span title="Retweets" class="retweets"><span class="glyphicon glyphicon-retweet icons"></span>"""),_display_(/*22.106*/if(status.getRetweetedStatus!=null)/*22.141*/{_display_(_display_(/*22.143*/status/*22.149*/.getRetweetedStatus.getRetweetCount))}/*22.186*/else/*22.191*/{_display_(Seq[Any](format.raw/*22.192*/(""" """),format.raw/*22.193*/("""0 """)))}),format.raw/*22.196*/("""</span>
									<span title="Likes" class="favourites"><span class="glyphicon glyphicon-heart-empty icons"></span>"""),_display_(/*23.109*/if(status.getRetweetedStatus!=null)/*23.144*/{_display_(_display_(/*23.146*/status/*23.152*/.getRetweetedStatus.getFavoriteCount))}/*23.190*/else/*23.195*/{_display_(Seq[Any](format.raw/*23.196*/(""" """),format.raw/*23.197*/("""0 """)))}),format.raw/*23.200*/("""</span>
								</p>
							</div>
						</div>
					</div>
				</div>
				<hr/>
		""")))}),format.raw/*30.4*/("""
	""")))}),format.raw/*31.3*/("""
	"""),format.raw/*32.2*/("""</div>
""")))}))
      }
    }
  }

  def render(recentPost:List[twitter4j.Status]): play.twirl.api.HtmlFormat.Appendable = apply(recentPost)

  def f:((List[twitter4j.Status]) => play.twirl.api.HtmlFormat.Appendable) = (recentPost) => apply(recentPost)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-11-13T13:29:45.749999
                  SOURCE: /Users/manikhossain/Downloads/SOEN6441Project/app/views/usersTweetList.scala.html
                  HASH: e686ba2c386f6a6655370661fc4e6c5e44d1e5dd
                  MATRIX: 932->1|1061->38|1107->76|1146->78|1175->81|1250->131|1281->154|1319->155|1348->159|1388->184|1426->185|1456->189|1652->358|1667->364|1714->390|1749->398|1764->404|1822->440|1948->539|1963->545|2004->565|2062->596|2077->602|2124->628|2216->693|2231->699|2260->707|2307->727|2322->733|2356->746|2509->871|2554->906|2585->908|2601->914|2649->951|2663->956|2703->957|2733->958|2768->961|2912->1077|2957->1112|2988->1114|3004->1120|3053->1158|3067->1163|3107->1164|3137->1165|3172->1168|3286->1252|3319->1255|3348->1257
                  LINES: 27->1|32->2|32->2|32->2|34->4|36->6|36->6|36->6|37->7|37->7|37->7|38->8|41->11|41->11|41->11|41->11|41->11|41->11|45->15|45->15|45->15|46->16|46->16|46->16|49->19|49->19|49->19|50->20|50->20|50->20|52->22|52->22|52->22|52->22|52->22|52->22|52->22|52->22|52->22|53->23|53->23|53->23|53->23|53->23|53->23|53->23|53->23|53->23|60->30|61->31|62->32
                  -- GENERATED --
              */
          