package org.uniquindio.edu.co.poo.proyectobancouq.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.proyectobancouq.utills.Paths;

import java.io.IOException;

public class App extends Application {
    public static App app;
    private Stage stageWindow;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        app = this;
        stageWindow = stage;
        setScene(Paths.ELECCION_USUARIO);
    }


    public void setScene(String path) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        try {
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            stageWindow.setScene(scene);
            stageWindow.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
