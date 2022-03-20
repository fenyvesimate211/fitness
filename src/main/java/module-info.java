module fitness {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.persistence;
    requires java.sql;


    exports controller;
    opens controller to javafx.fxml;
    exports application;
    opens application to javafx.fxml;
}