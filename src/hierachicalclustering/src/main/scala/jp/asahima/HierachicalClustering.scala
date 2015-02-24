package jp.asahima

import scala.math.{sqrt}

case class Data(x: Int, y: Int)

case class Cluster(datas: Array[Data]) {
  var datas = datas

  def centroid(): Data = {
    val x = datas.map { datas => datas.x }.sum / datas.length
    val y = datas.map { datas => datas.y }.sum / datas.length
    Data(x, y)
  }

  def add(cluster: Cluster): Unit = {
    datas = datas ++ cluster.datas
  }
}

class HC(val clusters: Array[clusters], num: Int) {
  def run(): Array[Cluster] = {
    val minLength = Double.MaxValue
    var c1 = 0
    var c2 = 0

    for (i <- 0 until datas.length; j <- 0 until i) {
      var distance = getDistance(datas(i), datas(j))
      if (minLength > distance) {
        minLength = distance
        c1 = i
        c2 = j
      }
    }
  }

  def getDistance(d1: Data, d2: Data): Double = {
    return sqrt((d2.x - d1.x) + (d2.y - d1.y))
  }
}
