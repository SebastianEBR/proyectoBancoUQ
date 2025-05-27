package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.uniquindio.edu.co.poo.proyectobancouq.app.App;
import org.uniquindio.edu.co.poo.proyectobancouq.controller.AdminController;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;
import org.uniquindio.edu.co.poo.proyectobancouq.utills.Paths;

public class IngresoDeCajero {

    private AdminController adminController; // 🔥 Agregar referencia

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    @FXML
    private Button btn;

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
        String idUnico = txtIngreseCigoUnico.getText();
        String contrasena = txtIngreseContraceña.getText();

        if (idUnico.isEmpty() || contrasena.isEmpty()) {
            System.out.println("⚠️ Error: Todos los campos deben estar completos.");
            return;
        }

        // 🔥 Usar AdminController para validar el inicio de sesión
        Usuario usuario = adminController.iniciarSesionCajero(idUnico, contrasena);

        if (usuario != null) {
            System.out.println("✅ Acceso concedido: " + usuario.getNombre());
            // Aquí puedes cambiar de escena o cargar la interfaz del cajero
        } else {
            System.out.println("❌ Error: Credenciales incorrectas o el usuario no es un cajero.");
        }

        App.app.setScene(Paths.FUNCIONNES_CAJERO);
    }


    @FXML
    void RegresarAElccion(ActionEvent event) {
        App.app.setScene(Paths.ELECCION_USUARIO);


    }

}
