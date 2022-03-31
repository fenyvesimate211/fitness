package controller;

import application.FitnessApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    public LoginController() {
    }

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrongLogin;

    FitnessApplication m = new FitnessApplication();

    public void userLogin() throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        if (username.getText().equals("admin") && password.getText().equals("admin")) {
            wrongLogin.setText("Success");
            m.changeScene("/fxml/product.fxml");
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
