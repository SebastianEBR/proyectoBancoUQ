module org.uniquindio.edu.co.poo.proyectobancouq {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.uniquindio.edu.co.poo.proyectobancouq to javafx.fxml;
    exports org.uniquindio.edu.co.poo.proyectobancouq;
    opens org.uniquindio.edu.co.poo.proyectobancouq.app to javafx.graphics;
}