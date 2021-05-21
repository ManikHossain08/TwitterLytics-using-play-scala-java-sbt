
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
/*1.2*/import play.mvc.Http.Request

object listTweet extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[List[Tweet],Form[TweetData],Request,play.i18n.Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(tweets: List[Tweet], form: Form[TweetData])(implicit request: Request, messages: play.i18n.Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),_display_(/*4.2*/main("Tweets")/*4.16*/ {_display_(Seq[Any](format.raw/*4.18*/("""

    """),format.raw/*6.5*/("""<h1>Welcome to Tweetanlytics</h1>
    
         
    
    """),_display_(/*10.6*/helper/*10.12*/.form(routes.TweetController.fetchTweets)/*10.53*/ {_display_(Seq[Any](format.raw/*10.55*/("""
    """),_display_(/*11.6*/helper/*11.12*/.CSRF.formField),format.raw/*11.27*/("""
    
        """),format.raw/*13.9*/("""<div class="input-group mb-1">
        """),_display_(/*14.10*/helper/*14.16*/.inputText(form("keyword"), 'placeholder->"Search Keyword", 'class->"form-control")),format.raw/*14.99*/("""
        """),format.raw/*15.9*/("""</div>
       
        <button type="submit">Go</button>

    """)))}),format.raw/*19.6*/("""
    """),format.raw/*20.5*/("""<style>
        table, th, td """),format.raw/*21.23*/("""{"""),format.raw/*21.24*/("""
         """),format.raw/*22.10*/("""border: 1px solid black;
        """),format.raw/*23.9*/("""}"""),format.raw/*23.10*/("""
        """),format.raw/*24.9*/("""</style>
    """),_display_(/*25.6*/if(!tweets.isEmpty)/*25.25*/    {_display_(Seq[Any](format.raw/*25.30*/("""
    """),format.raw/*26.5*/("""<table>
        <thead>
          
        </thead>
        <tbody>
        
        
       <tr>
        <td><b>SEACH TERM <a href="""),_display_(/*34.36*/routes/*34.42*/.TweetController.wordLevelStatistics(tweets.get(0).keyword)),format.raw/*34.101*/(""" """),format.raw/*34.102*/("""target="_blank">Get stats for keyword """),_display_(/*34.141*/tweets/*34.147*/.get(0).keyword),format.raw/*34.162*/("""</a></b></td>
        <td><b>USER NAME</b></td>
        <td><b>LOCATION</b></td>
        <td><b>TWEETS</b></td>
        <td><b>SENTIMENTS</b></td>
        

        </tr>
        
        
        """),_display_(/*44.10*/for(t <- tweets) yield /*44.26*/ {_display_(Seq[Any](format.raw/*44.28*/("""
            
           """),format.raw/*46.12*/("""<tr>
            <td>"""),_display_(/*47.18*/t/*47.19*/.keyword),format.raw/*47.27*/("""</td>
            <td> <a href="""),_display_(/*48.27*/routes/*48.33*/.TweetController.fetchUsers(t.getUser.getScreenName)),format.raw/*48.85*/(""" """),format.raw/*48.86*/("""target="_blank"> """),_display_(/*48.104*/t/*48.105*/.getUser.getName),format.raw/*48.121*/("""</a></td>
            <td> """),_display_(/*49.19*/t/*49.20*/.getUser.getLocation),format.raw/*49.40*/("""</a></td>
            <td>"""),_display_(/*50.18*/t/*50.19*/.getTweet),format.raw/*50.28*/("""
            
            """),_display_(/*52.14*/for(s <- t.getArrayoftags) yield /*52.40*/{_display_(Seq[Any](format.raw/*52.41*/("""
            """),format.raw/*53.13*/("""<a href="""),_display_(/*53.22*/routes/*53.28*/.TweetController.fetchHashtags(t.getHashtag)),format.raw/*53.72*/("""  """),format.raw/*53.74*/("""target="_blank">"""),_display_(/*53.91*/s/*53.92*/.getText),format.raw/*53.100*/("""</a>
            
            """)))}),format.raw/*55.14*/("""
            """),_display_(/*56.14*/{
        if(t.getSentimentRatings <0){
             <td>:-(</td>
            }
        else if(t.getSentimentRatings == 0){
            <td>:-|</td>
            }
         else if(t.getSentimentRatings >0){
             <td>:-)</td>
            }
        }),format.raw/*66.10*/("""
            
           """),format.raw/*68.12*/("""</tr>
       
        """)))}),format.raw/*70.10*/("""
        
        """),format.raw/*72.9*/("""</tbody>
       
    </table>
""")))}),format.raw/*75.2*/("""
    """),format.raw/*76.5*/("""<hr/>
    
   

    """),format.raw/*80.66*/("""
    """),_display_(/*81.6*/if(form.hasGlobalErrors)/*81.30*/ {_display_(Seq[Any](format.raw/*81.32*/("""
        """),_display_(/*82.10*/form/*82.14*/.globalErrors.asScala.map/*82.39*/ { error: play.data.validation.ValidationError =>_display_(Seq[Any](format.raw/*82.88*/("""
            """),format.raw/*83.13*/("""<div>
                """),_display_(/*84.18*/error/*84.23*/.key),format.raw/*84.27*/(""": """),_display_(/*84.30*/error/*84.35*/.message),format.raw/*84.43*/("""
            """),format.raw/*85.13*/("""</div>
        """)))}),format.raw/*86.10*/("""
    """)))}),format.raw/*87.6*/("""

    
    

""")))}),format.raw/*92.2*/("""
"""))
      }
    }
  }

  def render(tweets:List[Tweet],form:Form[TweetData],request:Request,messages:play.i18n.Messages): play.twirl.api.HtmlFormat.Appendable = apply(tweets,form)(request,messages)

  def f:((List[Tweet],Form[TweetData]) => (Request,play.i18n.Messages) => play.twirl.api.HtmlFormat.Appendable) = (tweets,form) => (request,messages) => apply(tweets,form)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-11-13T13:29:45.726518
                  SOURCE: /Users/manikhossain/Downloads/SOEN6441Project/app/views/listTweet.scala.html
                  HASH: 108096e466a4939a922a64b3868c645cf066eaff
                  MATRIX: 610->1|995->31|1190->133|1217->135|1239->149|1278->151|1310->157|1395->216|1410->222|1460->263|1500->265|1532->271|1547->277|1583->292|1624->306|1691->346|1706->352|1810->435|1846->444|1939->507|1971->512|2029->542|2058->543|2096->553|2156->586|2185->587|2221->596|2261->610|2289->629|2332->634|2364->639|2524->772|2539->778|2620->837|2650->838|2717->877|2733->883|2770->898|2995->1096|3027->1112|3067->1114|3120->1139|3169->1161|3179->1162|3208->1170|3267->1202|3282->1208|3355->1260|3384->1261|3430->1279|3441->1280|3479->1296|3534->1324|3544->1325|3585->1345|3639->1372|3649->1373|3679->1382|3733->1409|3775->1435|3814->1436|3855->1449|3891->1458|3906->1464|3971->1508|4001->1510|4045->1527|4055->1528|4085->1536|4147->1567|4188->1581|4466->1838|4519->1863|4573->1886|4618->1904|4679->1935|4711->1940|4759->2021|4791->2027|4824->2051|4864->2053|4901->2063|4914->2067|4948->2092|5035->2141|5076->2154|5126->2177|5140->2182|5165->2186|5195->2189|5209->2194|5238->2202|5279->2215|5326->2231|5362->2237|5406->2251
                  LINES: 23->1|28->2|33->3|34->4|34->4|34->4|36->6|40->10|40->10|40->10|40->10|41->11|41->11|41->11|43->13|44->14|44->14|44->14|45->15|49->19|50->20|51->21|51->21|52->22|53->23|53->23|54->24|55->25|55->25|55->25|56->26|64->34|64->34|64->34|64->34|64->34|64->34|64->34|74->44|74->44|74->44|76->46|77->47|77->47|77->47|78->48|78->48|78->48|78->48|78->48|78->48|78->48|79->49|79->49|79->49|80->50|80->50|80->50|82->52|82->52|82->52|83->53|83->53|83->53|83->53|83->53|83->53|83->53|83->53|85->55|86->56|96->66|98->68|100->70|102->72|105->75|106->76|110->80|111->81|111->81|111->81|112->82|112->82|112->82|112->82|113->83|114->84|114->84|114->84|114->84|114->84|114->84|115->85|116->86|117->87|122->92
                  -- GENERATED --
              */
          