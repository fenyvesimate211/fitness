package controller;
import javax.swing.JOptionPane;
import application.FitnessApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ProductController {

    public ProductController() {
    }

    FitnessApplication m = new FitnessApplication();

    @FXML
    public GridPane table_view_food;
    
    @FXML
    public void addButtonClick() throws IOException {
        m.changeScene("/fxml/add-product.fxml");
    }

    @FXML
    public void modifyButtonClick(ActionEvent actionEvent) {
        //TODO
    }

    @FXML
    public void deleteButtonClick(ActionEvent actionEvent) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you really want to delete?", "Delete", dialogButton);
        if(dialogResult == 0) {
            System.out.println("Yes, delete");
        } else {
            System.out.println("No, don't delete");
        }
        //TODO message box for deleting
    }

    @FXML
    public void backButtonClick() throws IOException {
        m.changeScene("/fxml/login.fxml");
    }
}
