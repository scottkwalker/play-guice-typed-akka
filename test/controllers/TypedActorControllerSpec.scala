package controllers

import org.scalatestplus.play._
import play.api.test.Helpers._
import play.api.test._

class TypedActorControllerSpec extends PlaySpec with OneAppPerTest {

  "squareNowTyped" should {

    "return number squared" in {
      contentAsString(route(app, FakeRequest(GET, "/square-now-typed")).get) mustBe "100"
    }
  }
}
