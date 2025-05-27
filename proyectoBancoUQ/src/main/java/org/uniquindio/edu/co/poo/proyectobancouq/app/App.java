package org.uniquindio.edu.co.poo.proyectobancouq.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyectobancouq.controller.AdminController;
import org.uniquindio.edu.co.poo.proyectobancouq.controller.CrudClienteController;
import org.uniquindio.edu.co.poo.proyectobancouq.model.*;
import org.uniquindio.edu.co.poo.proyectobancouq.utills.Paths;
import org.uniquindio.edu.co.poo.proyectobancouq.viewController.*;

import java.io.IOException;

public class App extends Application {

    public static App app;
    private Stage stageWindow;
    public Banco banco;
    private AdminController adminController;
    private CrudClienteController crudClienteController;

    public App() throws Exception {
        banco = new Banco("Uq", "5156");
        System.out.println("Banco iniciado: " + banco);
        this.adminController = new AdminController(banco);
        System.out.println("AdminController iniciado: " + adminController);
        this.crudClienteController = new CrudClienteController(banco);

        // Registro del usuario correctamente dentro del constructor
        Admin usuario = new Admin("001", "Admin", "<EMAIL>", "admin", "1234");
        Cajero cajero = new Cajero("002", "Cajero", "<EMAIL>", "cajero", "1234");
        banco.registrarUsuario(usuario);
        banco.registrarUsuario(cajero);


        Cliente cliente = new Cliente("003", "Cliente", "<EMAIL>", "cliente");
        CuentaCorriente cuentaCorriente = new CuentaCorriente("123456789", 1000);
        banco.registrarCliente(cliente,cuentaCorriente);

        Cliente cliente1 = new Cliente("004", "Ana Martínez", "ana.martinez@email.com", "cliente");
        CuentaCorriente cuenta1 = new CuentaCorriente("987654321", 1500);
        banco.registrarCliente(cliente1, cuenta1);

        Cliente cliente2 = new Cliente("005", "Luis Fernández", "luis.fernandez@email.com", "cliente");
        CuentaCorriente cuenta2 = new CuentaCorriente("112233445", 2000);
        banco.registrarCliente(cliente2, cuenta2);

        Cliente cliente3 = new Cliente("006", "María Gómez", "maria.gomez@email.com", "cliente");
        CuentaCorriente cuenta3 = new CuentaCorriente("998877665", 1200);
        banco.registrarCliente(cliente3, cuenta3);

        Cliente cliente4 = new Cliente("007", "Carlos Ruiz", "carlos.ruiz@email.com", "cliente");
        CuentaCorriente cuenta4 = new CuentaCorriente("443322110", 1800);
        banco.registrarCliente(cliente4, cuenta4);

        Cliente cliente5 = new Cliente("008", "Laura Torres", "laura.torres@email.com", "cliente");
        CuentaCorriente cuenta5 = new CuentaCorriente("556677889", 1700);
        banco.registrarCliente(cliente5, cuenta5);

    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        app = this;
        stageWindow = stage;
        setScene(Paths.ELECCION_USUARIO);
    }
    public void setScene(String path) {
        try {
            System.out.println("📌 Intentando cargar FXML desde: " + path);
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            stageWindow.setScene(scene);
            stageWindow.show();

            // Obtener el controlador de la escena
            Object controller = loader.getController();
            System.out.println("🔍 Controlador obtenido desde FXMLLoader: " + controller.getClass().getName());

            // 🔥 Asignar datos según el controlador detectado
            if (controller instanceof RegistroUsuario) {
                RegistroUsuario registroUsuario = (RegistroUsuario) controller;
                registroUsuario.setBanco(banco);
                System.out.println("✅ Banco asignado a RegistroUsuario.");
            } else if (controller instanceof IngresoAdmin) {
                IngresoAdmin ingresoAdmin = (IngresoAdmin) controller;
                ingresoAdmin.setAdminController(adminController);
                System.out.println("✅ adminController asignado correctamente a IngresoAdmin.");
            } else if (controller instanceof IngresoDeCajero) {
                IngresoDeCajero ingresoCajero = (IngresoDeCajero) controller;
                ingresoCajero.setAdminController(adminController);
                System.out.println("✅ AdminController asignado a IngresoDeCajero.");
            } else if (controller instanceof RegistroDeCliente) {
                RegistroDeCliente registroCliente = (RegistroDeCliente) controller;
                registroCliente.setBanco(banco);

                System.out.println("🔎 Valor de crudClienteController antes de asignar: " + crudClienteController);

                if (crudClienteController != null) {
                    registroCliente.setCrudClienteController(crudClienteController);
                    System.out.println("✅ CrudClienteController asignado correctamente.");
                } else {
                    System.out.println("⚠️ Advertencia: CrudClienteController es NULL y no fue asignado.");
                }
            } else if (controller instanceof TransaccionView) {
                TransaccionView transaccionView = (TransaccionView) controller;
                transaccionView.setBanco(banco);
                System.out.println("✅ Banco asignado correctamente a TransaccionView.");
            } else if (controller instanceof ListaClientesReporte) { // 🔥 Agregado soporte para ListaClientesReporte
                ListaClientesReporte listaClientesReporte = (ListaClientesReporte) controller;
                listaClientesReporte.setBanco(banco); // ✅ Asignar banco
                System.out.println("✅ Banco asignado correctamente a ListaClientesReporte.");
            } else {
                System.out.println("⚠️ El controlador obtenido no es de tipo esperado. Es: " + controller.getClass().getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
