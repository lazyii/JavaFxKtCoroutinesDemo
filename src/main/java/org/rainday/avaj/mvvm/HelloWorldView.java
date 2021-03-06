package org.rainday.avaj.mvvm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.beryx.jlink.test.kotlin.LauncherKt;

public class HelloWorldView implements Initializable {
    @FXML
    private Label helloLabel;

    @FXML
    private TextField userName;

    @FXML
    private Button button;

    private HelloWorldViewModel viewModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewModel = new HelloWorldViewModel();

        helloLabel.textProperty().bindBidirectional(viewModel.helloMessageProperty());
        //userName.textProperty().bindBidirectional(viewModel.userNameProperty());
        userName.textProperty().bindBidirectional(LauncherKt.getUserNameProperty());
        button.setOnAction(LauncherKt.getBtnHandler());
    }
}
