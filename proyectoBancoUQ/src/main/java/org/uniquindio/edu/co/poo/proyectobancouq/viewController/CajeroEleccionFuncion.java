package org.uniquindio.edu.co.poo.proyectobancouq.viewController;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CajeroEleccionFuncion {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIRaRegistrarCliente;

    @FXML
    private Button btnIrAhacerTransaccion;

    @FXML
    private Button btnIrAingresocomocajero;

    @FXML
    private Button btnIrListaDeclientes;

    @FXML
    void IngresarComoCajero(ActionEvent event) {

    }

    @FXML
    void RegresarAElccion(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnIRaRegistrarCliente != null : "fx:id=\"btnIRaRegistrarCliente\" was not injected: check your FXML file 'CajeroElccionFuncion.fxml'.";
        assert btnIrAhacerTransaccion != null : "fx:id=\"btnIrAhacerTransaccion\" was not injected: check your FXML file 'CajeroElccionFuncion.fxml'.";
        assert btnIrAingresocomocajero != null : "fx:id=\"btnIrAingresocomocajero\" was not injected: check your FXML file 'CajeroElccionFuncion.fxml'.";
        assert btnIrListaDeclientes != null : "fx:id=\"btnIrListaDeclientes\" was not injected: check your FXML file 'CajeroElccionFuncion.fxml'.";

    }

}
