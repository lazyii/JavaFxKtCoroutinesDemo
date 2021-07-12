plugins {
    kotlin("jvm") version "1.5.20"
    application
    id("org.openjfx.javafxplugin") version "0.0.10"
    id("org.beryx.jlink") version "2.24.0"
}

// because of this bug(https://youtrack.jetbrains.com/issue/KTIJ-18424),pls use gradlew run in console,instead of execute it in idea.
// step 1: set JAVA_HOME="C:\Program Files\Java\jdk-16.0.1+9"
// step 2: gradlew run
application {
    mainModule.set("test.kotlin")
    mainClass.set("org.beryx.jlink.test.kotlin.JavaFX")
    applicationDefaultJvmArgs = listOf("--add-reads", "kotlin.stdlib=kotlinx.coroutines.core.jvm")
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
    launcher {
        name = "hello"
    }
}

val JavaVersionCurrent = JavaVersion.VERSION_16
tasks {
    compileJava {
        dependsOn(compileKotlin)
        sourceCompatibility = JavaVersionCurrent.majorVersion
        targetCompatibility = JavaVersionCurrent.majorVersion
        //modularity.inferModulePath.set(true)
    }
    compileKotlin {
        kotlinOptions {
            sourceCompatibility = JavaVersionCurrent.majorVersion
            targetCompatibility = JavaVersionCurrent.majorVersion
            jvmTarget = JavaVersionCurrent.majorVersion
            apiVersion = "1.5" // kotlin api version
            languageVersion = "1.5" // kotlin language version
        }
    }
    test {
        useJUnitPlatform()
    }
}
