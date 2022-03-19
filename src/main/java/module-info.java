module fitness {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires javax.persistence;


    exports controller;
    opens controller to javafx.fxml;
    exports application;
    opens application to javafx.fxml;
}