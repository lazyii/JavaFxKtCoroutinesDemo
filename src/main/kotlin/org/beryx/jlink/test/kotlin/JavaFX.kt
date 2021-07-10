package org.beryx.jlink.test.kotlin

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class JavaFX : Application() {

    override fun start(stage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("/fxml/HelloWorld.fxml"))

        stage.scene = Scene(root, 300.0, 200.0)

        GlobalScope.launch {
            println(this)
            println("sdlfjlsdjfksdf")
        }
        stage.show()
    }
}
