import sbt._
import sbt.Keys._

object HierachicalclusteringBuild extends Build {

  lazy val hierachicalclustering = Project(
    id = "hierachicalclustering",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "HierachicalClustering",
      organization := "jp.asahima",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.11.2"
      // add other settings here
    )
  )
}
