import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._

class AsyncControllerSpec extends PlaySpec with OneAppPerTest {

  "Routes" should {
    "send 404 on a bad request" in  {
      route(app, FakeRequest(GET, "/boum")).map(status(_)) mustBe Some(NOT_FOUND)
    }
  }

  "promiseMessage" should {
    "return a message" in {
      contentAsString(route(app, FakeRequest(GET, "/promise-message")).get) mustBe "Hi!"
    }
  }

  "squareNow" should {
    "return number squared" in {
      contentAsString(route(app, FakeRequest(GET, "/square-now")).get) mustBe "100"
    }
  }

}
