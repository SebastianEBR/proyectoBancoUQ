package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.uniquindio.edu.co.poo.proyectobancouq.app.App;
import org.uniquindio.edu.co.poo.proyectobancouq.controller.AdminController;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;
import org.uniquindio.edu.co.poo.proyectobancouq.utills.Paths;

public class IngresoAdmin {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button btnIngresar, btnRegresar;
    @FXML
    private TextField txtIngreseUsuario;
    @FXML
    private PasswordField txtIngreseCigoUnico, txtIngreseContraceña;

    private AdminController adminController;

    // Método para recibir el controlador
    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    // Método para procesar el inicio de sesión del administrador con validación completa
    @FXML
    void IngresarComoAdmin(ActionEvent event) throws IOException {
        System.out.println("✅ Botón 'Ingresar' presionado.");

        if (adminController == null) {
            System.out.println("❌ Error: `adminController` no fue inicializado correctamente.");
            mostrarAlerta("❌ Error interno. Intente nuevamente.");
            return;
        }

        // Obtener valores ingresados
        String nombre = txtIngreseUsuario.getText();
        String idUnico = txtIngreseCigoUnico.getText();
        String contrasena = txtIngreseContraceña.getText();

        // Validación de campos vacíos
        if (nombre.isEmpty() || idUnico.isEmpty() || contrasena.isEmpty()) {
            mostrarAlerta("❌ Todos los campos deben estar completos.");
            return;
        }

        System.out.println("Verificando datos...");
        System.out.println("Usuario ingresado: " + nombre);
        System.out.println("Código Único ingresado: " + idUnico);
        System.out.println("Contraseña ingresada: " + contrasena);

        // Validación con nombre, ID único y contraseña
        Usuario admin = adminController.iniciarSesionAdmin(nombre, idUnico, contrasena);

        if (admin != null) {
            System.out.println("✅ Inicio de sesión exitoso.");
            App.app.setScene(Paths.REGISTRO_USUARIO);
        } else {
            System.out.println("❌ Error en el inicio de sesión. Verifica los datos.");
            mostrarAlerta("❌ Credenciales incorrectas. Intente nuevamente.");
        }
    }

    @FXML
    void RegresarAElccion(ActionEvent event) throws IOException {
        App.app.setScene(Paths.ELECCION_USUARIO);
    }

    @FXML
    void EditarUsuario(ActionEvent event) {
        System.out.println("✅ Método EditarUsuario ejecutado.");
    }

    @FXML
    void initialize() {
        assert btnIngresar != null : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'IngresoAdministrador.fxml'.";
        assert btnRegresar != null : "fx:id=\"btnRegresar\" was not injected: check your FXML file 'IngresoAdministrador.fxml'.";
        assert txtIngreseUsuario != null : "fx:id=\"txtIngreseUsuario\" was not injected: check your FXML file 'IngresoAdministrador.fxml'.";
        assert txtIngreseCigoUnico != null : "fx:id=\"txtIngreseCigoUnico\" was not injected: check your FXML file 'IngresoAdmin.fxml'.";
        assert txtIngreseContraceña != null : "fx:id=\"txtIngreseContraceña\" was not injected: check your FXML file 'IngresoAdmin.fxml'.";

        if (adminController == null) {
            System.out.println("⚠️ adminController es NULL. Verifica que se asigna en App.java.");
        }else{
            System.out.println("✅ adminController fue inicializado correctamente.");
        }


    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Inicio de Sesión");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}