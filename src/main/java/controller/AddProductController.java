package controller;

import application.FitnessApplication;
import javafx.fxml.FXML;

import java.io.IOException;

public class AddProductController {

    public AddProductController() {

    }

    @FXML

    FitnessApplication m = new FitnessApplication();

    @FXML
    public void backButtonClick() throws IOException {
        m.changeScene("/fxml/product.fxml");
    }
}
