module fenyvesi.fitnesz {
    requires javafx.controls;
    requires javafx.fxml;


    opens fenyvesi.fitnesz to javafx.fxml;
    exports fenyvesi.fitnesz;
}