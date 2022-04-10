module fitness {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.persistence;
    requires java.sql;
    requires java.desktop;

    opens model to javafx.fxml;
    exports model;

    exports controller;
    opens controller to javafx.fxml;
    exports application;
    opens application to javafx.fxml;
}