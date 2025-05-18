
/**
 * Sample Skeleton for 'EleccionUsuario.fxml' Controller Class
 */

package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EleccionUsuario {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnAdmin"
    private Button btnAdmin; // Value injected by FXMLLoader

    @FXML // fx:id="btnCajero"
    private Button btnCajero; // Value injected by FXMLLoader

    @FXML // fx:id="btnCliente"
    private Button btnCliente; // Value injected by FXMLLoader

    @FXML
    void IrAAdmin(ActionEvent event) {

    }

    @FXML
    void IrACaejro(ActionEvent event) {

    }

    @FXML
    void irACLiente(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnAdmin != null : "fx:id=\"btnAdmin\" was not injected: check your FXML file 'EleccionUsuario.fxml'.";
        assert btnCajero != null : "fx:id=\"btnCajero\" was not injected: check your FXML file 'EleccionUsuario.fxml'.";
        assert btnCliente != null : "fx:id=\"btnCliente\" was not injected: check your FXML file 'EleccionUsuario.fxml'.";

    }

}
