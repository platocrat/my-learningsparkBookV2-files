package example

import scala.concurrent._, duration._
import core.Weather

object Hello extends App {
  val w = Await.result(Weather.weather, 10.seconds)
  println("Hello! The weather in New York is $w.")
  Weather.http.close()
}
