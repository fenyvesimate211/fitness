package controller;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AddFood;
import model.Product;
import service.ProductService;
import service.ProductServiceImplementation;

import java.net.URL;
import java.util.ResourceBundle;


public class AddFoodController implements Initializable {

    public AddFoodController() {

    }

    @FXML
    private ChoiceBox<String> productName;

    @FXML
    private ChoiceBox<String> productAmount;

    @FXML
    private TableView<AddFood> table_view;

    @FXML
    public TableColumn<AddFood, String> productname;

    @FXML
    public TableColumn<AddFood, String> productamount;

    @FXML
    public TableColumn<AddFood, String> date;

    private final String[] name = {"Apple",
            "Banana" ,
            "Beer" ,
            "Boiled lentils" ,
            "Chicken brest" ,
            "Chicken liver" ,
            "Cow milk (1.5%)" ,
            "Cow milk (2.8%)" ,
            "Egg" ,
            "Lemon" ,
            "Pear" ,
            "Poppy seed" ,
            "Potato" ,
            "Potato bread" ,
            "Red wine" ,
            "Sour cream (12%)" ,
            "Sour cream (20%)" ,
            "Strawberry" ,
            "Walnut" ,
            "White Bread" ,
            "White wine"};
    private final String[] amount = {"grams", "pieces"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productName.getItems().addAll(name);
        productAmount.getItems().addAll(amount);
        productname.setCellValueFactory(new PropertyValueFactory<>("Name"));
        productamount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        table_view.setItems(addFoods);
    }

    private final ObservableList<AddFood> addFoods = FXCollections.observableArrayList(
            new AddFood("Apple", "100 grams", "2022. 04. 12. 12:34:05"),
            new AddFood("Banana", "1 piece", "2022. 04. 12. 12:36:24"),
            new AddFood("Pear", "1 piece", "2022. 04. 12. 12:37:46"),
            new AddFood("Strawberry", "5 pieces", "2022. 04. 12. 12:38:14"),

            new AddFood("Egg", "2 pieces", "2022. 04. 13. 08:15:20"),
            new AddFood("Chicken brest", "250 grams", "2022. 04. 13. 17:49:09"),
            new AddFood("Potato", "3 pieces", "2022. 04. 13. 17:50:34")
            );
}
