package io.gatling.custom.action

import com.typesafe.scalalogging.StrictLogging
import io.gatling.core.action.Action
import io.gatling.core.action.builder.ActionBuilder
import io.gatling.core.structure.ScenarioContext

class CustomActionBuilder extends  ActionBuilder with StrictLogging {
  override def build(ctx: ScenarioContext, next: Action): Action = {
    logger.debug("testtest")
    new CustomRequestAction(next,ctx.coreComponents.statsEngine)
  }
}
