package controllers
a
import play.api._
import play.api.mvc._
import sun.reflect.generics.reflectiveObjects.NotImplementedException
import play.api.libs.json.Json
import controllers.mongoaction


object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  def pullova = Action{
    Ok(views.html.pullova("Pullovas World"))
  }
  def showThePullova = Action{
    Ok(Json.obj(
      "pulli" -> Json.arr(
        Json.obj(
          "name" -> "Wolle",
          "surname" -> "Pullova",
          "level" -> "Jedi"
        ),Json.obj(
          "name" -> "Batman",
          "surname" -> "Wayne",
          "level" -> "Justice League"
        )
        )
    ) )
  }
  def mongotest = Action{
    Ok( object new mongoaction


    )
  }
}