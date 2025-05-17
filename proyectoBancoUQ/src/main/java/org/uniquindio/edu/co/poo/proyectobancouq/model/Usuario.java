package org.uniquindio.edu.co.poo.proyectobancouq.model;

public abstract class Usuario{
    // atributos
    private String id;
    private String nombre;
    private String email;
    private String password;


    // Constructor
    public Usuario(String nombre, String id, String email, String password) {
        this.nombre = nombre;
        this.password = password;
        this.id       = id;
        this.email    = email;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "\n"           +
                "\n Nombre: " + nombre +
                "\n ID: "     + id     +
                "\n Email: "  + password;

    }
}