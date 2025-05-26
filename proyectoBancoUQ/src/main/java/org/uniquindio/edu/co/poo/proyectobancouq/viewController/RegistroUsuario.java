package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.uniquindio.edu.co.poo.proyectobancouq.controller.CrudUsuarioController;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Admin;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Cajero;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;

public class RegistroUsuario {

    private CrudUsuarioController usuarioController;

    // 🔹 Constructor vacío necesario para JavaFX
    public RegistroUsuario() {}

    // 🔹 Método para asignar el controlador después de la carga FXML
    public void setCrudUsuarioController(CrudUsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    @FXML
    private Button btnRegistrar;

    @FXML
    private ComboBox<String> cbCargo;

    @FXML
    private TableView<Usuario> tableUsuarios;

    @FXML
    private TextField txtClave;
    @FXML
    private TextField txtCodigoUnico;
    @FXML
    private TextField txtCorreoElectronico;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtNumIdentificacion;

    @FXML
    void RegistrarUsuario(ActionEvent event) {
        System.out.println("✅ Botón Registrar presionado."); // Verificación en consola

        if (usuarioController == null) {
            System.out.println("⚠️ usuarioController es NULL. No se puede registrar el usuario.");
            return;
        }

        String nombre = txtNombre.getText().trim();
        String correo = txtCorreoElectronico.getText().trim();
        String clave = txtClave.getText().trim();
        String numIdentificacion = txtNumIdentificacion.getText().trim();
        String codigoUnico = txtCodigoUnico.getText().trim();
        String cargoSeleccionado = cbCargo.getValue();

        if (nombre.isEmpty() || correo.isEmpty() || clave.isEmpty() || numIdentificacion.isEmpty() || cargoSeleccionado == null) {
            System.out.println("⚠️ Todos los campos deben estar llenos para registrar un usuario.");
            return;
        }

        Usuario nuevoUsuario;

        if ("Administrador".equalsIgnoreCase(cargoSeleccionado)) {
            nuevoUsuario = new Admin(numIdentificacion, nombre, correo, clave, codigoUnico);
        } else if ("Cajero".equalsIgnoreCase(cargoSeleccionado)) {
            nuevoUsuario = new Cajero(numIdentificacion, nombre, correo, clave, codigoUnico);
        } else {
            System.out.println("❌ Cargo inválido. No se puede registrar el usuario.");
            return;
        }

        if (usuarioController.registrarUsuario(nuevoUsuario)) {
            tableUsuarios.getItems().add(nuevoUsuario);
            System.out.println("✅ Usuario registrado correctamente.");
        } else {
            System.out.println("❌ Error al registrar usuario.");
        }
    }

    @FXML
    void LimpiarUsuario(ActionEvent event) {
        txtNombre.clear();
        txtCorreoElectronico.clear();
        txtClave.clear();
        txtNumIdentificacion.clear();
        txtCodigoUnico.clear();
        cbCargo.getSelectionModel().clearSelection();
        System.out.println("✅ Campos limpiados correctamente.");
    }
    @FXML
    void EliminarUsuario(ActionEvent event) {
        System.out.println("✅ Método EliminarUsuario ejecutado.");
    }
    @FXML
    void EditarUsuario(ActionEvent event) {
        System.out.println("✅ Método EditarUsuario ejecutado.");
    }

    @FXML
    void initialize() {
        cbCargo.getItems().addAll("Administrador", "Cajero");
    }
}