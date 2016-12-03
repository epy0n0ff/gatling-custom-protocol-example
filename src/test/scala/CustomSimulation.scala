import io.gatling.core.Predef._
import io.gatling.custom.action.CustomActionBuilder

import scala.concurrent.duration._

class CustomSimulation extends Simulation {
  val scn = scenario("custom")
  .repeat(100) {
    exec(new CustomActionBuilder())
  }
  setUp(scn.inject(rampUsers(1) over (10 second)))
}
