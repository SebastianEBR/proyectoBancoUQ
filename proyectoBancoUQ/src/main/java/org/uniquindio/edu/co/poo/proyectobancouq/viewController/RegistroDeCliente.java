package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.uniquindio.edu.co.poo.proyectobancouq.app.App;
import org.uniquindio.edu.co.poo.proyectobancouq.controller.CrudClienteController;
import org.uniquindio.edu.co.poo.proyectobancouq.model.*;
import org.uniquindio.edu.co.poo.proyectobancouq.utills.Paths;

public class RegistroDeCliente {

    private CrudClienteController crudClienteController;

    public void setCrudClienteController(CrudClienteController crudClienteController) {
        this.crudClienteController = crudClienteController;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> SelcTipoCuenta;  // 🔥 Ahora contiene las subclases de CuentaBancaria

    @FXML
    private Button btnLimpiar, btnRegistrar;

    @FXML
    private TableColumn<Cliente, String> colNombreCliente, colNumeroCuenta, colTipoCuenta;

    @FXML
    private TableView<Cliente> tlbClientes;

    @FXML
    private TextField txtClave, txtCorreoElectronico, txtNombre, txtNuevoNumCuenta, txtNumIdentificacion, txtSaldoInicialCuenta;

    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();

    @FXML
    void Salir(ActionEvent event) {
        App.app.setScene(Paths.ELECCION_USUARIO);

    }

    @FXML
    void initialize() {
        // 🔥 Opciones de cuentas según la herencia de CuentaBancaria
        SelcTipoCuenta.getItems().addAll("Cuenta Ahorros", "Cuenta Corriente", "Cuenta Empresarial");

        // 🔥 Configurar columnas con cellValueFactory
        colNombreCliente.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));
        colNumeroCuenta.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getListCuentaBancaria().get(0).getNumeroCuenta()));
        colTipoCuenta.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getListCuentaBancaria().get(0).getClass().getSimpleName()));

        // 🔥 Vincular la lista de clientes a la tabla
        tlbClientes.setItems(listaClientes);
        ActualizaTabla();
    }

    @FXML
    void LimpiarUsuario(ActionEvent event) {
        txtNombre.clear();
        txtCorreoElectronico.clear();
        txtNuevoNumCuenta.clear();
        txtClave.clear();
        txtNumIdentificacion.clear();
        txtSaldoInicialCuenta.clear();
        SelcTipoCuenta.setValue(null);

        System.out.println("✅ Campos limpiados correctamente.");
    }

    @FXML
    void RegistrarUsuario(ActionEvent event) {
        if (crudClienteController == null) {
            mostrarAlerta("⚠️ Error: CrudClienteController no ha sido asignado.");
            System.out.println("❌ Error: CrudClienteController es NULL, no se puede cargar");
            return;
        }

        String nombre = txtNombre.getText();
        String correo = txtCorreoElectronico.getText();
        String numIdentificacion = txtNumIdentificacion.getText();  // 🔥 ID único del cliente
        String contraseña = txtClave.getText();
        String numeroCuenta = txtNuevoNumCuenta.getText();  // 🔥 Número de cuenta bancaria
        String saldoInicialTexto = txtSaldoInicialCuenta.getText();
        String tipoCuenta = SelcTipoCuenta.getValue();

        if (nombre.isEmpty() || correo.isEmpty() || numIdentificacion.isEmpty() || contraseña.isEmpty() ||
                numeroCuenta.isEmpty() || saldoInicialTexto.isEmpty() || tipoCuenta == null) {
            mostrarAlerta("⚠️ Error: Todos los campos deben estar completos.");
            return;
        }

        double saldoInicial;
        try {
            saldoInicial = Double.parseDouble(saldoInicialTexto);
        } catch (NumberFormatException e) {
            mostrarAlerta("⚠️ Error: Saldo inicial debe ser un número válido.");
            return;
        }

        if (crudClienteController.buscarCliente(numIdentificacion).isPresent()) {
            mostrarAlerta("⚠️ Error: Ya existe un cliente con esa identificación.");
            return;
        }

        Cliente cliente = new Cliente(numIdentificacion, nombre, correo, contraseña);

        // 🔥 Crear la cuenta según el tipo seleccionado
        CuentaBancaria cuenta;
        switch (tipoCuenta) {
            case "Cuenta Ahorros":
                cuenta = new CuentaAhorros(numeroCuenta, saldoInicial);
                break;
            case "Cuenta Corriente":
                cuenta = new CuentaCorriente(numeroCuenta, saldoInicial);
                break;
            case "Cuenta Empresarial":
                cuenta = new CuentaEmpresarial(numeroCuenta, saldoInicial);
                break;
            default:
                mostrarAlerta("⚠️ Error: Tipo de cuenta no válido.");
                return;
        }

        if (crudClienteController.registrarCliente(cliente, cuenta)) {
            System.out.println("✅ Cliente registrado correctamente con cuenta: " + tipoCuenta);
            ActualizaTabla();
        } else {
            mostrarAlerta("❌ Error al registrar el cliente.");
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Registro de Cliente");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void ActualizaTabla() {
        if (banco == null) {
            System.out.println("❌ Error: Banco no está asignado.");
            return;
        }

        System.out.println("🔍 Actualizando tabla de clientes...");

        listaClientes.setAll(banco.getListClientes()); // 🔥 Ahora usamos ObservableList
        tlbClientes.refresh();

        System.out.println("📌 Lista de clientes después de la actualización: " + banco.getListClientes());
    }

    private Banco banco;
    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}