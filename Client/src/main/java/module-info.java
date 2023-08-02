module com.example.client {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens com.example.client.Views to javafx.fxml;
    opens com.example.client.Controller to javafx.fxml;
    exports com.example.client.Views;
    exports com.example.client.Controller;
}