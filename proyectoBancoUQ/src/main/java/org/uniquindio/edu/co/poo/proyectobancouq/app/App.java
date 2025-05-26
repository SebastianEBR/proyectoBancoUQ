package org.uniquindio.edu.co.poo.proyectobancouq.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyectobancouq.controller.CrudUsuarioController;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Admin;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.utills.Paths;
import org.uniquindio.edu.co.poo.proyectobancouq.viewController.IngresoAdmin;
import org.uniquindio.edu.co.poo.proyectobancouq.controller.AdminController;
import org.uniquindio.edu.co.poo.proyectobancouq.viewController.RegistroUsuario;

import java.io.IOException;

public class App extends Application {

    public static App app;
    private Stage stageWindow;
    public final Banco banco = new Banco("Banco UQ", "03071022");

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        app = this;
        inicializarAdministrador();
        stageWindow = stage;

        try {
            setScene(Paths.ELECCION_USUARIO);
        } catch (IOException e) {
            System.out.println("❌ Error al cargar la escena inicial: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void inicializarAdministrador() {
        try {
            Admin admin = new Admin("123", "admin", "admin@bancouq.com", "001", "00001"); // ✅ Corregido EMAIL por un valor lógico

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
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        stageWindow.setScene(scene);
        stageWindow.show();

        System.out.println("🛠 Cargando: " + path);
        System.out.println("📌 Comprobando controlador...");

        // Configurar controladores después de cargar la escena
        if (path.equals(Paths.REGISTRO_USUARIO)) {
            RegistroUsuario registroUsuarioController = loader.getController();

            if (registroUsuarioController == null) {
                System.out.println("❌ Error: `RegistroUsuario.fxml` no se está cargando correctamente.");
                return;
            }

            registroUsuarioController.setCrudUsuarioController(new CrudUsuarioController(App.app.banco));
        } else if (path.equals(Paths.INGRESO_COMO_ADMIN)) {
            IngresoAdmin ingresoAdminController = loader.getController();

            if (ingresoAdminController == null) {
                System.out.println("❌ Error: `IngresoAdmin.fxml` no se está cargando correctamente.");
                return;
            }

            ingresoAdminController.setAdminController(new AdminController(App.app.banco));
        }
    }
}