package controllers

import javax.inject._

import play.api.mvc._
import services.SquarerTypedFactory

import scala.concurrent.ExecutionContext

@Singleton
class TypedActorController @Inject()(squarerTypedFactory: SquarerTypedFactory)(implicit exec: ExecutionContext)
  extends Controller {

  val squarer = squarerTypedFactory.parent

  def squareNow = Action {
    val result = squarer.squareNow(10)
    Ok(result.toString)
  }
}




