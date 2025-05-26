
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
import org.uniquindio.edu.co.poo.proyectobancouq.controller.AdminController;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;
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

    private AdminController adminController;

    // Método para recibir el controlador de lógica
    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    // Método para procesar el inicio de sesión del administrador con validación completa
    @FXML
    void IngresarComoAdmin(ActionEvent event) throws IOException {
        System.out.println("✅ Botón 'Ingresar' presionado.");

        // Verificación de que los campos están correctamente inyectados
        if (txtINgreseUsuario == null || txtIngreseCigoUnico == null || txtIngreseContraceña == null) {
            System.out.println("❌ Error: Campos no fueron correctamente inyectados desde el FXML.");
            return;
        }

        // Obtener valores ingresados
        String nombre = txtINgreseUsuario.getText();
        String idUnico = txtIngreseCigoUnico.getText();
        String contrasena = txtIngreseContraceña.getText();

        System.out.println("Verificando datos...");
        System.out.println("Usuario ingresado: " + nombre);
        System.out.println("Código Único ingresado: " + idUnico);
        System.out.println("Contraseña ingresada: " + contrasena);

        // Validación con nombre, ID único y contraseña
        Usuario admin = adminController.iniciarSesionAdmin(nombre, idUnico, contrasena);

        if (admin != null) {
            System.out.println("✅ Inicio de sesión exitoso.");
            App.app.setScene(Paths.REGISTRO_USUARIO); // Redirección a la pantalla del administrador
        } else {
            System.out.println("❌ Error en el inicio de sesión. Verifica los datos.");
        }
    }


    @FXML
    void RegresarAElccion(ActionEvent event) {

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
