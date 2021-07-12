package org.beryx.jlink.test.kotlin

import javafx.application.Application
import javafx.application.Platform
import javafx.beans.property.SimpleStringProperty
import javafx.event.ActionEvent
import javafx.event.EventHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ThreadLocalRandom


/**
 * @author wyd
 * @date 2021-07-10 13:16:47
 * @version 1.0 edit by wyd at 2021-07-10 13:16:47
 */
fun main(vararg args: String) {
    Application.launch(JavaFX::class.java, *args)
}

val userNameProperty = SimpleStringProperty("userNameProperty")

val btnHandler: EventHandler<ActionEvent> = EventHandler {
    GlobalScope.launch {
        println(this)
        println("click")
        delay(1000)
        userNameProperty.set("${LocalDateTime.now()}")
    }
}


val buttonHandler = EventHandler { event: ActionEvent? ->
    println(event?.eventType)
}
