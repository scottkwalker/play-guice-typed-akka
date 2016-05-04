package controllers

import javax.inject._

import akka.actor.{ActorRef, ActorSystem}
import play.api.libs.concurrent.InjectedActorSupport
import play.api.mvc._

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

@Singleton
class UntypedActorController @Inject()(
                                        actorSystem: ActorSystem,
                                        @Named("squarerUntyped") squarerUntypedActor: ActorRef
                                      )(implicit exec: ExecutionContext)
  extends Controller with InjectedActorSupport {

  def squareNowUntyped = Action.async {
    import akka.pattern.ask
    implicit val timeout: akka.util.Timeout = 5.seconds
    val future = (squarerUntypedActor ? 5).mapTo[Int]
    future.map(result => Ok(result.toString))
  }
}




