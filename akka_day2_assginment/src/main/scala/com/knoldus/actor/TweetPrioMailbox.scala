
package com.knoldus.actor

import akka.actor.ActorSystem
import akka.dispatch.{PriorityGenerator, UnboundedStablePriorityMailbox}
import com.knoldus.app.Tweet
import com.typesafe.config.Config

class TweetPrioMailbox(settings: ActorSystem.Settings, config: Config)
  extends UnboundedStablePriorityMailbox(

    PriorityGenerator {

      case t:Tweet if t.friendsCount>500 =>0
      case _ => 1
    })
