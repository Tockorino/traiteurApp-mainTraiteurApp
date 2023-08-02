module com.example.boucherie {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;


    exports com.example.boucherie.Controleur;
    exports com.example.boucherie.Views;
    opens com.example.boucherie.Views to javafx.fxml;
}