package controller;

import application.FitnessApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class FoodController {

    FitnessApplication m = new FitnessApplication();

    @FXML
    public void addButtonClick(ActionEvent actionEvent) {
        //TODO
    }

    @FXML
    public void modifyButtonClick(ActionEvent actionEvent) {
        //TODO
    }

    @FXML
    public void deleteButtonClick(ActionEvent actionEvent) {
        //TODO
    }

    @FXML
    public void backButtonClick(ActionEvent actionEvent) throws IOException {
        m.changeScene("/fxml/login.fxml");
    }
}
