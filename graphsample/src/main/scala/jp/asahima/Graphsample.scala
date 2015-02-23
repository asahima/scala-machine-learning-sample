package jp.asahima

import breeze.linalg._
import breeze.numerics._
import breeze.plot._

import scala.util.Random

object Graphsample {
  def main(args: Array[String]): Unit = {
    plotImage()
  }

  def defaultPlot(): Unit = {
    val x = linspace(-3.0, 3.0)
    val y = sin(x)

    val f = Figure()
    val p = f.subplot(0)
    p += plot(x, y)
  }

  def plotImage(): Unit = {
    val x = Array.fill(30)(Random.nextInt(10)).map { _.toDouble }
    val y = sin(x)

    val f = Figure()
    val p = f.subplot(0)
    p += plot(x, y, '+')
  }
}
