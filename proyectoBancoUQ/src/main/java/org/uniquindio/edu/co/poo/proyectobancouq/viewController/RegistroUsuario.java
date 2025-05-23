/**
 * Sample Skeleton for 'RegistroUsuario.fxml' Controller Class
 */

package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RegistroUsuario {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnBuscar"
    private Button btnBuscar; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditar"
    private Button btnEditar; // Value injected by FXMLLoader

    @FXML // fx:id="btnEliminar"
    private Button btnEliminar; // Value injected by FXMLLoader

    @FXML // fx:id="btnLimpiar"
    private Button btnLimpiar; // Value injected by FXMLLoader

    @FXML // fx:id="btnRegistrar"
    private Button btnRegistrar; // Value injected by FXMLLoader

    @FXML // fx:id="cbCargo"
    private ComboBox<?> cbCargo; // Value injected by FXMLLoader

    @FXML // fx:id="colCorreo"
    private TableColumn<?, ?> colCorreo; // Value injected by FXMLLoader

    @FXML // fx:id="colID"
    private TableColumn<?, ?> colID; // Value injected by FXMLLoader

    @FXML // fx:id="colNombres"
    private TableColumn<?, ?> colNombres; // Value injected by FXMLLoader

    @FXML // fx:id="tableClientes"
    private TableView<?> tableClientes; // Value injected by FXMLLoader

    @FXML // fx:id="txtClave"
    private TextField txtClave; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorreoElectronico"
    private TextField txtCorreoElectronico; // Value injected by FXMLLoader

    @FXML // fx:id="txtNombre"
    private TextField txtNombre; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumIdentificacion"
    private TextField txtNumIdentificacion; // Value injected by FXMLLoader

    @FXML
    void BuscarUsuario(ActionEvent event) {

    }

    @FXML
    void EditarUsuario(ActionEvent event) {

    }

    @FXML
    void EliminarUsuario(ActionEvent event) {

    }

    @FXML
    void LimpiarUsuario(ActionEvent event) {

    }

    @FXML
    void RegistrarUsuario(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert btnEditar != null : "fx:id=\"btnEditar\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert btnEliminar != null : "fx:id=\"btnEliminar\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert btnLimpiar != null : "fx:id=\"btnLimpiar\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert btnRegistrar != null : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert cbCargo != null : "fx:id=\"cbCargo\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert colCorreo != null : "fx:id=\"colCorreo\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert colID != null : "fx:id=\"colID\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert colNombres != null : "fx:id=\"colNombres\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert tableClientes != null : "fx:id=\"tableClientes\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert txtClave != null : "fx:id=\"txtClave\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert txtCorreoElectronico != null : "fx:id=\"txtCorreoElectronico\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert txtNumIdentificacion != null : "fx:id=\"txtNumIdentificacion\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";

    }

}
