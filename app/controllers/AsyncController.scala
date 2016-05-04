package controllers

import akka.actor.{ActorSystem, TypedActor, TypedProps}
import javax.inject._

import play.api._
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.concurrent.duration._

@Singleton
class AsyncController @Inject() (actorSystem: ActorSystem)(implicit exec: ExecutionContext) extends Controller {

  def promiseMessage = Action.async {
    def getFutureMessage(delay: FiniteDuration, promise: Promise[String]) = {
      actorSystem.scheduler.scheduleOnce(delay) { promise.success("Hi!") }
      promise.future
    }

    val promise = Promise[String]()
    val delay = 1.millisecond
    getFutureMessage(delay, promise).map { msg => Ok(msg) }
  }

  def squareNow = Action {
    val mySquarer: Squarer = TypedActor(actorSystem).typedActorOf(TypedProps[SquarerImpl]())
    val result = mySquarer.squareNow(10)
    Ok(result.toString)
  }
}



trait Squarer {
  def squareNow(i: Int): Int //blocking send-request-reply
}

class SquarerImpl(val name: String) extends Squarer {
  def this() = this("default")

  def squareNow(i: Int): Int = i * i
}
