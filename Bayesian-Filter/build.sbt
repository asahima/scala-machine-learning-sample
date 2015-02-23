name := "bayesian filter"

version := "1"

scalaVersion := "2.11.2"

scalacOptions ++= Seq("-encoding", "UTF-8")

resolvers += "Atilika Open Source repository" at "http://www.atilika.org/nexus/content/repositories/atilika"

libraryDependencies ++=  Seq(
  "org.atilika.kuromoji" % "kuromoji" % "0.7.7"
)
