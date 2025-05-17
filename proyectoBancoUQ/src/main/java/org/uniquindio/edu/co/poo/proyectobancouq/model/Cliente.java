package org.uniquindio.edu.co.poo.proyectobancouq.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{

    // comunicación con otras clases
    private List<CuentaBancaria> listCuentaBancaria;


    // Constructor
    public Cliente(String id, String nombre, String email, String password) {
        super(id, nombre, email, password);
        this.listCuentaBancaria = new ArrayList<>();
    }

    public List<CuentaBancaria> getListCuentaBancaria() {
        return listCuentaBancaria;
    }

    public void setListCuentaBancaria(List<CuentaBancaria> listCuentaBancaria) {
        this.listCuentaBancaria = listCuentaBancaria;
    }

    @Override
    public String toString(){
        return "Client: "        +
                super.toString() +
                "\n Cuentas: " + listCuentaBancaria;
    }
}
