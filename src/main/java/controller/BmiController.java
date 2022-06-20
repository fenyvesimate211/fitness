package controller;

import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class BmiController implements Initializable {

    public BmiController() {

    }

    @FXML
    private ChoiceBox<String> weightChoiceBox;
    @FXML
    private ChoiceBox<String> heightChoiceBox;

    private final String[] weight = {"kilogram", "gram", "pound (lb)"};
    private final String[] height = {"centimeter", "meter", "inch", "feet"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        weightChoiceBox.getItems().addAll(weight);
        heightChoiceBox.getItems().addAll(height);
    }

}
