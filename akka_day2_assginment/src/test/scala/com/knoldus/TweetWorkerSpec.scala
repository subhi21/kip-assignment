
package com.knoldus

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
import com.knoldus.actor. TweetWorker
import com.knoldus.app.Tweet

class TweetWorkerSpec  extends TestKit(ActorSystem("tweetAppSystem")) with ImplicitSender
  with WordSpecLike with Matchers with BeforeAndAfterAll{

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }
  "Worker actor" should {
    "return the no of tweets processed by worker with tweet count greater than 500" in{
      val worker= system.actorOf(Props[TweetWorker])
      val createdAt=12345
      val userId=4567
      val friendsCount=800
      worker ! Tweet("1",createdAt, userId, "Ankita", "India", friendsCount)
      expectMsg("worker id akka://tweetAppSystem/user/$a processed 1 tweets with friends count 800")
    }
  }
  "Worker actor" should {
    "return the no of tweets processed by worker with tweet count less than 500" in {
      val worker = system.actorOf(Props[TweetWorker])
      val createdAt=4678
      val userId=3789
      val friendsCount=300
      worker ! Tweet("3", createdAt, userId, "Ankit", "India", friendsCount)
      expectMsg("worker id akka://tweetAppSystem/user/$b processed 1 tweets with friends count 300")
    }
  }
  "Worker actor" should {
    "should return Invalid Meassge if tweet is invalid" in {
      val worker = system.actorOf(Props[TweetWorker])
      worker ! "Hello"
      expectMsg("Invalid Message")
    }
  }

}
