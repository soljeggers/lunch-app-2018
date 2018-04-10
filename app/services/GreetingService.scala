package services

class RealGreetingService extends GreetingService {
  override def greeting: String = ???
}

trait GreetingService {
  def greeting: String = ???

}
