
package com.knoldus
import akka.actor.{ActorSystem, Props}
import akka.testkit.{DefaultTimeout, ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
import com.knoldus.actor.TweetRouter
import com.knoldus.app.Tweet

class TweetRouterSpec extends TestKit(ActorSystem("tweetAppSystem")) with ImplicitSender
  with WordSpecLike with Matchers with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "Router actor" should {
    "return the no of tweets processed by worker with friend count greater than 500" in {

        val router = system.actorOf(Props[TweetRouter])
        val createdAt = 12345
        val userId = 4567
        val friendsCount = 800
        router ! List(Tweet("1", createdAt, userId, "Ankita", "India", friendsCount))
        expectMsg("worker id akka://tweetAppSystem/user/$a/$a processed 1 tweets with friends count 800")
      
    }
  }

  "Router actor" should {
    "return the no of tweets processed by worker with friend count less than 500" in {

        val router = system.actorOf(Props[TweetRouter])
        val createdAt = 4678
        val userId = 3789
        val friendsCount = 300
        router ! List(Tweet("3", createdAt, userId, "Ankit", "India", friendsCount))
        expectMsg("worker id akka://tweetAppSystem/user/$b/$a processed 1 tweets with friends count 300")


    }
  }
}
