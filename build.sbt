name := """play-guice-typed-akka"""

version := "999-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
//  jdbc,
//  cache,
//  ws,
  "com.google.inject.extensions" % "guice-assistedinject" % "4.0",
  "com.typesafe.akka"   %% "akka-actor"   % "2.4.4",
  "com.typesafe.akka"   %% "akka-testkit" % "2.4.4"     % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test

// TODO Try as an alternative to scalatestplus?
//"org.scalatest" %% "scalatest" % "2.2.2" % scope,
//"com.typesafe.play" %% "play-test" % PlayVersion.current % scope
)
