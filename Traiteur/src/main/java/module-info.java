module com.example.traiteur {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    //opens com.example.traiteur to javafx.fxml;
    exports com.example.traiteur.Models;
    exports com.example.traiteur.Controller;
    opens com.example.traiteur.Controller to javafx.fxml;
    exports com.example.traiteur.Views;
    opens com.example.traiteur.Views to javafx.fxml;

}