package ru.demox_bank // ktlint-disable filename // ktlint-disable package-name

import io.ktor.server.cio.* // ktlint-disable no-wildcard-imports
import io.ktor.server.engine.* // ktlint-disable no-wildcard-imports
import org.jetbrains.exposed.sql.Database
import ru.demox_bank.features.register.routing.configureRegisterRouting
import ru.demox_bank.plugins.configureRouting
import ru.demox_bank.utils.configureSerialization

fun main() {
    Database.connect(
        "jdbc:postgresql://localhost:5432/kmm_damox_bank",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "postgres"
    )

    embeddedServer(CIO, port = 8081, host = "localhost") {
        configureSerialization()
        configureRouting()
        configureRegisterRouting()
    }.start(wait = true)
}
