package org.uniquindio.edu.co.poo.proyectofinalbanco.model;

import java.util.ArrayList;
import java.util.Optional;

public class Cajero extends Usuario {
    // atributos
    private String codigo;

    // Constructor
    public Cajero(String id, String nombre, String email, String password, String codigo) {
        super(id, nombre, email, password);
        this.codigo = codigo;
    }

    //metodos getter y setter
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    @Override
    public String toString(){
        return "Cajero: "        +
                super.toString() +
                "\n Codigo: "    + codigo;
    }
}