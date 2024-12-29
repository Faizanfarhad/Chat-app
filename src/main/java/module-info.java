module com.myapp.hellothere {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires javafx.graphics;
    requires java.desktop;
    requires java.sql;
    requires jbcrypt;

    opens com.myapp.hellothere to javafx.fxml;
    exports com.myapp.hellothere;
    exports AppStart to javafx.graphics;
}