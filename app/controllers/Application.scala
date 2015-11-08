package controllers

import play.api._
import play.api.mvc._
import reactivemongo.api.{MongoConnection, MongoDriver}
import sun.reflect.generics.reflectiveObjects.NotImplementedException
import play.api.libs.json.Json
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import play.api.libs.iteratee.Iteratee

import reactivemongo.bson.BSONDocument
import reactivemongo.api.collections.bson.BSONCollection


object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  def pullova = Action{
    Ok(views.html.pullova("Pullovas World"))
  }
  def showThePullova = Action(Ok(Json.obj("pulli" -> Json.arr(Json.obj("name" -> "Wolle", "surname" -> "Pullova", "level" -> "Jedi"), Json.obj("name" -> "Batman", "surname" -> "Wayne", "level" -> "Justice League")))))

//  def push(name: String) = Action(Ok )

  def mongo = Action{
    // see http://reactivemongo.org
      println("Hello Mongo")
      var dbpullis = new MongoDriver()
      var connection: MongoConnection = dbpullis.connection(List("52.32.119.129"))
      var db = connection("pullofans")
      var collection = db.collection[BSONCollection]("firstfans")

    def listDocs(collection: BSONCollection) = {
      val query = BSONDocument()
      val filter = BSONDocument()

      collection.
        find(query, filter).
        cursor[BSONDocument].
        enumerate().apply(Iteratee.foreach { doc =>

      })


      val futureList: Future[List[BSONDocument]] =
        collection.
          find(query, filter).
          cursor[BSONDocument].
          collect[List]()

      futureList.map { list =>
        list.foreach { doc =>
          println(s"found document: ${BSONDocument pretty doc}")
        }
      }
    }
    //val mdbdefi = connect()
    // val mdbefo = new BSONCollection()
    var mdebefa = listDocs(collection)
    var tisch = new table(2.3, 4, "holz")
    var tischname=  tisch.whois()


    println(tisch.n0legs().toString)
    println(collection.count())

    Ok(views.html.pullova(tischname.toString))
  }
}