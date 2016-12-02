import sbt._

object Dependencies {
  val quicklens = "com.softwaremill.quicklens" %% "quicklens" % "1.4.8"
  val gatingCore = "io.gatling" % "gatling-core" % "2.2.3"
  val gatingChart = "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.3" % "test"
  val gatlingTest = "io.gatling" % "gatling-test-framework" % "2.2.3" % "test"
  val deps = Seq( gatingCore, gatingChart, gatlingTest, quicklens)
}
