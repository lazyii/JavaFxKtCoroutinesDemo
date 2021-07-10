import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.20"
    application
    id("org.openjfx.javafxplugin") version "0.0.10"
    id("org.beryx.jlink") version "2.24.0"
}

//val compileKotlin: KotlinCompile by tasks
//val compileJava: JavaCompile by tasks
//compileJava.destinationDir = compileKotlin.destinationDir

application {
    mainModule.set("test.kotlin")
    mainClass.set("org.beryx.jlink.test.kotlin.JavaFX")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:1.5.1")
}

javafx {
    version = "16"
    modules = listOf("javafx.controls", "javafx.fxml", "javafx.web")
}

jlink{
    options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))
    mergedModuleName.set("org.merged.module")
    addExtraDependencies("javafx")
    mergedModule {
        additive = true
    }
    launcher {
        name = "hello"
    }
}
