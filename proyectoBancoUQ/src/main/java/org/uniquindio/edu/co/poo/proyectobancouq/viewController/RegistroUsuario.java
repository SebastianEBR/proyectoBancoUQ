package org.uniquindio.edu.co.poo.proyectobancouq.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.uniquindio.edu.co.poo.proyectobancouq.app.App;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Banco;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Cajero;
import org.uniquindio.edu.co.poo.proyectobancouq.model.Usuario;

public class RegistroUsuario {

    App app;


    @FXML
    private Button btnEditar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private ComboBox<?> cbCargo;

    @FXML
    private TableColumn<?, ?> colCorreo;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colNombres;

    @FXML
    private TableView<Usuario> tableUs;

    @FXML
    private TextField txtClave;

    @FXML
    private TextField txtCodigoUnico;

    @FXML
    private TextField txtCorreoElectronico;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNumIdentificacion;

    private Banco banco;



    @FXML
    void EditarUsuario(ActionEvent event) {

    }

    @FXML
    void EliminarUsuario(ActionEvent event) {

    }

    @FXML
    void LimpiarUsuario(ActionEvent event) {

    }

    @FXML
    void RegistrarUsuario(ActionEvent event) throws Exception {
        String nombre = txtNombre.getText();
        String correo = txtCorreoElectronico.getText();
        String idUnico = txtCodigoUnico.getText();
        String contraseña = txtClave.getText();
        String numIdentificacion = txtNumIdentificacion.getText();

        Usuario usuario = new Cajero(numIdentificacion, nombre,correo,contraseña,idUnico);
        banco.registrarUsuario(usuario);

        ActualizaTabla();

        }


        private void ActualizaTabla() {
        tableUs.getItems().clear();
        tableUs.getItems().addAll(banco.getListUsuarios());
        tableUs.refresh();
    }


    public void setBanco(Banco uq) {
        this.banco = uq;
    }
}



