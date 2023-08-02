module com.example.terminalpaiement {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens com.example.terminalpaiement.Views to javafx.fxml;
    exports com.example.terminalpaiement.Views;
    opens com.example.terminalpaiement.Controller to javafx.fxml;
    exports com.example.terminalpaiement.Controller;
}
