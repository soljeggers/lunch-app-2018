package services

import models.Sandwich
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.concurrent.Future

class RealSandwichService extends SandwichService {
  override def sandwiches(): Future[List[Sandwich]] = Future(List())

}

trait SandwichService {
  def sandwiches() : Future[List[Sandwich]]
}
