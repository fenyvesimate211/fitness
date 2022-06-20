package controller;
import javax.swing.JOptionPane;

import application.FitnessApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Product;
import service.ProductService;
import service.ProductServiceImplementation;

import java.io.IOException;

public class ProductController {

    public ProductController() {
    }

    FitnessApplication m = new FitnessApplication();

    ProductService productService = new ProductServiceImplementation();
    ObservableList<Product> data = FXCollections.observableArrayList(productService.findAll());

    @FXML
    private TableView<Product> table_view_product;

    @FXML
    private TableColumn<Product, String> column_product;

    @FXML
    private TableColumn<Product, Float> column_energy;

    @FXML
    private TableColumn<Product, Double> column_protein;

    @FXML
    private TableColumn<Product, Double> column_fat;

    @FXML
    private TableColumn<Product, Double> column_carbs;

    @FXML
    private TableColumn<Product, Double> column_sugar;

    @FXML
    private TableColumn<Product, Double> column_fiber;

    @FXML
    void initialize() {
        final ObservableList<Product> products = FXCollections.observableArrayList(data);
        table_view_product.setItems(products);
        initColumn();
    }

    private void initColumn() {
        column_product.setCellValueFactory(new PropertyValueFactory<>("product"));
        column_energy.setCellValueFactory(new PropertyValueFactory<>("energy"));
        column_protein.setCellValueFactory(new PropertyValueFactory<>("protein"));
        column_fat.setCellValueFactory(new PropertyValueFactory<>("fat"));
        column_carbs.setCellValueFactory(new PropertyValueFactory<>("carbs"));
        column_sugar.setCellValueFactory(new PropertyValueFactory<>("sugar"));
        column_fiber.setCellValueFactory(new PropertyValueFactory<>("fiber"));
    }
    
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
        int dialogButton = JOptionPane.INFORMATION_MESSAGE;
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
