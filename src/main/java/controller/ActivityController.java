package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ActivityController implements Initializable {

    @FXML
    private ChoiceBox<String> duration;

    @FXML
    private ChoiceBox<String> distance;

    private final String[] Duration = {"hour", "minute"};

    private final String[] Distance = {"km", "meter"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        duration.getItems().addAll(Duration);
        distance.getItems().addAll(Distance);
    }
}
