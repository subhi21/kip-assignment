
package com.knoldus.actor
import akka.actor.{Actor, Props, Terminated}
import akka.routing._
import com.knoldus.app.Tweet




class TweetRouter extends Actor {

  val routeeSize=7
  var router = {
    val routees = Vector.fill(routeeSize) {
      val r = context.actorOf(Props[TweetWorker].withDispatcher("akka.actor.my-dispatcher"))
      context watch r
      ActorRefRoutee(r)
    }
    Router(RoundRobinRoutingLogic(), routees)
  }
  override def receive:PartialFunction[Any, Unit]={
    case buffer :List[Tweet] => for(i<-buffer.indices)
      router.route(buffer(i), sender())
    case Terminated(a) ⇒
      router = router.removeRoutee(a)
      val r = context.actorOf(Props[TweetWorker])
      context watch r
      router = router.addRoutee(r)
    case msg: String => println(msg)

  }

}




