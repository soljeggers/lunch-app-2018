package services

import models.Sandwich
import scala.concurrent.ExecutionContext
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import uk.gov.hmrc.play.http.HeaderCarrier
import uk.gov.hmrc.play.http.hooks.HttpHook
import uk.gov.hmrc.play.http.ws.WSGet

import scala.concurrent.Future

class RealSandwichService extends SandwichService {

  val http = new WSGet {
    override val hooks = NoneRequired
  }
  override def sandwiches(): Future[List[Sandwich]] =  {
    implicit val hc = HeaderCarrier()
    http
    .GET[List[Sandwich]]("http://localhost:3000/sandwiches")
  }
}

trait SandwichService {
  def sandwiches() : Future[List[Sandwich]]
}
