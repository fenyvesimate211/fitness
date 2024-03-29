package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class FitnessApplication extends Application {

    public static Stage stage;

    public FitnessApplication() {
    }

    @Override
    public void start(Stage primaryStage) {

        try {
            stage = primaryStage;
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/add-product.fxml")));
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setTitle("Add product");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stage.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}