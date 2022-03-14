package controller;

import application.FitnessApplication;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrongLogin;

    FitnessApplication m = new FitnessApplication();

    public LoginController() {

    }

    public void userLogin() throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        if (username.getText().equals("admin") && password.getText().equals("admin")) {
            wrongLogin.setText("Success");
            m.changeScene("/fxml/food.fxml");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()){
            wrongLogin.setText("Please enter your data");
        } else {
            wrongLogin.setText("Wrong Username or Password");
        }
    }

    public void userRegister () throws IOException {
        m.changeScene("/fxml/user.fxml");
    }
}
