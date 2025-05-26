package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.uniquindio.edu.co.poo.proyectobancouq.controller.CajeroController;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Cliente;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;

public class RegistroDeCliente {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLimpiar, btnRegistrar;

    @FXML
    private TextField txtClave, txtCorreoElectronico, txtNombre;

    @FXML
    private TextField txtNuevoNumCuenta, txtNumIdentificacion, txtSaldoInicialCuenta;

    private CajeroController cajeroController;

    // Método para configurar el controlador del Cajero
    public void setCajeroController(CajeroController cajeroController) {
        this.cajeroController = cajeroController;
    }

    // Método para limpiar los campos del formulario
    @FXML
    void LimpiarUsuario(ActionEvent event) {
        txtClave.setText("");
        txtCorreoElectronico.setText("");
        txtNombre.setText("");
        txtNuevoNumCuenta.setText("");
        txtNumIdentificacion.setText("");
        txtSaldoInicialCuenta.setText("");
    }

    // Método para registrar un nuevo usuario
    @FXML
    void RegistrarUsuario(ActionEvent event) {
        try {
            String id = txtNumIdentificacion.getText();
            String nombre = txtNombre.getText();
            String email = txtCorreoElectronico.getText();
            String clave = txtClave.getText();
            double saldo = Double.parseDouble(txtSaldoInicialCuenta.getText());

            Cliente nuevoUsuario = new Cliente(id,nombre,email,clave);
            boolean registrado = cajeroController.agregarCliente(nuevoUsuario);

            if (registrado) {
                System.out.println("Cliente registrado con éxito.");
                LimpiarUsuario(null);
            } else {
                System.out.println("Error al registrar el cliente.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    void initialize() {
        assert btnLimpiar != null : "fx:id=\"btnLimpiar\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert btnRegistrar != null : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert txtClave != null : "fx:id=\"txtClave\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert txtCorreoElectronico != null : "fx:id=\"txtCorreoElectronico\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert txtNuevoNumCuenta != null : "fx:id=\"txtNuevoNumCuenta\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert txtNumIdentificacion != null : "fx:id=\"txtNumIdentificacion\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert txtSaldoInicialCuenta != null : "fx:id=\"txtSaldoInicialCuenta\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
    }
}

