package io.gatling.custom.action

import io.gatling.commons.stats.OK
import io.gatling.core.action.{Action, ExitableAction}
import io.gatling.core.session._
import io.gatling.core.stats.StatsEngine
import io.gatling.core.stats.message.ResponseTimings
import io.gatling.core.util.NameGen

class CustomRequestAction(val next: Action, val statsEngine: StatsEngine) extends ExitableAction with NameGen {

  override def name: String = genName("customRequest")

  override def execute(session: Session): Unit = {
    val responseTimings = ResponseTimings(1, 100)
    statsEngine.logResponse(session, name, responseTimings, OK, None, None)
    next ! session.logGroupRequest(responseTimings.responseTime,OK)
  }
}
