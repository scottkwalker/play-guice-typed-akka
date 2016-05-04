package services

import javax.inject.{Inject, Singleton}

import akka.actor.{ActorSystem, TypedActor, TypedProps}

trait SquarerTyped {
  def squareNow(i: Int): Int = i * i //blocking send-request-reply
}

@Singleton
class SquarerTypedFactory @Inject()(actorSystem: ActorSystem) {

  def props = TypedProps(classOf[SquarerTyped], new SquarerTyped {})

  def parent = TypedActor(actorSystem).typedActorOf(props)
}
