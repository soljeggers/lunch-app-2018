package controllers

import play.api.mvc.{Action, Controller}

class SandwichController extends Controller {

  def sandwiches() = Action { implicit request =>
    Ok(views.html.sandwiches())
  }
}
