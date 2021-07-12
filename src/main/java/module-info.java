module test.kotlin {
    requires kotlin.stdlib;
    requires kotlinx.coroutines.core.jvm;
    requires kotlinx.coroutines.javafx;

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;

    exports org.beryx.jlink.test.kotlin;
    exports org.rainday.avaj.mvvm;

    opens org.rainday.avaj.mvvm;
}
