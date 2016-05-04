package services

import akka.actor.Actor

class SquarerUntypedActor extends Actor {

  override def receive = {
    case i: Int => sender() ! i * i
  }
}
