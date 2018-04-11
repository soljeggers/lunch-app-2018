package services

class RealSandwichService extends SandwichService {
  override def sandwiches(): List[Sandwich] = List()

}

trait SandwichService {
  def sandwiches() : List[Sandwich]
}
