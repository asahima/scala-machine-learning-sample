import sbt._
import sbt.Keys._

object LeastsquaresBuild extends Build {

  lazy val leastsquares = Project(
    id = "leastsquares",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "LeastSquares",
      organization := "jp.asahima",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.11.2"
      // add other settings here
    )
  )
}
