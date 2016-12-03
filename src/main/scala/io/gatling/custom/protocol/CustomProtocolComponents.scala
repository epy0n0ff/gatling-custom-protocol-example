package io.gatling.custom.protocol

import akka.actor.ActorRef
import io.gatling.core.protocol.ProtocolComponents
import io.gatling.core.session.Session

case class CustomProtocolComponents(customProtocol: CustomProtocol, tracker: ActorRef) extends ProtocolComponents {
  override def onStart: Option[(Session) => Session] = None

  override def onExit: Option[(Session) => Unit] = None
}
