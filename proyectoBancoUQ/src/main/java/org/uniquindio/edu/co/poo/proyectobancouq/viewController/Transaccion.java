package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.uniquindio.edu.co.poo.proyectobancouq.app.App;
import org.uniquindio.edu.co.poo.proyectobancouq.utills.Paths;

public class Transaccion {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane PaneDeposito;

    @FXML
    private AnchorPane PaneRetiro;

    @FXML
    private AnchorPane PaneTranferencia;

    @FXML
    private TextField txtCantidadDeposito;

    @FXML
    private TextField txtCantidadRetiro;

    @FXML
    private TextField txtCantidadTransferencia;

    @FXML
    private TextField txtNumeroCuentaDeposito;

    @FXML
    private TextField txtNumeroCuentaDestino;

    @FXML
    private TextField txtNumeroCuentaEnvia;

    @FXML
    private TextField txtNumeroCuentaRetiro;

    @FXML
    void CerrarVentanaDeposito(ActionEvent event) {
        PaneDeposito.setVisible(false);
    }

    @FXML
    void CerrarVentanaRetiro(ActionEvent event) {
        PaneRetiro.setVisible(false);

    }

    @FXML
    void CerrarVentanaTransferencia(ActionEvent event) {
        PaneTranferencia.setVisible(false);

    }

    @FXML
    void HacerRetiro(ActionEvent event) {

    }

    @FXML
    void HacerTransferencia(ActionEvent event) {

    }

    @FXML
    void HecerDeposito(ActionEvent event) {

    }

    @FXML
    void desplegarDeposito(ActionEvent event) {
        PaneDeposito.setVisible(true);


    }

    @FXML
    void desplegarRetiro(ActionEvent event) {
        PaneRetiro.setVisible(true);
    }

    @FXML
    void desplegarTransferencia(ActionEvent event) {
        PaneTranferencia.setVisible(true);
    }

    @FXML
    void salirInicio(ActionEvent event) {
        App.app.setScene(Paths.ELECCION_USUARIO);

    }

    @FXML
    void initialize() {
        assert PaneDeposito != null : "fx:id=\"PaneDeposito\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert PaneRetiro != null : "fx:id=\"PaneRetiro\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert PaneTranferencia != null : "fx:id=\"PaneTranferencia\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert txtCantidadDeposito != null : "fx:id=\"txtCantidadDeposito\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert txtCantidadRetiro != null : "fx:id=\"txtCantidadRetiro\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert txtCantidadTransferencia != null : "fx:id=\"txtCantidadTransferencia\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert txtNumeroCuentaDeposito != null : "fx:id=\"txtNumeroCuentaDeposito\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert txtNumeroCuentaDestino != null : "fx:id=\"txtNumeroCuentaDestino\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert txtNumeroCuentaEnvia != null : "fx:id=\"txtNumeroCuentaEnvia\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert txtNumeroCuentaRetiro != null : "fx:id=\"txtNumeroCuentaRetiro\" was not injected: check your FXML file 'Transaccion.fxml'.";

    }

}
