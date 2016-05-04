package controllers

import org.scalatestplus.play._
import play.api.test.Helpers._
import play.api.test._

class UntypedActorControllerSpec extends PlaySpec with OneAppPerTest {

  "squareNowUntyped" should {

    "return number squared" in {
      contentAsString(route(app, FakeRequest(GET, "/square-now-untyped")).get) mustBe "25"
    }
  }
}
