
package com.knoldus.actor


import akka.actor.Actor
import akka.event.{Logging, LoggingAdapter}
import com.knoldus.app.Tweet

class TweetWorker extends Actor {

    val log: LoggingAdapter = Logging(context.system,classOf[TweetWorker])
    var msgCounter1 =0
    var msgCounter2 =0
    override def receive : PartialFunction[Any, Unit] = {

      case msg: Tweet if msg.friendsCount > 500 => msgCounter1 += 1
        log.info(s"worker id ${self.path.toString} processed $msgCounter1  tweets with friends count ${msg.friendsCount}")
        sender() ! s"worker id ${self.path.toString} processed $msgCounter1 tweets with friends count ${msg.friendsCount}"

      case msg: Tweet if msg.friendsCount < 500 => msgCounter2 += 1
        log.info(s"worker id ${self.path.toString} processed $msgCounter2  tweets with friends count ${msg.friendsCount}")
        sender() ! s"worker id ${self.path.toString} processed $msgCounter2 tweets with friends count ${msg.friendsCount}"

      case _ => log.info("Wrong Tweet Message")
        sender() ! "Invalid Message"


    }

}
