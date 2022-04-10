package controller;

import application.FitnessApplication;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Product;
import service.ProductService;
import service.ProductServiceImplementation;

import java.io.IOException;

public class AddProductController {

    @FXML
    private TextField productName;
    @FXML
    private TextField energy;
    @FXML
    private TextField protein;
    @FXML
    private TextField fat;
    @FXML
    private TextField carbs;
    @FXML
    private TextField sugar;
    @FXML
    private TextField fiber;

    public AddProductController() {
    }

    ProductService productService = new ProductServiceImplementation();
    FitnessApplication m = new FitnessApplication();

    @FXML
    public void backButtonClick() throws IOException {
        m.changeScene("/fxml/product.fxml");
    }

    @FXML
    public void addButtonClick() throws IOException {
        Product product = new Product(
                getProductName().getText(),
                Float.parseFloat(getEnergy().getText()),
                Double.parseDouble(getProtein().getText()),
                Double.parseDouble(getFat().getText()),
                Double.parseDouble(getCarbs().getText()),
                Double.parseDouble(getSugar().getText()),
                Double.parseDouble(getFiber().getText())
        );
        System.out.println(product.toString());
        productService.save(product);
        m.changeScene("/fxml/product.fxml");
    }

    public TextField getProductName() {
        return productName;
    }

    public TextField getEnergy() {
        return energy;
    }


    public TextField getProtein() {
        return protein;
    }

    public TextField getFat() {
        return fat;
    }

    public TextField getCarbs() {
        return carbs;
    }

    public TextField getSugar() {
        return sugar;
    }

    public TextField getFiber() {
        return fiber;
    }
}
