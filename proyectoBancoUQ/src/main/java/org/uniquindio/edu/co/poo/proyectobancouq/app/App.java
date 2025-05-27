package org.uniquindio.edu.co.poo.proyectobancouq.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyectobancouq.controller.AdminController;
import org.uniquindio.edu.co.poo.proyectobancouq.controller.CrudClienteController;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Admin;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.utills.Paths;
import org.uniquindio.edu.co.poo.proyectobancouq.viewController.IngresoAdmin;
import org.uniquindio.edu.co.poo.proyectobancouq.viewController.IngresoDeCajero;
import org.uniquindio.edu.co.poo.proyectobancouq.viewController.RegistroDeCliente;
import org.uniquindio.edu.co.poo.proyectobancouq.viewController.RegistroUsuario;

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
        banco.registrarUsuario(usuario);
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

                // 🔥 Validar si crudClienteController ya tiene una referencia asignada
                System.out.println("🔎 Valor de crudClienteController antes de asignar: " + crudClienteController);

                if (crudClienteController != null) {
                    registroCliente.setCrudClienteController(crudClienteController);
                    System.out.println("✅ CrudClienteController asignado correctamente.");
                } else {
                    System.out.println("⚠️ Advertencia: CrudClienteController es NULL y no fue asignado.");
                }
            } else {
                System.out.println("⚠️ El controlador obtenido no es de tipo esperado. Es: " + controller.getClass().getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}