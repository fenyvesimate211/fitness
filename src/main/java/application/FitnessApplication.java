package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class FitnessApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/login.fxml")));
            Scene scene = new Scene(root, 600, 400);
            stage.setTitle("Fitness application");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
//        FXMLLoader fxmlLoader = new FXMLLoader(FitnessApplication.class.getResource("/fxml/login.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 900, 800);
//        stage.setTitle("Fitness application");
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();
//    }

    public static void main(String[] args) {
        launch(args);
    }
}