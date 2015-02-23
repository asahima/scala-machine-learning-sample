name := "least squares"

version := "1"

scalaVersion := "2.11.2"

scalacOptions ++= Seq("-encoding", "UTF-8", "-deprecation")

libraryDependencies  ++= Seq(
  "org.scalanlp" %% "breeze" % "0.10",
  "org.scalanlp" %% "breeze-viz" % "0.10",
  "org.scalanlp" %% "breeze-natives" % "0.10"
)

resolvers ++= Seq(
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
)
