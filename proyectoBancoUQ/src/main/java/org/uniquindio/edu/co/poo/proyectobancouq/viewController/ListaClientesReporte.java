package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Cliente;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Transaccion;

public class ListaClientesReporte {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private AnchorPane PaneNuevaCUenta, ReportePane;
    @FXML private ComboBox<String> SelcTipoCuenta;
    @FXML private Button btnBuscar, btnMostrarReporte, btnNuevaCuenta;
    @FXML private TableColumn<Cliente, String> colCorreo, colID, colNombres;
    @FXML private TableColumn<Transaccion, String> colFechaTransaccion, colTipoTransaccion;
    @FXML private TableView<Cliente> tableClientes;
    @FXML private TableView<Transaccion> tableReporte;
    @FXML private TextField txtNuevoNumCuenta, txtSaldoInicialCuenta;

    private Banco banco; // 🔥 Banco para obtener los datos

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @FXML
    void initialize() {
        System.out.println("🔍 Cargando ListaClientesReporte...");

        // 🔥 Configurar columnas de clientes
        colID.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getId()));
        colNombres.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));
        colCorreo.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getEmail()));

        // 🔥 Configurar columnas de transacciones
        colFechaTransaccion.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getFecha().toString()));
        colTipoTransaccion.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTipoTransaccion().name()));

        // 🔥 Vincular ComboBox con tipos de cuenta
        SelcTipoCuenta.getItems().addAll("Cuenta Ahorros", "Cuenta Corriente", "Cuenta Empresarial");

        System.out.println("✅ Configuración inicial completada.");
    }

    @FXML
    void BuscarUsuario(ActionEvent event) {
        if (banco == null) {
            mostrarAlerta("⚠️ Banco no asignado.");
            return;
        }

        System.out.println("🔎 Cargando lista de clientes...");
        ObservableList<Cliente> listaClientes = FXCollections.observableArrayList(banco.getListClientes());
        tableClientes.setItems(listaClientes);
    }

    @FXML
    void mostrarReporte(ActionEvent event) {
        if (banco == null) {
            mostrarAlerta("⚠️ Banco no asignado.");
            return;
        }

        System.out.println("📊 Mostrando reporte de transacciones...");
        ObservableList<Transaccion> listaTransacciones = FXCollections.observableArrayList(banco.getListTransacciones());
        tableReporte.setItems(listaTransacciones);
    }

    @FXML
    void mostrarNuevaCuenta(ActionEvent event) {
        PaneNuevaCUenta.setVisible(true);
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Lista de Clientes");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}