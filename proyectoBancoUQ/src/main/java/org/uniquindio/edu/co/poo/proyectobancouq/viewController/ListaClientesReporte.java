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
import javafx.scene.layout.AnchorPane;

public class ListaClientesReporte {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane PaneNuevaCUenta;

    @FXML
    private AnchorPane ReportePane;

    @FXML
    private AnchorPane ClientesPane; // Nuevo: para el panel de clientes

    @FXML
    private ComboBox<?> SelcTipoCuenta;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnMostrarReporte;

    @FXML
    private Button btnNuevaCuenta;

    @FXML
    private TableColumn<?, ?> colCorreo;

    @FXML
    private TableColumn<?, ?> colFechaTransaccion;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colNombres;

    @FXML
    private TableColumn<?, ?> colTipoTransaccion;

    @FXML
    private TableView<?> tableClientes;

    @FXML
    private TableView<?> tableReporte;

    @FXML
    private TextField txtNuevoNumCuenta;

    @FXML
    private TextField txtSaldoInicialCuenta;

    // MÉTODOS DE NAVEGACIÓN ENTRE PANELES

    @FXML
    void BuscarUsuario(ActionEvent event) {
        ClientesPane.setVisible(true);
        ReportePane.setVisible(false);
        PaneNuevaCUenta.setVisible(false);
    }

    @FXML
    void mostrarReporte(ActionEvent event) {
        ClientesPane.setVisible(false);
        ReportePane.setVisible(true);
        PaneNuevaCUenta.setVisible(false);
    }

    @FXML
    void mostrarNuevaCuenta(ActionEvent event) {
        ClientesPane.setVisible(false);
        ReportePane.setVisible(false);
        PaneNuevaCUenta.setVisible(true);
    }

    // MÉTODO DE INICIALIZACIÓN
    @FXML
    void initialize() {
        assert ClientesPane != null : "fx:id=\"ClientesPane\" was not injected: check your FXML file.";
        assert PaneNuevaCUenta != null : "fx:id=\"PaneNuevaCUenta\" was not injected: check your FXML file.";
        assert ReportePane != null : "fx:id=\"ReportePane\" was not injected: check your FXML file.";
        assert SelcTipoCuenta != null : "fx:id=\"SelcTipoCuenta\" was not injected: check your FXML file.";
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file.";
        assert btnMostrarReporte != null : "fx:id=\"btnMostrarReporte\" was not injected: check your FXML file.";
        assert btnNuevaCuenta != null : "fx:id=\"btnNuevaCuenta\" was not injected: check your FXML file.";
        assert colCorreo != null : "fx:id=\"colCorreo\" was not injected: check your FXML file.";
        assert colFechaTransaccion != null : "fx:id=\"colFechaTransaccion\" was not injected: check your FXML file.";
        assert colID != null : "fx:id=\"colID\" was not injected: check your FXML file.";
        assert colNombres != null : "fx:id=\"colNombres\" was not injected: check your FXML file.";
        assert colTipoTransaccion != null : "fx:id=\"colTipoTransaccion\" was not injected: check your FXML file.";
        assert tableClientes != null : "fx:id=\"tableClientes\" was not injected: check your FXML file.";
        assert tableReporte != null : "fx:id=\"tableReporte\" was not injected: check your FXML file.";
        assert txtNuevoNumCuenta != null : "fx:id=\"txtNuevoNumCuenta\" was not injected: check your FXML file.";
        assert txtSaldoInicialCuenta != null : "fx:id=\"txtSaldoInicialCuenta\" was not injected: check your FXML file.";

        // Mostrar solo el panel de clientes al inicio
        ClientesPane.setVisible(true);
        ReportePane.setVisible(false);
        PaneNuevaCUenta.setVisible(false);
    }
}
