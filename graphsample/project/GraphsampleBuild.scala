import sbt._
import sbt.Keys._

object GraphsampleBuild extends Build {

  lazy val graphsample = Project(
    id = "graphsample",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "graphSample",
      organization := "jp.asahima",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.11.2"
      // add other settings here
    )
  )
}
