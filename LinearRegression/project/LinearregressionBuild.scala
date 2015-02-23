import sbt._
import sbt.Keys._

object LinearregressionBuild extends Build {

  lazy val linearregression = Project(
    id = "linearregression",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "LinearRegression",
      organization := "jp.asahima",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.11.2"
      // add other settings here
    )
  )
}
