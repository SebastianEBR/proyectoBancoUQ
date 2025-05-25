package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.uniquindio.edu.co.poo.proyectobancouq.app.App;
import org.uniquindio.edu.co.poo.proyectobancouq.utills.Paths;

public class IngresoAdmin {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnRegresar;

    @FXML
    private TextField txtINgreseUsuario;

    @FXML
    private PasswordField txtIngreseCigoUnico;

    @FXML
    private PasswordField txtIngreseContraceña;

    @FXML
    void IngresarComoCajero(ActionEvent event) {

    }

    @FXML
    void RegresarAElccion(ActionEvent event) throws IOException {
        App.app.setScene(Paths.ELECCION_USUARIO);

    }

    @FXML
    void initialize() {
        assert btnIngresar != null : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'IngresoAdministrador.fxml'.";
        assert btnRegresar != null : "fx:id=\"btnRegresar\" was not injected: check your FXML file 'IngresoAdministrador.fxml'.";
        assert txtINgreseUsuario != null : "fx:id=\"txtINgreseUsuario\" was not injected: check your FXML file 'IngresoAdministrador.fxml'.";
        assert txtIngreseCigoUnico != null : "fx:id=\"txtIngreseCigoUnico\" was not injected: check your FXML file 'IngresoAdministrador.fxml'.";
        assert txtIngreseContraceña != null : "fx:id=\"txtIngreseContraceña\" was not injected: check your FXML file 'IngresoAdministrador.fxml'.";

    }

}

