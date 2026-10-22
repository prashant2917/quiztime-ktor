package presentation.config

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation

fun Application.configureSerialization() {
    // Configure serialization settings here
    install(ContentNegotiation) {
        // Add serialization formats (e.g., JSON, XML) as needed
        json()
    }
}