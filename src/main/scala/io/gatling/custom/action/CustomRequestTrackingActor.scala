package io.gatling.custom.action

import akka.actor.Props
import io.gatling.core.akka.BaseActor
import io.gatling.core.config.GatlingConfiguration
import io.gatling.core.stats.StatsEngine

object CustomRequestTrackingActor {
  def props(statsEngine: StatsEngine, configuration: GatlingConfiguration) :Props = Props(new CustomRequestTrackingActor(statsEngine,configuration))
}

class CustomRequestTrackingActor(statsEngine: StatsEngine, configuration: GatlingConfiguration) extends BaseActor {
  override def receive: Receive = ???
}
