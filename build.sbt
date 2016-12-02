import Dependencies._

enablePlugins(GatlingPlugin)

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xlint",
  "-Ywarn-unused",
  "-Ywarn-unused-import"
)

lazy val `gatling-custom-protocol-example` = (project in file("."))
  .settings(
    name := "gatling-custom-protocol-example",
    version := "1.0",
    scalaVersion := "2.11.8",
    libraryDependencies ++= deps
  )