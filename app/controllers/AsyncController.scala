package controllers

import javax.inject._

import akka.actor.ActorSystem
import play.api.libs.concurrent.InjectedActorSupport
import play.api.mvc._

import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Promise}

@Singleton
class AsyncController @Inject()(actorSystem: ActorSystem)(implicit exec: ExecutionContext)
  extends Controller with InjectedActorSupport {

  def promiseMessage = Action.async {

    def getFutureMessage(delay: FiniteDuration, promise: Promise[String]) = {
      actorSystem.scheduler.scheduleOnce(delay) {
        promise.success("Hi!")
      }
      promise.future
    }

    val promise = Promise[String]()
    val delay = 1.millisecond
    getFutureMessage(delay, promise).map { msg => Ok(msg) }
  }
}




