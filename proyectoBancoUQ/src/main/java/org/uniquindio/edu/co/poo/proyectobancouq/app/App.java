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
    public Banco banco = new Banco("Uq","5156");
    //public AdminController adminController = new AdminController(banco);
    //public CrudUsuarioController crudUsuarioController =

    Admin usuario = new Admin("123456789","Admin","<EMAIL>","admin","1234");




    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        app = this;
        stageWindow = stage;
        setScene(Paths.ELECCION_USUARIO);
        banco.registrarUsuario(usuario);
    }

    public void setScene(String path) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        try {
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            stageWindow.setScene(scene);
            stageWindow.show();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}