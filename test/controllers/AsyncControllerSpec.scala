package controllers

import org.scalatestplus.play._
import play.api.test.Helpers._
import play.api.test._

class AsyncControllerSpec extends PlaySpec with OneAppPerTest {

  "promiseMessage" should {

    "return a message" in {
      contentAsString(route(app, FakeRequest(GET, "/promise-message")).get) mustBe "Hi!"
    }
  }
}
