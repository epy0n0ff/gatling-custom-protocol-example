package io.gatling.custom.protocol

import akka.actor.{ActorRef, ActorSystem}
import io.gatling.core.CoreComponents
import io.gatling.core.config.GatlingConfiguration
import io.gatling.core.protocol.{Protocol, ProtocolKey}
import io.gatling.custom.action.CustomRequestTrackingActor

object CustomProtocol {
  val CustomProtocolKey = new ProtocolKey {
    type Protocol = CustomProtocol
    type Components = CustomProtocolComponents

    override def protocolClass: Class[io.gatling.core.protocol.Protocol] = classOf[Protocol].asInstanceOf[Class[io.gatling.core.protocol.Protocol]]
    override def defaultProtocolValue(configuration: GatlingConfiguration): Protocol = throw new IllegalStateException("Can't provide a default value")

    override def newComponents(system: ActorSystem, coreComponents: CoreComponents): (Protocol) => Components = {
      val tracker = system.actorOf(CustomRequestTrackingActor.props(coreComponents.statsEngine, coreComponents.configuration), "customRequestTracker")
      customProtocol => CustomProtocolComponents(customProtocol,tracker)
    }
  }
}

case class CustomProtocol(customProtocol: CustomProtocol, actorRef: ActorRef) extends Protocol {
  type Components = CustomProtocolComponents
}