package org.uniquindio.edu.co.poo.proyectobancouq.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco{

    // atributos
    private String nombre;
    private String nit;

    // comunicación con otras clases
    private List<Usuario>        listUsuarios;
    private List<CuentaBancaria> listCuentasBancarias;
    private List<Transaccion>    listTransacciones;


    // Constructor
    public Banco(String nombre, String nit){
        this.nombre               = nombre;
        this.nit                  = nit;
        this.listUsuarios         = new ArrayList<>();
        this.listCuentasBancarias = new ArrayList<>();
        this.listTransacciones    = new ArrayList<>();
    }

    // metodos setter y getter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public List<CuentaBancaria> getListCuentasBancarias() {
        return listCuentasBancarias;
    }

    public void setListCuentasBancarias(List<CuentaBancaria> listCuentasBancarias) {
        this.listCuentasBancarias = listCuentasBancarias;
    }

    public List<Transaccion> getListTransacciones() {
        return listTransacciones;
    }

    public void setListTransacciones(List<Transaccion> listTransacciones) {
        this.listTransacciones = listTransacciones;
    }

    // metodo toString
    @Override
    public String toString(){
        return "Banco: "                      +
                "\n Nombre: "                 + nombre               +
                "\n Nit: "                    + nit                  +
                "\n Lista de usarios: "       + listUsuarios         +
                "\n Lista de cuentas: "       + listCuentasBancarias +
                "\n Lista de transacciones: " + listTransacciones;
    }


    // CRUD de usuarios
    // metodo para registrar usuarios
    public boolean registrarUsuario(Usuario newUsuario) throws Exception {
        Optional<Usuario> usuarioAux = buscarUsuario(newUsuario.getId());
        if(usuarioAux.isPresent()){
            throw new Exception("Ya existe un usuario con ese ID");
        }
        listUsuarios.add(newUsuario);//agregar nuevo usuarioCliente a Banco
        return true; // registro exitoso
    }

    // (sobrecarga) metodo especial para cuando es un cliente
    public boolean registrarUsuario(Cliente newCliente, CuentaBancaria newCuentaBancaria) throws Exception {
        Optional<Usuario> usuarioAux = buscarUsuario(newCliente.getId());
        if(usuarioAux.isPresent()){
            throw new Exception("Ya existe un Cliente con ese ID");
        }
        registrarCuenta(newCuentaBancaria);          // ✅ Se registra la cuenta en el banco
        newCuentaBancaria.setCliente(newCliente);    // ✅ Se asigna el cliente a la cuenta
        newCliente.agregarCuenta(newCuentaBancaria); // ✅ Cliente vincula la cuenta en su lista
        listUsuarios.add(newCliente);                // ✅ Finalmente, agregamos el cliente al banco


        return true;
    }

    //metodo para ver la informacion de un usuario
    public String verInfoUsuario(String id) {
        Optional<Usuario> usuarioAux = buscarUsuario(id);
        return usuarioAux.map(Usuario::toString).orElse("Usuario no encontrado");
    }

    // metodo para actualizar un usuario
    public boolean actualizarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioAux = buscarUsuario(usuario.getId());

        if (usuarioAux.isEmpty()) {
            return false; // Usuario no encontrado
        }

        Usuario usuarioEncontrado = usuarioAux.get();
        usuarioEncontrado.setNombre(usuario.getNombre());
        usuarioEncontrado.setPassword(usuario.getPassword());

        if (usuarioEncontrado instanceof Cliente && usuario instanceof Cliente) {
            Cliente clienteActualizado = (Cliente) usuario;
            Cliente clienteExistente = (Cliente) usuarioEncontrado;

            clienteExistente.setListCuentaBancaria(clienteActualizado.getListCuentaBancaria());
        }

        return true; // Usuario actualizado correctamente
    }


    // metodo para eliminar un usuario
    public boolean eliminarUsuario(String id){
        Optional<Usuario> usuarioAux = buscarUsuario(id);
        if(usuarioAux.isPresent()){
            listUsuarios.remove(usuarioAux.get());
        }else {
            return false;
        }
        return true;
    }

    // metodo para buscar usuarios
    public Optional<Usuario> buscarUsuario(String id){
        return listUsuarios.stream().filter(usuario -> usuario.getId().equals(id)).findFirst();
    }


    // CRUD relacionado de cuentas Bancarias
    // metodo para registrar una cuenta
    public boolean registrarCuenta(CuentaBancaria newCuenta) throws Exception {

        if (buscarCuenta(newCuenta.getNumeroCuenta()).isPresent()) {
            throw new Exception("❌ Ya existe una cuenta con ese número.");
        }

        listCuentasBancarias.add(newCuenta);
        return true;
    }

    //metodo para ver la informacion de una cuenta
    public String verInfoCuenta(String numeroCuenta) {
        Optional<CuentaBancaria> cuentaAux = buscarCuenta(numeroCuenta);
        return cuentaAux.map(CuentaBancaria::toString).orElse("Cuenta no encontrado");
    }

    // metodo para actualizar una cuenta
