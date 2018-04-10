package controllers

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.FakeRequest
import play.api.test.Helpers._

class WelcomeControllerSpec extends PlaySpec with GuiceOneAppPerTest {

  "WelcomeController GET" should {
    "return a successful response" in {
      val controller = new WelcomeController
      val result = controller.welcome.apply(FakeRequest())
      status(result) mustBe OK
    }
  }
  "response to the /welcome url" in {

    val request = FakeRequest(GET, "/welcome").withHeaders("Host" -> "localhost")
    val home = route(app, request).get
    status(home) mustBe OK
  }
  "return some html" in {
    val controller = new WelcomeController
    val result = controller.welcome.apply(FakeRequest())
    contentType(result) mustBe Some("text/html")
  }

  "return a page which says hello has a title" in {
    val controller = new WelcomeController
    val result = controller
                 .welcome()
                 .apply(FakeRequest(GET, "/welcome"))
    contentAsString(result) must include("<h1>Hello</h1>")
    contentAsString(result) must include("<title>Welcome</title>")
  }
}
