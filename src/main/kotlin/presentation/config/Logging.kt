package presentation.config

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.calllogging.CallLogging
import io.ktor.server.routing.Route
import org.slf4j.event.Level


fun Application.configureLogging() {
    // Configure logging settings here
    // You can use Ktor's built-in logging features or integrate with external logging libraries
    install(CallLogging){
        level = Level.DEBUG
    }
}