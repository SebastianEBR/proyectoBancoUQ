package org.uniquindio.edu.co.poo.proyectobancouq.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyectobancouq.controller.AdminController;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Admin;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.utills.Paths;
import org.uniquindio.edu.co.poo.proyectobancouq.viewController.IngresoAdmin;
import org.uniquindio.edu.co.poo.proyectobancouq.viewController.RegistroUsuario;

import java.io.IOException;

public class App extends Application {

    public static App app;
    private Stage stageWindow;
    public Banco banco;
    private AdminController adminController;

    public App() throws Exception {
        banco = new Banco("Uq", "5156");
        System.out.println("Banco iniciado: " + banco);
        this.adminController = new AdminController(banco);
        System.out.println("AdminController iniciado: " + adminController);

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

            // Si el controlador es RegistroUsuario, asignar el banco
            if (controller instanceof RegistroUsuario) {
                RegistroUsuario registroUsuario = (RegistroUsuario) controller;
                registroUsuario.setBanco(banco); // 🔥 Asignar banco aquí
                System.out.println("✅ Banco asignado a RegistroUsuario.");
            } else if (controller instanceof IngresoAdmin) {
                IngresoAdmin ingresoAdmin = (IngresoAdmin) controller;
                ingresoAdmin.setAdminController(adminController);
                System.out.println("✅ adminController asignado correctamente a IngresoAdmin.");
            } else {
                System.out.println("⚠️ El controlador obtenido no es de tipo esperado. Es: " + controller.getClass().getName());
            }

        } catch (IOException e) {
            e.printStackTrace(); // Puedes mejorar esto con un Logger
        }
    }
}