//    public boolean actualizarCuenta(CuentaBancaria cuenta) {
//        Optional<CuentaBancaria> cuentaAux = buscarCuenta(cuenta.getNumeroCuenta());
//
//        if (cuentaAux.isEmpty()) {
//            return false; // cuenta no encontrado
//        }
//
//        CuentaBancaria cuentaEncontrada = cuentaAux.get();
//        cuentaEncontrada.set(cuenta.getNombre());
//        cuentaEncontrada.setPassword(cuenta.getPassword());
//
//        if (cuentaEncontrada instanceof Cliente && usuario instanceof Cliente) {
//            Cliente clienteActualizado = (Cliente) usuario;
//            Cliente clienteExistente = (Cliente) cuentaEncontrada;
//
//            clienteExistente.setListCuentaBancaria(clienteActualizado.getListCuentaBancaria());
//        }
//
//        return true; // Usuario actualizado correctamente
//    }


    // metodo para eliminar una cuenta
    public boolean eliminarCuenta(String numeroCuenta){
        boolean eliminado = true;
        Optional<CuentaBancaria> cuentaAux = buscarCuenta(numeroCuenta);
        if(cuentaAux.isPresent()){
            listCuentasBancarias.remove(cuentaAux.get());
        }else {
            eliminado = false;
        }
        return eliminado;
    }

    // metodo para buscar cuentas bancarias
    public Optional<CuentaBancaria> buscarCuenta(String numCuentaBancaria) {
        return listCuentasBancarias.stream().filter(cuenta -> cuenta.getNumeroCuenta().equals(numCuentaBancaria)).findFirst();
    }

    // CRUD de transaccion
    // metodo para registrar una transaccion
    // Metodo para depósitos y retiros
    public boolean registrarTransaccion(Transaccion transaccion, String numeroCuenta, String... numeroCuenta2) throws Exception {
        if (buscarTransaccion(transaccion.getCodigo()).isPresent()) {
            throw new Exception("Ya existe una transacción con ese código");
        }

        if (transaccion.getTipoTransaccion().equals(TipoTransaccion.TRANSFERENCIA)) {
            if (numeroCuenta2.length == 0) {
                throw new Exception("❌ Se requiere una cuenta destino para la transferencia.");
            }
            transaccion.transferir(numeroCuenta, numeroCuenta2[0], transaccion.getMonto());
        } else if (transaccion.getTipoTransaccion().equals(TipoTransaccion.DEPOSITO)) {
            transaccion.deposito(numeroCuenta, transaccion.getMonto());
        } else if (transaccion.getTipoTransaccion().equals(TipoTransaccion.RETIRO)) {
            transaccion.retiro(numeroCuenta, transaccion.getMonto());
        }

        listTransacciones.add(transaccion); // ✅ Guarda la transacción en la lista

        // 🔹 NOTIFICACIÓN OPCIONAL: Llamamos a `Reporte` después de registrar la transacción
        System.out.println(Reporte.generarReporteMovimientos(listTransacciones));

        return true;
    }




    // metodo para ver la info de una transaccion
    public String verInfoTransaccion(String numeroTransaccion) throws Exception {
        Optional<Transaccion> transaccionAux = buscarTransaccion(numeroTransaccion);
        if(transaccionAux.isPresent()){
            return transaccionAux.get().toString();
        } else {
            throw new Exception("No se encontró una transaccion con ese numero");
        }
    }

    // metodo para buscar transaccion
    public Optional<Transaccion> buscarTransaccion(String codigoTransaccion) {
        return listTransacciones.stream().filter(transaccion -> transaccion.getCodigo().equals(codigoTransaccion)).findFirst();
    }

    // metodo para validad las credenciales en el login
    public Usuario validarCredenciales(String id, String password) {
        for (Usuario usuario : listUsuarios) {
            if (usuario.getId().equals(id) && usuario.getPassword().equals(password)) {
                return usuario; // Devuelve el usuario si las credenciales son correctas
            }
        }
        return null; // Retorna null si no encuentra coincidencias
    }

}

