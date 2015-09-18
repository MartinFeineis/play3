package controllers

import play.api._
import play.api.mvc._
import sun.reflect.generics.reflectiveObjects.NotImplementedException

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  def pullova = Action{
    Ok(views.html.pullova("Pullovas World"))
  }
  def sendThePullova = Action{
    Ok("Not Implemented")
  }
}