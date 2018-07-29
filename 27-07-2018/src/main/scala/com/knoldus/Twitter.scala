
package com.knoldus
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder
import twitter4j.Status
import twitter4j.Query
import java.util
import scala.concurrent.ExecutionContext.Implicits.global
import scala.collection.JavaConversions._
import scala.concurrent.Future

class TwitterConfig  {
  def setTwitterConfig(): ConfigurationBuilder = {
    val config = new ConfigurationBuilder
    config.setDebugEnabled(true)
      .setOAuthConsumerKey("U4vRNr1ZCY7jCnDCsEzaOqKgH")
      .setOAuthConsumerSecret("mE0pCdTUcsnATZrResDAb5by79X4tvrZXGJmJbCS48ILSKwsBR")
      .setOAuthAccessToken("723372793270665217-cD2bicHmEKovD0uYk80z3IOEh8TAeOQ")
      .setOAuthAccessTokenSecret("zn8toS7lkOBXDlbIHX3RwdCkZNR1E5EGqvzkEStL8bSW7")
  }

  def retrieveTweets(input:String):util.List[Status]= {
    val tf = new TwitterFactory(setTwitterConfig().build)
    val twitter = tf.getInstance
    twitter.search(new Query("#" + input)).getTweets
  }

  def getNumberOfTweets(input:String):Future[Int] = Future{
    val statuses=retrieveTweets(input)
    statuses.size
  }

 def getAverageTweetsDay(input:String):Future[Int] = {
  getNumberOfTweets(input).map(length=>length/7)
 }

  def getAverageLikes(input:String):Future[Int] = Future{
  val statuses=retrieveTweets(input)
  val listOfLikes=for(tweets<-statuses)yield tweets.getFavoriteCount
    listOfLikes.sum/statuses.size
  }

  def getAverageRetweets(input:String):Future[Int]= Future{
    val statuses=retrieveTweets(input)
    val listOfRetweets=for(tweets<-statuses)yield tweets.getRetweetCount
    listOfRetweets.sum/statuses.size

  }

}


