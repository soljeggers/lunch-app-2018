package controllers

import java.util.Calendar

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.FakeRequest
import play.api.test.Helpers._
import services.GreetingService

class WelcomeControllerSpec extends PlaySpec with GuiceOneAppPerTest {

  "WelcomeController GET" should {
    "return a successful response" in {
      val controller = new WelcomeController(FakeMorningGreeter)
      val result = controller.welcome().apply(FakeRequest())
      status(result) mustBe OK
    }
  }
  "response to the /welcome url" in {
    val request = FakeRequest(GET, "/welcome").withHeaders("Host" -> "localhost")
    val home = route(app, request).get
    status(home) mustBe OK
  }
  "return some html" in {
    val controller = new WelcomeController(FakeMorningGreeter)
    val result = controller.welcome().apply(FakeRequest())
    contentType(result) mustBe Some("text/html")
  }
  "say good morning and have a title" in {
    val controller = new WelcomeController(FakeMorningGreeter)
    val result = controller.welcome().apply(FakeRequest())
    contentAsString(result) must include ("<h1>Good morning!</h1>")
    contentAsString(result) must include ("<title>Welcome!</title>")
  }
  "say good afternoon when it's the afternoon and have a title" in {
    val controller = new WelcomeController(FakeAfternoonGreeter)
    val result = controller.welcome().apply(FakeRequest())
    contentAsString(result) must not include ("<h1>Good morning!</h1>")
    contentAsString(result) must include ("<h1>Good afternoon!</h1>")
    contentAsString(result) must include ("<title>Welcome!</title>")
  }
}

object FakeMorningCalendar extends Calendar {

  override def get(field: Int): Int = 11
  override def computeFields(): Unit = ???
  override def getMinimum(field: Int): Int = ???
  override def add(field: Int, amount: Int): Unit = ???
  override def getLeastMaximum(field: Int): Int = ???

  override def getGreatestMinimum(field: Int): Int = ???

  override def roll(field: Int, up: Boolean): Unit = ???

  override def getMaximum(field: Int): Int = ???

  override def computeTime(): Unit = ???
}

object FakeAfternoonCalendar extends Calendar {

  override def get(field: Int): Int = 13

  override def computeFields(): Unit = ???

  override def getMinimum(field: Int): Int = ???

  override def add(field: Int, amount: Int): Unit = ???

  override def getLeastMaximum(field: Int): Int = ???

  override def getGreatestMinimum(field: Int): Int = ???

  override def roll(field: Int, up: Boolean): Unit = ???

  override def getMaximum(field: Int): Int = ???

  override def computeTime(): Unit = ???
}


object FakeMorningGreeter extends GreetingService {
  override def greeting: String = {
    val currentHour = FakeMorningCalendar.get(Calendar.HOUR_OF_DAY)
    if (currentHour < 12)
      "Good morning!"
    else
      "Good afternoon!"
  }
}

object FakeAfternoonGreeter extends GreetingService {
  override def greeting: String = {
    val currentHour = FakeAfternoonCalendar.get(Calendar.HOUR_OF_DAY)
    if (currentHour < 12)
      "Good morning!"
    else
      "Good afternoon!"
  }
}
