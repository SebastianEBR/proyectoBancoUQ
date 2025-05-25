package org.uniquindio.edu.co.poo.proyectobancouq.viewController;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistroDeCliente {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txtClave;

    @FXML
    private TextField txtCorreoElectronico;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNuevoNumCuenta;

    @FXML
    private TextField txtNumIdentificacion;

    @FXML
    private TextField txtSaldoInicialCuenta;

    @FXML
    void LimpiarUsuario(ActionEvent event) {

    }

    @FXML
    void RegistrarUsuario(ActionEvent event) {

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

