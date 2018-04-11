package controllers

import javax.inject.Inject
import play.api.mvc.{Action, Controller}
import services.SandwichService

class SandwichController @Inject()(sandwichService: SandwichService) extends Controller {

  def sandwiches() = Action { implicit request =>
    val sandwiches = sandwichService.sandwiches
    Ok(views.html.sandwiches(sandwiches))
  }
}
