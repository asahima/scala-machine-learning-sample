package jp.asahima

import breeze.linalg._
import breeze.numerics._
import breeze.plot._
import breeze.stats.distributions.{Gaussian}

case class Data(x: Double, y:Double, label: Boolean)

object Main {
  def main(args: Array[String]): Unit = {
    val datas = genSampleData(1000)
    val p = new Perceptron
  }

  def genImage(datas: Seq[Data], weight: Seq[Double]): Unit = {
    val f = Figure()
    val p = f.subplot(0)

    val tData = datas.filter(_.label == true)
    val fData = datas.filter(_.label == false)

    val tx = tData.map { _.x }
    val ty = tData.map { _.y }

    val fx = fData.map { _.x }
    val fy = fData.map { _.y }

    p += plot(tx, ty, '.', colorcode = "red")
    p += plot(fx, fy, '.', colorcode = "blue")
  }

  def genSampleData(num: Int): Seq[Data] = {
    val gauss = Gaussian(0, 1)
    val f = ((x:Double, y:Double) => if (3*x-2*y > 0.0) true else false )
    
    val datas = (0 until num) map { i =>
      val x = gauss.sample
      val y = gauss.sample
      Data(x, y, f(x, y))
    }
    datas
  }
}
