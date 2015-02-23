package jp.asahima

import scala.math._
import scala.collection.mutable.{Map, ArrayBuffer}

class NaiveBayes {

  var wordSet : Set[String] = Set[String]()
  var wordCount : Map[String, Map[String, Int]] = Map[String, Map[String, Int]]()
  var catCount : Map[String, Int] = Map[String, Int]()

  def wordsOfCat(cat: String, words: Array[Word]): Array[String] = {
    val w = ArrayBuffer[String]()
    for (word <- words) {
      if (word.cat == cat) {
        w += word.surface
      }
    }
    w.toArray
  }

  def train(words: Array[Word]): Unit = {
    words.foreach { word => wordSet + word.surface }
    val catSet = words.map { word => word.cat }

    catCount = (Map.empty[String, Int] /: words) { (c, w) =>
      c + (w.cat -> (c.getOrElse(w.cat, 0) + 1))
    }

    catSet.foreach { cat =>
      val wordsofcat = wordsOfCat(cat, words)
      val count = (Map.empty[String, Int] /: words) { (c, w) =>
        c + (w.surface -> (c.getOrElse(w.surface, 0) + 1))
      }
      wordCount += (cat -> count)
    }
  }

  def classifier(words: Array[Word]): String = {
    var best : String = ""
    var s : Double = Double.MinValue

    val w = words.map {word => word.surface }

    for (cat <- catCount.keys) {
      var prob = score(w, cat)
      if (prob > s) {
        best = cat
        s = prob
      }
    }
    best
  }

  def score(words: Array[String], cat: String): Double = {
    var s = log(priorProb(cat))
    words.foreach { word =>
      s += log(wordProb(word, cat))
    }
    s
  }

  def wordProb(word: String, cat: String): Double = {
    (inCategory(word, cat).toDouble + 1.0) / (wordSet.size.toDouble + wordCount(cat).values.sum.toDouble)
  }

  def priorProb(cat: String): Double = {
    // カテゴリの事前確率
    catCount.get(cat) match {
      case Some(c) => (c.toDouble / catCount.values.sum.toDouble)
      case None => 0.0
    }
  } 

  def inCategory(word: String, cat:String): Double = {
    // カテゴリにおける単語の出現回数
    wordCount.get(cat) match {
      case Some(c) => c.get(word) match {
        case Some(v) => v
        case None => 0.0
      }
      case None => 0.0
    }
  }
}
