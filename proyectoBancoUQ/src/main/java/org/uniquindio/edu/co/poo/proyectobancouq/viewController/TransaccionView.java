package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.uniquindio.edu.co.poo.proyectobancouq.app.App;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Transaccion;
import org.uniquindio.edu.co.poo.proyectobancouq.model.TipoTransaccion;
import org.uniquindio.edu.co.poo.proyectobancouq.utills.Paths;

public class TransaccionView {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private AnchorPane PaneDeposito, PaneRetiro, PaneTranferencia;
    @FXML private TextField txtCantidadDeposito, txtCantidadRetiro, txtCantidadTransferencia;
    @FXML private TextField txtNumeroCuentaDeposito, txtNumeroCuentaDestino, txtNumeroCuentaEnvia, txtNumeroCuentaRetiro;

    private Banco banco; // 🔥 Agregado para que TransaccionView tenga acceso al banco

    public void setBanco(Banco banco) {
        this.banco = banco;
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
    void HecerDeposito(ActionEvent event) {
        realizarTransaccion(TipoTransaccion.DEPOSITO, txtNumeroCuentaDeposito.getText(), txtCantidadDeposito.getText(), "Depósito en cuenta");
    }

    @FXML
    void HacerRetiro(ActionEvent event) {
        realizarTransaccion(TipoTransaccion.RETIRO, txtNumeroCuentaRetiro.getText(), txtCantidadRetiro.getText(), "Retiro de cuenta");
    }

    @FXML
    void HacerTransferencia(ActionEvent event) throws Exception {
        if (banco == null) {
            mostrarAlerta("⚠️ Banco no asignado.");
            return;
        }

        String cuentaOrigen = txtNumeroCuentaEnvia.getText();
        String cuentaDestino = txtNumeroCuentaDestino.getText();
        String cantidadTexto = txtCantidadTransferencia.getText();

        if (cuentaOrigen.isEmpty() || cuentaDestino.isEmpty() || cantidadTexto.isEmpty()) {
            mostrarAlerta("⚠️ Debes ingresar todos los datos.");
            return;
        }

        double cantidad;
        try {
            cantidad = Double.parseDouble(cantidadTexto);
        } catch (NumberFormatException e) {
            mostrarAlerta("⚠️ La cantidad debe ser un número válido.");
            return;
        }

        Transaccion transferencia = new Transaccion(LocalDate.now(), cantidadTexto, "Transferencia entre cuentas", TipoTransaccion.TRANSFERENCIA, banco);
        boolean resultado;

        try {
            resultado = transferencia.transferir(cuentaOrigen, cuentaDestino, cantidad);
        } catch (Exception e) {
            mostrarAlerta("❌ " + e.getMessage());
            return;
        }

        if (resultado) {
            mostrarAlerta("✅ Transferencia realizada correctamente.");
        } else {
            mostrarAlerta("❌ Error en la transferencia.");
        }
    }

    private void realizarTransaccion(TipoTransaccion tipo, String numeroCuenta, String cantidadTexto, String descripcion) {
        if (banco == null) {
            mostrarAlerta("⚠️ Banco no asignado.");
            return;
        }

        if (numeroCuenta.isEmpty() || cantidadTexto.isEmpty()) {
            mostrarAlerta("⚠️ Debes ingresar todos los datos.");
            return;
        }

        double cantidad;
        try {
            cantidad = Double.parseDouble(cantidadTexto);
        } catch (NumberFormatException e) {
            mostrarAlerta("⚠️ La cantidad debe ser un número válido.");
            return;
        }

        Transaccion transaccion;
        try {
            transaccion = new Transaccion(LocalDate.now(), cantidadTexto, descripcion, tipo, banco);
        } catch (Exception e) {
            mostrarAlerta("❌ Error al crear la transacción: " + e.getMessage());
            return;
        }

        boolean resultado;
        try {
            if (tipo == TipoTransaccion.DEPOSITO) {
                resultado = transaccion.deposito(numeroCuenta, cantidad);
            } else if (tipo == TipoTransaccion.RETIRO) {
                resultado = transaccion.retiro(numeroCuenta, cantidad);
            } else {
                mostrarAlerta("❌ Tipo de transacción desconocido.");
                return;
            }
        } catch (Exception e) {
            mostrarAlerta("❌ " + e.getMessage());
            return;
        }

        if (resultado) {
            mostrarAlerta("✅ Transacción realizada correctamente.");
        } else {
            mostrarAlerta("❌ Error en la transacción.");
        }
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


    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Transacción");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        System.out.println("🔍 Cargando TransaccionView...");
        System.out.println("Banco asignado: " + banco);
    }
}