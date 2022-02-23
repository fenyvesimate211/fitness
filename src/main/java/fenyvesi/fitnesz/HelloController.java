package fenyvesi.fitnesz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label userProfileText;

    @FXML
    protected void onHelloButtonClick() {
        userProfileText.setText("Welcome to JavaFX Application!");
    }
}