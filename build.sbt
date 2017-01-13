name := "streaming-alert"

version := "1.0"

scalaVersion := "2.11.8"

crossScalaVersions ++= Seq("2.10.5", "2.11.2")

libraryDependencies += "com.flyberrycapital" %% "scala-slack" % "0.3.0"

libraryDependencies += "com.typesafe" % "config" % "1.3.1"

libraryDependencies += "org.apache.flume" % "flume-ng-core" % "1.5.0"

libraryDependencies += "org.apache.flume" % "flume-ng-sdk" % "1.5.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

// Publish settings

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT"))

homepage := Some(url("https://github.com/prayagupd/streaming-alert"))

pomExtra := (
  <scm>
    <url>git@github.com:prayagupd/streaming-alert.git</url>
    <connection>git@github.com:prayagupd/streaming-alert.git</connection>
  </scm>
    <developers>
      <developer>
        <id>prayagupd</id>
        <name>prayagupd</name>
        <url>https://github.com/prayagupd</url>
      </developer>
    </developers>)