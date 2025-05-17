package org.uniquindio.edu.co.poo.proyectobancouq.model;

public interface IUsuarioCRUD {

    boolean registrarUsuario  (Usuario usuario);
    String  verInfoUsuario    (String id)      ;
    boolean actualizarUsuario (Usuario usuario);
    boolean eliminarUsuario   (String id)      ;
}
