
package com.knoldus
import org.scalatest.AsyncFlatSpec
import scala.concurrent.Future
class TwitterSpec extends AsyncFlatSpec {
  val testObj=new TwitterConfig()
  "TwitterConfig class" should "return total no of tweets corresponding to input" in{
      testObj.getNumberOfTweets("cricket").map(actual=>assert(actual>=1))
  }
  "TwitterConifg class" should "return average no of tweets corresponding to the input" in{
    testObj.getAverageTweetsDay("cricket").map(actual=>assert(actual>=1))
  }
  "TwitterConifg class" should "return average no of likes per tweet corresponding to the input" in{
    testObj.getAverageLikes("cricket").map(actual=>assert(actual>=0))
  }
  "TwitterConifg class" should "return avergae no of re-tweets per tweet corresponding to the input" in{
    testObj.getAverageRetweets("cricket").map(actual=>assert(actual>=1))
  }

}
