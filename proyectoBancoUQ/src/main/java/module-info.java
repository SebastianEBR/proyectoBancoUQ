module org.uniquindio.edu.co.poo.proyectobancouq {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    exports org.uniquindio.edu.co.poo.proyectobancouq.viewController;
    opens org.uniquindio.edu.co.poo.proyectobancouq to javafx.fxml;
    opens org.uniquindio.edu.co.poo.proyectobancouq.viewController to javafx.fxml;
    opens org.uniquindio.edu.co.poo.proyectobancouq.app to javafx.graphics;
}