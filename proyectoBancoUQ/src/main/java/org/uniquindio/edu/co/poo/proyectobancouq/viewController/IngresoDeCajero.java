/**
 * Sample Skeleton for 'IngresoDeCajero.fxml' Controller Class
 */

package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class IngresoDeCajero {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn"
    private Button btn; // Value injected by FXMLLoader

    @FXML // fx:id="btnRegresar"
    private Button btnRegresar; // Value injected by FXMLLoader

    @FXML // fx:id="txtINgreseUsuario"
    private TextField txtINgreseUsuario; // Value injected by FXMLLoader

    @FXML // fx:id="txtIngreseCigoUnico"
    private PasswordField txtIngreseCigoUnico; // Value injected by FXMLLoader

    @FXML // fx:id="txtIngreseContraceña"
    private PasswordField txtIngreseContraceña; // Value injected by FXMLLoader

    @FXML
    void IngresarComoCajero(ActionEvent event) {

    }

    @FXML
    void RegresarAElccion(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'IngresoDeCajero.fxml'.";
        assert btnRegresar != null : "fx:id=\"btnRegresar\" was not injected: check your FXML file 'IngresoDeCajero.fxml'.";
        assert txtINgreseUsuario != null : "fx:id=\"txtINgreseUsuario\" was not injected: check your FXML file 'IngresoDeCajero.fxml'.";
        assert txtIngreseCigoUnico != null : "fx:id=\"txtIngreseCigoUnico\" was not injected: check your FXML file 'IngresoDeCajero.fxml'.";
        assert txtIngreseContraceña != null : "fx:id=\"txtIngreseContraceña\" was not injected: check your FXML file 'IngresoDeCajero.fxml'.";

    }

}

