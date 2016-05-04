package controllers

import javax.inject._

import akka.actor.{ActorSystem, TypedActor, TypedProps}
import play.api.libs.concurrent.InjectedActorSupport
import play.api.mvc._
import services.{SquarerTyped, SquarerTypedImpl}

import scala.concurrent.ExecutionContext

@Singleton
class TypedActorController @Inject()(
                                 actorSystem: ActorSystem
                               )(implicit exec: ExecutionContext)
  extends Controller with InjectedActorSupport {

  def squareNow = Action {
    val squarer: SquarerTyped = TypedActor(actorSystem).typedActorOf(TypedProps[SquarerTypedImpl]())
    val result = squarer.squareNow(10)
    Ok(result.toString)
  }
}




