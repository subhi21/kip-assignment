
package com.knoldus.app


import akka.actor.{ActorSystem, Props}

import scala.collection.mutable.ListBuffer
import scala.concurrent.duration._
import com.knoldus.actor.TweetRouter

case class Tweet(tweetId: String, createdAt: Long, userId: Long, tweetUserName: String, countryName: String, friendsCount: Long)

object TwitterStreamApp extends App {

  val system = ActorSystem("tweetAppSystem")
  // excution context should be use for scheduler
  implicit val executionContext = system.dispatcher
  val buffer: ListBuffer[Tweet] = scala.collection.mutable.ListBuffer[Tweet]()

  system.scheduler.schedule(0 millis, 50 millis) {
    val rg = scala.util.Random
    val num=2000
    buffer += Tweet(java.util.UUID.randomUUID().toString, rg.nextLong(), rg.nextLong(), rg.nextString(10), "India", rg.nextInt(num))
  }

  val tweetRouterRef = system.actorOf(Props[TweetRouter].withDispatcher("akka.actor.my-dispatcher"), name = "TweetRouter")
  system.scheduler.schedule(10 millis, 1 millis) {
    tweetRouterRef ! buffer.toList
       buffer.clear()


  }

}


