package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.uniquindio.edu.co.poo.proyectobancouq.app.App;
import org.uniquindio.edu.co.poo.proyectobancouq.utills.Paths;

public class CajeroEleccionFuncion {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void IrAtransacciones(ActionEvent event) {
        App.app.setScene(Paths.TRANSACCION);

    }

    @FXML
    void SalirElccion(ActionEvent event) {
        App.app.setScene(Paths.ELECCION_USUARIO);

    }

    @FXML
    void irARegistrarCliente(ActionEvent event) {
        App.app.setScene(Paths.REGISTRO_CLIENTES);

    }

    @FXML
    void initialize() {

    }

}

