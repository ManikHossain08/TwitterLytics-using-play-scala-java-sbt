
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

object users extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[twitter4j.User,List[twitter4j.Status],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user:twitter4j.User,recentPost:List[twitter4j.Status]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main("User Profile")/*2.22*/ {_display_(Seq[Any](format.raw/*2.24*/("""
	
	
	"""),format.raw/*5.2*/("""<h2>User Profile: </h2>
	<hr/>
	<div class="col-sm-6">		
		
		<div class="panel panel-default panel-front">		
			
			<div class="panel-heading">
				
				<h4 class="panel-title">
					<a href="##"><img src="""),_display_(/*14.29*/user/*14.33*/.getProfileBannerURL),format.raw/*14.53*/("""></a>
				</h4>
				<div class="media-left">
					<img class="userProfileImage" src="""),_display_(/*17.41*/user/*17.45*/.getBiggerProfileImageURLHttps),format.raw/*17.75*/(""">
				</div>
			</div>
				
			<div class="panel-body mt-20">
				<h4><strong>"""),_display_(/*22.18*/user/*22.22*/.getName),format.raw/*22.30*/("""</strong></h4>
				<h6>&#64"""),_display_(/*23.14*/user/*23.18*/.getScreenName),format.raw/*23.32*/("""</h6>
				"""),_display_(/*24.6*/user/*24.10*/.getDescription),format.raw/*24.25*/("""
				"""),format.raw/*25.5*/("""<br/>
				<ul class="nav nav-tabs">
    				<li class="active"><a data-toggle="tab" href="#tweets">Tweets</a></li>
				    <li><a data-toggle="tab" href="#following">Following</a></li>
				    <li><a data-toggle="tab" href="#followers">Followers</a></li>
				    <li><a data-toggle="tab" href="#likes">Likes</a></li>
				</ul>
				<div class="tab-content">
				    <div id="tweets" class="tab-pane fade in active">
				      <p>Number of Tweets: """),_display_(/*34.33*/user/*34.37*/.getStatusesCount),format.raw/*34.54*/("""</p>
				    </div>
				    <div id="following" class="tab-pane fade">
				      <p>Number of Friends following: """),_display_(/*37.44*/user/*37.48*/.getFriendsCount),format.raw/*37.64*/("""</p>
				    </div>
				    <div id="followers" class="tab-pane fade">
				      <p>Number of Followers: """),_display_(/*40.36*/user/*40.40*/.getFollowersCount),format.raw/*40.58*/("""</p>
				    </div>
				    <div id="likes" class="tab-pane fade">
				      <p>Number of Favourite counts (Likes): """),_display_(/*43.51*/user/*43.55*/.getFavouritesCount),format.raw/*43.74*/("""</p>
				    </div>
				</div>
				<div class="text-right">
					<div> <strong>Please Click on the user name redirect to real Twitter Profile: <a target="_blank" href="https://twitter.com/"""),_display_(/*47.130*/user/*47.134*/.getScreenName),format.raw/*47.148*/("""" class="btn btn-info btn-sm" role="button" title="Link to profile">"""),_display_(/*47.217*/user/*47.221*/.getName),format.raw/*47.229*/("""</a></strong></div>
					<div> <strong>Please Click on the user name to review all the latest TWEETS of that User on SEPARATE PAGE: <a href="""),_display_(/*48.122*/routes/*48.128*/.TweetController.getUserTweets(user.getScreenName)),format.raw/*48.178*/(""" """),format.raw/*48.179*/("""target="_blank"> """),_display_(/*48.197*/user/*48.201*/.getName),format.raw/*48.209*/("""</a> </strong></div>
					
				</div>
			</div>
		</div>		
	</div>
	<div class="text-right">
		<a href="""),_display_(/*55.12*/routes/*55.18*/.TweetController.listTweets),format.raw/*55.45*/(""" """),format.raw/*55.46*/("""class="btn btn-info btn-sm" role="button" title="Back">Back</a>
	</div>
	</br>
	<div class="col-sm-12">
	<h2>User Last 10 Tweets of Recent Posts:</h2>

	<hr/>
	"""),_display_(/*62.3*/if(!recentPost.isEmpty)/*62.26*/{_display_(Seq[Any](format.raw/*62.27*/("""
		"""),_display_(/*63.4*/for((status, i) <- recentPost.zipWithIndex) yield /*63.47*/{_display_(Seq[Any](format.raw/*63.48*/("""
			"""),_display_(/*64.5*/if(i<10)/*64.13*/{_display_(Seq[Any](format.raw/*64.14*/("""
			"""),format.raw/*65.4*/("""<div class="panel panel-primary tweet">
					<div class="media">
						<div class="media-right" style="padding-top:15px;">
							<img class="avatar media-object" alt=""""),_display_(/*68.47*/status/*68.53*/.getUser().getScreenName()),format.raw/*68.79*/("""" src='"""),_display_(/*68.87*/status/*68.93*/.getUser().getProfileImageURLHttps()),format.raw/*68.129*/("""'>
						</div>
						<div class="media-body">
							<div class="panel-heading">
								<strong>"""),_display_(/*72.18*/status/*72.24*/.getUser().getName()),format.raw/*72.44*/("""</strong>
								<br/>&#64<i>"""),_display_(/*73.22*/status/*73.28*/.getUser().getScreenName()),format.raw/*73.54*/("""</i>
							</div>
							<div class="panel-body">	
								<p> """),_display_(/*76.14*/status/*76.20*/.getText),format.raw/*76.28*/("""</p>
								<span>"""),_display_(/*77.16*/status/*77.22*/.getCreatedAt),format.raw/*77.35*/("""</span>
								<p>
									<span title="Retweets" class="retweets"><span class="glyphicon glyphicon-retweet icons"></span>"""),_display_(/*79.106*/if(status.getRetweetedStatus!=null)/*79.141*/{_display_(_display_(/*79.143*/status/*79.149*/.getRetweetedStatus.getRetweetCount))}/*79.186*/else/*79.191*/{_display_(Seq[Any](format.raw/*79.192*/(""" """),format.raw/*79.193*/("""0 """)))}),format.raw/*79.196*/("""</span>
									<span title="Likes" class="favourites"><span class="glyphicon glyphicon-heart-empty icons"></span>"""),_display_(/*80.109*/if(status.getRetweetedStatus!=null)/*80.144*/{_display_(_display_(/*80.146*/status/*80.152*/.getRetweetedStatus.getFavoriteCount))}/*80.190*/else/*80.195*/{_display_(Seq[Any](format.raw/*80.196*/(""" """),format.raw/*80.197*/("""0 """)))}),format.raw/*80.200*/("""</span>
								</p>
							</div>
						</div>
					</div>
				</div>
				<hr/>
				""")))}),format.raw/*87.6*/("""
		""")))}),format.raw/*88.4*/("""
	""")))}),format.raw/*89.3*/("""
	"""),format.raw/*90.2*/("""</div>
""")))}))
      }
    }
  }

  def render(user:twitter4j.User,recentPost:List[twitter4j.Status]): play.twirl.api.HtmlFormat.Appendable = apply(user,recentPost)

  def f:((twitter4j.User,List[twitter4j.Status]) => play.twirl.api.HtmlFormat.Appendable) = (user,recentPost) => apply(user,recentPost)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-11-13T13:29:45.765986
                  SOURCE: /Users/manikhossain/Downloads/SOEN6441Project/app/views/users.scala.html
                  HASH: 54d5d21b5c96fbc5f5bf86e42458df33a20c5420
                  MATRIX: 938->1|1087->58|1115->78|1154->80|1186->86|1420->293|1433->297|1474->317|1586->402|1599->406|1650->436|1756->515|1769->519|1798->527|1853->555|1866->559|1901->573|1938->584|1951->588|1987->603|2019->608|2493->1055|2506->1059|2544->1076|2685->1190|2698->1194|2735->1210|2868->1316|2881->1320|2920->1338|3064->1455|3077->1459|3117->1478|3334->1667|3348->1671|3384->1685|3481->1754|3495->1758|3525->1766|3694->1907|3710->1913|3782->1963|3812->1964|3858->1982|3872->1986|3902->1994|4033->2098|4048->2104|4096->2131|4125->2132|4312->2293|4344->2316|4383->2317|4413->2321|4472->2364|4511->2365|4542->2370|4559->2378|4598->2379|4629->2383|4825->2552|4840->2558|4887->2584|4922->2592|4937->2598|4995->2634|5121->2733|5136->2739|5177->2759|5235->2790|5250->2796|5297->2822|5389->2887|5404->2893|5433->2901|5480->2921|5495->2927|5529->2940|5682->3065|5727->3100|5758->3102|5774->3108|5822->3145|5836->3150|5876->3151|5906->3152|5941->3155|6085->3271|6130->3306|6161->3308|6177->3314|6226->3352|6240->3357|6280->3358|6310->3359|6345->3362|6461->3448|6495->3452|6528->3455|6557->3457
                  LINES: 27->1|32->2|32->2|32->2|35->5|44->14|44->14|44->14|47->17|47->17|47->17|52->22|52->22|52->22|53->23|53->23|53->23|54->24|54->24|54->24|55->25|64->34|64->34|64->34|67->37|67->37|67->37|70->40|70->40|70->40|73->43|73->43|73->43|77->47|77->47|77->47|77->47|77->47|77->47|78->48|78->48|78->48|78->48|78->48|78->48|78->48|85->55|85->55|85->55|85->55|92->62|92->62|92->62|93->63|93->63|93->63|94->64|94->64|94->64|95->65|98->68|98->68|98->68|98->68|98->68|98->68|102->72|102->72|102->72|103->73|103->73|103->73|106->76|106->76|106->76|107->77|107->77|107->77|109->79|109->79|109->79|109->79|109->79|109->79|109->79|109->79|109->79|110->80|110->80|110->80|110->80|110->80|110->80|110->80|110->80|110->80|117->87|118->88|119->89|120->90
                  -- GENERATED --
              */
          