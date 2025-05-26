package org.uniquindio.edu.co.poo.proyectobancouq.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Admin;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.utills.Paths;
import org.uniquindio.edu.co.poo.proyectobancouq.viewController.IngresoAdmin;
import org.uniquindio.edu.co.poo.proyectobancouq.controller.AdminController;

import java.io.IOException;

public class App extends Application {
    public static App app;
    private Stage stageWindow;

    public Banco banco = new Banco("Banco UQ", "03071022");

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        app = this;
        inicializarAdministrador();
        stageWindow = stage;
        setScene(Paths.ELECCION_USUARIO);
    }

    private void inicializarAdministrador() {
        try {
            Admin admin = new Admin("123", "admin", "<EMAIL>", "001", "00001");

            if (banco.buscarUsuario(admin.getId()).isEmpty()) {
                banco.registrarUsuario(admin);
                System.out.println("✅ Administrador registrado correctamente.");
            } else {
                System.out.println("⚠️ Administrador ya existente.");
            }

            System.out.println("Usuarios registrados: " + banco.getListUsuarios());
        } catch (Exception e) {
            System.out.println("❌ Error al registrar el administrador: " + e.getMessage());
        }
    }

    public void setScene(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        try {
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            stageWindow.setScene(scene);
            stageWindow.show();

            // Si cargamos la pantalla de ingreso del administrador, pasamos el controlador
            if (path.equals(Paths.INGRESO_COMO_ADMIN)) {
                IngresoAdmin ingresoAdminController = loader.getController();
                ingresoAdminController.setAdminController(new AdminController(banco)); // Pasa la instancia correctamente
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}