import sbt._
import sbt.Keys._

object PerceptronBuild extends Build {

  lazy val perceptron = Project(
    id = "perceptron",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "Perceptron",
      organization := "jp.asahima",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.11.2"
      // add other settings here
    )
  )
}
