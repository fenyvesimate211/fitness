package controller;

import application.FitnessApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class FoodController {

    FitnessApplication m = new FitnessApplication();

    @FXML
    public GridPane table_view_food;
    
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
    public void backButtonClick() throws IOException {
        m.changeScene("/fxml/login.fxml");
    }
}
