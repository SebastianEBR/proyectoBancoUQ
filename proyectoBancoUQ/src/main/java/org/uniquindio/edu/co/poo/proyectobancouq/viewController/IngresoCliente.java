package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.uniquindio.edu.co.poo.proyectobancouq.app.App;
import org.uniquindio.edu.co.poo.proyectobancouq.controller.ClienteController;
import org.uniquindio.edu.co.poo.proyectobancouq.model.TipoTransaccion;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Transaccion;
import org.uniquindio.edu.co.poo.proyectobancouq.utills.Paths;

public class IngresoCliente {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane PaneDeposito, PaneRetiro, PaneTranferencia;

    @FXML
    private TextField txtCantidadDeposito, txtCantidadRetiro, txtCantidadTransferencia;

    @FXML
    private TextField txtNumeroCuentaDeposito, txtNumeroCuentaDestino, txtNumeroCuentaEnvia, txtNumeroCuentaRetiro;

    private ClienteController clienteController;

    // Método para configurar el controlador del Cliente
    public void setClienteController(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

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
        try {
            String cuenta = txtNumeroCuentaRetiro.getText();
            String monto = String.valueOf(Double.parseDouble(txtCantidadRetiro.getText()));

            Transaccion retiro = new Transaccion(cuenta,LocalDate.now(), monto,"Retiro", TipoTransaccion.RETIRO,App.app.banco);
            boolean resultado = clienteController.registrarTransaccion(retiro, cuenta);

            if (resultado) {
                System.out.println("Retiro exitoso.");
            } else {
                System.out.println("Error en el retiro.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        txtNumeroCuentaRetiro.setText("");
        txtCantidadRetiro.setText("");



        PaneRetiro.setVisible(false);
    }

    @FXML
    void HacerTransferencia(ActionEvent event) {
        try {
            String cuentaOrigen = txtNumeroCuentaEnvia.getText();
            String cuentaDestino = txtNumeroCuentaDestino.getText();
            String monto = String.valueOf(Double.parseDouble(txtCantidadTransferencia.getText()));


            Transaccion transferencia = new Transaccion(cuentaOrigen,LocalDate.now(),monto,"Transferencia",TipoTransaccion.TRANSFERENCIA,App.app.banco);
            boolean resultado = clienteController.registrarTransaccion(transferencia, cuentaOrigen, cuentaDestino);

            if (resultado) {
                System.out.println("Transferencia realizada con éxito.");
            } else {
                System.out.println("Error en la transferencia.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        txtNumeroCuentaEnvia.setText("");
        txtNumeroCuentaDestino.setText("");
        txtCantidadTransferencia.setText("");

        PaneTranferencia.setVisible(false);
    }

    @FXML
    void HecerDeposito(ActionEvent event) {
        try {
            String cuenta = txtNumeroCuentaDeposito.getText();
            String monto = String.valueOf(Double.parseDouble(txtCantidadDeposito.getText()));


            Transaccion deposito = new Transaccion("",LocalDate.now(),monto,"Deposito",TipoTransaccion.DEPOSITO,App.app.banco);
            boolean resultado = clienteController.registrarTransaccion(deposito, cuenta);

            if (resultado) {
                System.out.println("Depósito exitoso.");
            } else {
                System.out.println("Error en el depósito.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        txtNumeroCuentaDeposito.setText("");
        txtCantidadDeposito.setText("");

        PaneDeposito.setVisible(false);
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
    void salirInicio(ActionEvent event) throws IOException {
        App.app.setScene(Paths.ELECCION_USUARIO);
    }
}