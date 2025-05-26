package org.uniquindio.edu.co.poo.proyectobancouq.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String id;
    private String nombre;
    private String email;
    private String password;


    // comunicación con otras clases
    private List<CuentaBancaria> listCuentaBancaria;


    // Constructor
    public Cliente(String id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.listCuentaBancaria = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CuentaBancaria> getListCuentaBancaria() {
        return listCuentaBancaria;
    }

    public void setListCuentaBancaria(List<CuentaBancaria> listCuentaBancaria) {
        this.listCuentaBancaria = listCuentaBancaria;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", listCuentaBancaria=" + listCuentaBancaria +
                '}';
    }

    public void agregarCuenta(CuentaBancaria newCuentaBancaria) {
        this.listCuentaBancaria.add(newCuentaBancaria);
    }
}
