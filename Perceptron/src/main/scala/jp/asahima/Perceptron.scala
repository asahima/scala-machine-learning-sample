package jp.asahima

import breeze.linalg._
import breeze.numerics._

class Perceptron {

  val weight = Seq[Double](0.0, 0.0)

  def train(datas: Seq[Data]): Unit = {
    val e = weight(0) * data.x + weight(1) * data.y
    if (data.label == true && e < 0.0) {
      weight(0) -= -1 * data.x
      weight(1) -= -1 * data.y
    } else if (data.label == false && e > 1.0) {
      weight(0) -= data.x
      weight(1) -= data.y
    }
  }

  def test(data: Data): Boolean = {
    val e = weight(0) * data.x + weight(1) * data.y
    if (e > 0) {
      println(true)
    } else {
      println(false)
    }
  }
}
