module fenyvesi.fitnesz {
    requires javafx.controls;
    requires javafx.fxml;


    opens fenyvesi.fitness to javafx.fxml;
    exports fenyvesi.fitness;
}