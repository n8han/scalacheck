name := "scalacheck"

version := "1.10-SNAPSHOT"

organization := "org.scala-tools.testing"

crossScalaVersions :=
  Seq("2.8.0", "2.8.1", "2.8.2", "2.9.0", "2.9.0-1", "2.9.1")

libraryDependencies <++= scalaVersion(version =>
  "org.scala-tools.testing" %  "test-interface" % "0.5" ::
  (for (v <- List(version) if v.startsWith("2.10"))
  yield ("org.scala-lang" % "scala-actors" % version))
)

javacOptions ++= Seq("-Xmx1024M")

scalacOptions += "-deprecation"

publishTo := Some("Scala Tools Nexus" at "http://nexus.scala-tools.org/content/repositories/snapshots/")

// publishTo := Some("Scala Tools Nexus" at "http://nexus.scala-tools.org/content/repositories/releases/")

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
