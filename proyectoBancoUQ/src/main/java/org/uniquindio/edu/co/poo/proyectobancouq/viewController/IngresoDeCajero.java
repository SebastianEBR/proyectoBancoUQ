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
import org.uniquindio.edu.co.poo.proyectobancouq.controller.CajeroController;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;
import org.uniquindio.edu.co.poo.proyectobancouq.utills.Paths;

public class IngresoDeCajero {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn, btnRegresar;

    @FXML
    private TextField txtINgreseUsuario;

    @FXML
    private PasswordField txtIngreseCigoUnico, txtIngreseContraceña;

    private CajeroController cajeroController;

    // Método para recibir el controlador de lógica
    public void setCajeroController(CajeroController cajeroController) {
        this.cajeroController = cajeroController;
    }

    // Método para procesar el inicio de sesión
    @FXML
    void IngresarComoCajero(ActionEvent event) throws IOException {
        String nombre = txtINgreseUsuario.getText();
        String idUnico = txtIngreseCigoUnico.getText();
        String contrasena = txtIngreseContraceña.getText();

        Usuario cajero = cajeroController.iniciarSesion(nombre, idUnico, contrasena);

        if (cajero != null) {
            System.out.println("✅ Inicio de sesión exitoso.");
            App.app.setScene(Paths.FUNCIONNES_CAJERO); // Redirección a la pantalla del cajero
        } else {
            System.out.println("❌ Error en el inicio de sesión. Verifica los datos.");
        }

        txtINgreseUsuario.setText("");
        txtIngreseCigoUnico.setText("");
        txtIngreseContraceña.setText("");
    }

    @FXML
    void RegresarAElccion(ActionEvent event) throws IOException {
        App.app.setScene(Paths.ELECCION_USUARIO);
    }

    @FXML
    void initialize() {
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'IngresoDeCajero.fxml'.";
        assert btnRegresar != null : "fx:id=\"btnRegresar\" was not injected: check your FXML file 'IngresoDeCajero.fxml'.";
        assert txtINgreseUsuario != null : "fx:id=\"txtINgreseUsuario\" was not injected: check your FXML file 'IngresoDeCajero.fxml'.";
        assert txtIngreseCigoUnico != null : "fx:id=\"txtIngreseCigoUnico\" was not injected: check your FXML file 'IngresoDeCajero.fxml'.";
        assert txtIngreseContraceña != null : "fx:id=\"txtIngreseContraceña\" was not injected: check your FXML file 'IngresoDeCajero.fxml'.";
    }
}
