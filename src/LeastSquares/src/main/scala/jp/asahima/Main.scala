package jp.asahima

import breeze.linalg._
import breeze.plot._

case class Data(x: Double, y: Double)

object Main {
  def main(args: Array[String]): Unit = {
    val datas = Array[Data](Data(4.0, 7.0), Data(8.0, 10.0), Data(13.0, 11.0), Data(17.0, 14.0))
    val value = leastSquares(datas)
    println(s"a:${value._1} b:${value._2}")

    val x = datas.map { data => data.x }
    val y = datas.map { data => data.y }
    val oy = datas.map { data => value._1 * data.x + value._2}

    // plot
    val f = Figure()
    val p = f.subplot(0)

    p += plot(x, y, '.')
    p += plot(x, oy)
    p.xlabel = "x"
    p.ylabel = "y"
  }

  def leastSquares(datas: Array[Data]): (Double, Double) = {
    val x_sum = datas.map { data => data.x }.sum
    val x_square_sum = datas.map { data => data.x * data.x }.sum
    val y_sum = datas.map { data => data.y }.sum
    val x_y_sum = datas.map { data => data.x * data.y }.sum

    val a = (((x_sum * y_sum) - (datas.length * x_y_sum)) / ((x_sum * x_sum) - (datas.length * x_square_sum)))
    val b = (((x_sum * x_y_sum) - (x_square_sum * y_sum)) / ((x_sum * x_sum) - (datas.length * x_square_sum)))

    (a, b)
  }
}
