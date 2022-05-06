module com.example.moduleequalitiesgenerator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens com.example.moduleequalitiesgenerator to javafx.fxml;
    exports com.example.moduleequalitiesgenerator;
}