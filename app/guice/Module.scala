package guice

import java.util.Calendar

import com.google.inject.AbstractModule
import services.{GreetingService, RealGreetingService}

class Module extends AbstractModule {

  override def configure() = {
    bind(classOf[Calendar])
    .toInstance(Calendar
                .getInstance())

    bind(classOf[GreetingService])
      .to(classOf[RealGreetingService])

  }
}
