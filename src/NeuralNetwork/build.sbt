name := "NeuralNetwork"

version := "1.0"

scalaVersion := "2.11.5"

scalacOptions ++= Seq("-encoding", "UTF-8")

libraryDependencies  ++= Seq(
    "org.scalanlp" %% "breeze" % "0.10",
    "org.scalanlp" %% "breeze-viz" % "0.10",
    "org.scalanlp" %% "breeze-natives" % "0.10",
    "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

resolvers ++= Seq(
    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
    "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
)
