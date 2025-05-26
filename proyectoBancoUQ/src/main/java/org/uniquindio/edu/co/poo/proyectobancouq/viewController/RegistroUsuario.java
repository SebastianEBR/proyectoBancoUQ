package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Admin;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Cajero;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;

import java.util.Optional;

public class RegistroUsuario {

    private Banco banco;

    @FXML
    private Button btnEditar, btnEliminar, btnLimpiar, btnRegistrar;
    @FXML
    private ComboBox<String> cbCargo;
    @FXML
    private TableColumn<Usuario, String> colCorreo, colID, colNombres;
    @FXML
    private TableView<Usuario> tableUs;
    @FXML
    private TextField txtClave, txtCodigoUnico, txtCorreoElectronico, txtNombre, txtNumIdentificacion;

    @FXML
    void initialize() {
        cbCargo.getItems().addAll("Admin", "Cajero");

        // 🔥 Vincular columnas con los atributos correctos de Usuario
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("email")); // 🔥 Cambiado de "correo" a "email"

        tableUs.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) seleccionarUsuario();
        });

        if (banco != null) {
            System.out.println("✅ Banco está asignado, cargando usuarios...");
            ActualizaTabla();
        } else {
            System.out.println("⚠️ Banco aún no ha sido asignado en initialize().");
        }
    }

    // Método para mostrar alertas en pantalla
    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Registro de Usuario");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    void RegistrarUsuario(ActionEvent event) throws Exception {
        if (banco == null) {
            mostrarAlerta("⚠️ Error: Banco no ha sido asignado.");
            return;
        }

        String nombre = txtNombre.getText();
        String correo = txtCorreoElectronico.getText();
        String idUnico = txtCodigoUnico.getText();
        String contraseña = txtClave.getText();
        String numIdentificacion = txtNumIdentificacion.getText();
        String cargo = cbCargo.getValue();

        if (nombre.isEmpty() || correo.isEmpty() || idUnico.isEmpty() || contraseña.isEmpty() || numIdentificacion.isEmpty() || cargo == null) {
            mostrarAlerta("⚠️ Error: Todos los campos deben estar completos.");
            return;
        }

        if (banco.buscarUsuario(idUnico).isPresent()) {
            mostrarAlerta("⚠️ Error: Ya existe un usuario con ese ID.");
            return;
        }

        Usuario usuario = cargo.equals("Admin") ? new Admin(numIdentificacion, nombre, correo, contraseña, idUnico)
                : new Cajero(numIdentificacion, nombre, correo, contraseña, idUnico);

        if (banco.registrarUsuario(usuario)) {
            System.out.println("lista usuarios: " + banco.getListUsuarios());
            System.out.println("✅ Usuario registrado correctamente.");
        } else {
            mostrarAlerta("❌ Error al registrar el usuario.");
        }

        ActualizaTabla();
    }

    @FXML
    void EliminarUsuario(ActionEvent event) {
        if (banco == null) {
            mostrarAlerta("⚠️ Error: Banco no ha sido asignado.");
            return;
        }

        Usuario usuarioSeleccionado = tableUs.getSelectionModel().getSelectedItem();

        if (usuarioSeleccionado == null) {
            mostrarAlerta("⚠️ Error: No se ha seleccionado ningún usuario para eliminar.");
            return;
        }

        String idUsuario = usuarioSeleccionado.getId();

        if (banco.eliminarUsuario(idUsuario)) {
            System.out.println("✅ Usuario eliminado correctamente.");
        } else {
            mostrarAlerta("❌ Error al eliminar el usuario.");
        }

        ActualizaTabla();
    }

    @FXML
    void EditarUsuario(ActionEvent event) {
        if (banco == null) {
            mostrarAlerta("⚠️ Error: Banco no ha sido asignado.");
            return;
        }

        Usuario usuarioSeleccionado = tableUs.getSelectionModel().getSelectedItem();
        if (usuarioSeleccionado == null) {
            mostrarAlerta("⚠️ Error: No se ha seleccionado ningún usuario para editar.");
            return;
        }

        String nombre = txtNombre.getText();
        String correo = txtCorreoElectronico.getText();
        String idUnico = txtCodigoUnico.getText();
        String contraseña = txtClave.getText();
        String numIdentificacion = txtNumIdentificacion.getText();

        if (nombre.isEmpty() || correo.isEmpty() || idUnico.isEmpty() || contraseña.isEmpty() || numIdentificacion.isEmpty()) {
            mostrarAlerta("⚠️ Error: Todos los campos deben estar completos para editar.");
            return;
        }

        Usuario usuarioActualizado = usuarioSeleccionado instanceof Admin ?
                new Admin(numIdentificacion, nombre, correo, contraseña, idUnico) :
                new Cajero(numIdentificacion, nombre, correo, contraseña, idUnico);

        if (banco.actualizarUsuario(usuarioActualizado)) {
            System.out.println("✅ Usuario actualizado correctamente.");
        } else {
            mostrarAlerta("❌ Error al actualizar el usuario.");
        }

        ActualizaTabla();
    }

    @FXML
    void LimpiarUsuario(ActionEvent event) {
        txtNombre.clear();
        txtCorreoElectronico.clear();
        txtCodigoUnico.clear();
        txtClave.clear();
        txtNumIdentificacion.clear();
        cbCargo.setValue(null);

        System.out.println("✅ Campos limpiados correctamente.");
    }

    private void ActualizaTabla() {
        tableUs.getItems().clear();
        tableUs.getItems().addAll(banco.getListUsuarios());
        tableUs.refresh();
        System.out.println("📌 Usuarios en banco antes de actualizar tabla: " + banco.getListUsuarios());
    }

    @FXML
    void seleccionarUsuario() {
        Usuario usuarioSeleccionado = tableUs.getSelectionModel().getSelectedItem();
        if (usuarioSeleccionado != null) {
            txtNombre.setText(usuarioSeleccionado.getNombre());
            txtCorreoElectronico.setText(usuarioSeleccionado.getEmail());
            txtCodigoUnico.setText(usuarioSeleccionado.getId());
            txtClave.setText(usuarioSeleccionado.getPassword());
            txtNumIdentificacion.setText(usuarioSeleccionado.getId());
            cbCargo.setValue(usuarioSeleccionado instanceof Admin ? "Admin" : "Cajero");
        }
    }

    public void setBanco(Banco uq) {
        this.banco = uq;
        System.out.println("✅ Banco asignado correctamente." + banco);
    }
}

