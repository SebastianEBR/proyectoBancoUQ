package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

// ✅ Clase base: CuentaBancario
abstract class CuentaBancario {
    private String nombre;

    public CuentaBancario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre; // Esto asegura que el ComboBox muestre el nombre correctamente
    }
}

// ✅ Clases hijas
class CuentaAhorros extends CuentaBancario {
    public CuentaAhorros() {
        super("Cuenta de Ahorros");
    }
}

class CuentaCorriente extends CuentaBancario {
    public CuentaCorriente() {
        super("Cuenta Corriente");
    }
}

class CuentaEmpresarial extends CuentaBancario {
    public CuentaEmpresarial() {
        super("Cuenta Empresarial");
    }
}

public class RegistroDeCliente {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<CuentaBancario> SelcTipoCuenta; // ComboBox con clases hijas de CuentaBancario

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
        txtClave.clear();
        txtCorreoElectronico.clear();
        txtNombre.clear();
        txtNuevoNumCuenta.clear();
        txtNumIdentificacion.clear();
        txtSaldoInicialCuenta.clear();
        SelcTipoCuenta.getSelectionModel().clearSelection();
    }

    @FXML
    void RegistrarUsuario(ActionEvent event) {
        CuentaBancario tipoSeleccionado = SelcTipoCuenta.getSelectionModel().getSelectedItem();
        if (tipoSeleccionado != null) {
            System.out.println("Cuenta seleccionada: " + tipoSeleccionado.getNombre());
        } else {
            System.out.println("No se ha seleccionado ningún tipo de cuenta.");
        }
    }

    @FXML
    void initialize() {
        assert SelcTipoCuenta != null : "fx:id=\"SelcTipoCuenta\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert btnLimpiar != null : "fx:id=\"btnLimpiar\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert btnRegistrar != null : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'RegistroCliente.fxml'.";

        // ✅ Poblar ComboBox con instancias de clases hijas de CuentaBancario
        SelcTipoCuenta.getItems().addAll(
                new CuentaAhorros(),
                new CuentaCorriente(),
                new CuentaEmpresarial()
        );
    }
}