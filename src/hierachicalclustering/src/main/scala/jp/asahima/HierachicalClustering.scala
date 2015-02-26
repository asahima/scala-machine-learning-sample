package jp.asahima

import scala.math.{sqrt}

case class Data(x: Double, y: Double)

case class Cluster(datas: Array[Data]) {
  def centroid(): Data = {
    val x = datas.map { data => data.x }.sum / datas.length
    val y = datas.map { data => data.y }.sum / datas.length
    Data(x, y)
  }

  def add(cluster: Cluster): Unit = {
    datas ++ cluster.datas
  }
}

object HC {
  def run(datas : Array[Data], num : Int): Array[Cluster] = {
    var clusters = init(datas)
    var minLength = Double.MaxValue
    var c1 = 0
    var c2 = 0

    // not yet implemented
    for (i <- 0 until datas.length; j <- 0 until i) {
      var distance = getDistance(datas(i), datas(j))
      if (minLength > distance) {
        minLength = distance
        c1 = i
        c2 = j
      }
    }
    clusters
  }

  def init(datas: Array[Data]): Array[Cluster] = {
    datas.map { data => Cluster(Array[Data](data)) }
  }

  def getDistance(d1: Data, d2: Data): Double = {
    return sqrt((d2.x - d1.x) + (d2.y - d1.y))
  }
}
