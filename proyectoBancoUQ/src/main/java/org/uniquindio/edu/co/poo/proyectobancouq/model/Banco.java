package org.uniquindio.edu.co.poo.proyectobancouq.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {
    private String nombre;
    private String nit;

    private List<Usuario> listUsuarios; // Admins y Cajeros
    private List<Cliente> listClientes; // Clientes con cuentas bancarias
    private List<CuentaBancaria> listCuentasBancarias;
    private List<Transaccion> listTransacciones;

    public Banco(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.listUsuarios = new ArrayList<>();
        this.listClientes = new ArrayList<>();
        this.listCuentasBancarias = new ArrayList<>();
        this.listTransacciones = new ArrayList<>();
    }

    // Getters y Setters
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
    public List<Cliente> getListClientes() {
        return listClientes;
    }
    public void setListClientes(List<Cliente> listClientes) {
        this.listClientes = listClientes;
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






    // CRUD de Usuarios (Admins/Cajeros)
    public boolean registrarUsuario(Usuario newUsuario) throws Exception {
        Optional<Usuario> usuarioAux = buscarUsuario(newUsuario.getId());
        if (usuarioAux.isPresent()) {
            throw new Exception("❌ Ya existe un usuario con ese ID.");
        }
        listUsuarios.add(newUsuario);
        System.out.println("usuario registrado" + listUsuarios);
        return true;
    }

    public Optional<Usuario> buscarUsuario(String id) {
        return listUsuarios.stream().filter(usuario -> usuario.getId().equals(id)).findFirst();
    }

    public boolean actualizarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioAux = buscarUsuario(usuario.getId());
        if (usuarioAux.isEmpty()) {
            return false;
        }
        Usuario usuarioEncontrado = usuarioAux.get();
        usuarioEncontrado.setNombre(usuario.getNombre());
        usuarioEncontrado.setPassword(usuario.getPassword());
        return true;
    }

    public boolean eliminarUsuario(String id) {
        return listUsuarios.removeIf(usuario -> usuario.getId().equals(id));
    }




    // CRUD de Clientes
    public boolean registrarCliente(Cliente newCliente, CuentaBancaria newCuentaBancaria) throws Exception {
        Optional<Cliente> clienteAux = buscarCliente(newCliente.getId());
        if (clienteAux.isPresent()) {
            throw new Exception("❌ Ya existe un cliente con ese ID.");
        }
        agregarCuentaCliente(newCuentaBancaria, newCliente);
        listClientes.add(newCliente);
        return true;
    }

    public Optional<Cliente> buscarCliente(String id) {
        return listClientes.stream().filter(cliente -> cliente.getId().equals(id)).findFirst();
    }

    public boolean actualizarCliente(Cliente clienteActualizado) {
        Optional<Cliente> clienteAux = buscarCliente(clienteActualizado.getId());
        if (clienteAux.isEmpty()) {
            return false;
        }
        Cliente clienteExistente = clienteAux.get();
        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setPassword(clienteActualizado.getPassword());
        clienteExistente.setListCuentaBancaria(clienteActualizado.getListCuentaBancaria());
        return true;
    }

    public boolean eliminarCliente(String id) {
        Optional<Cliente> clienteAux = buscarCliente(id);
        if (clienteAux.isPresent()) {
            Cliente clienteEncontrado = clienteAux.get();
            clienteEncontrado.getListCuentaBancaria().forEach(cuenta -> eliminarCuenta(cuenta.getNumeroCuenta()));
            listClientes.remove(clienteEncontrado);
            return true;
        }
        return false;
    }




    // CRUD de Cuentas Bancarias
    public boolean registrarCuenta(CuentaBancaria newCuenta) throws Exception {
        Optional<CuentaBancaria> cuentaAux = buscarCuenta(newCuenta.getNumeroCuenta());
        if (cuentaAux.isPresent()) {
            throw new Exception("❌ Ya existe una cuenta con ese número.");
        }
        listCuentasBancarias.add(newCuenta);
        return true;
    }

    public boolean eliminarCuenta(String numeroCuenta) {
        return listCuentasBancarias.removeIf(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta));
    }

    public Optional<CuentaBancaria> buscarCuenta(String numCuentaBancaria) {
        return listCuentasBancarias.stream()
                .filter(cuenta -> cuenta.getNumeroCuenta().equals(numCuentaBancaria))
                .findFirst();
    }

    public void agregarCuentaCliente(CuentaBancaria newCuentaBancaria, Cliente cliente) throws Exception {
        if (!registrarCuenta(newCuentaBancaria)) {
            throw new Exception("❌ No se pudo registrar la cuenta.");
        }
        newCuentaBancaria.setCliente(cliente);
        cliente.agregarCuenta(newCuentaBancaria);
    }




    // CRUD de Transacciones
    public boolean registrarTransaccion(Transaccion transaccion, String numeroCuenta, String... numeroCuenta2) throws Exception {
        if (buscarTransaccion(transaccion.getCodigo()).isPresent()) {
            throw new Exception("❌ Ya existe una transacción con ese código.");
        }

        if (transaccion.getTipoTransaccion().equals(TipoTransaccion.TRANSFERENCIA)) {
            if (numeroCuenta2.length == 0) {
                throw new Exception("❌ Se requiere una cuenta destino para la transferencia.");
            }
            transaccion.transferir(numeroCuenta, numeroCuenta2[0], Double.parseDouble(transaccion.getMonto()));
        } else if (transaccion.getTipoTransaccion().equals(TipoTransaccion.DEPOSITO)) {
            transaccion.deposito(numeroCuenta, Double.parseDouble(transaccion.getMonto()));
        } else if (transaccion.getTipoTransaccion().equals(TipoTransaccion.RETIRO)) {
            transaccion.retiro(numeroCuenta, Double.parseDouble(transaccion.getMonto()));
        }

        listTransacciones.add(transaccion);
        return true;
    }
    public Optional<Transaccion> buscarTransaccion(String codigoTransaccion) {
        return listTransacciones.stream()
                .filter(transaccion -> transaccion.getCodigo().equals(codigoTransaccion))
                .findFirst();
    }

    // Validar credenciales para login
    public Optional<Usuario> validarCredenciales(String id, String nombre, String password) {
        return listUsuarios.stream()
                .filter(usuario -> usuario.getId().equals(id) &&
                        usuario.getNombre().equals(nombre) &&
                        usuario.getPassword().equals(password))
                .findFirst();
    }



    // Ver información de una cuenta bancaria
    public String verInfoCuenta(String numeroCuenta) {
        Optional<CuentaBancaria> cuentaAux = buscarCuenta(numeroCuenta);
        return cuentaAux.map(CuentaBancaria::toString).orElse("❌ Cuenta no encontrada.");
    }

    // Ver información de una transacción
    public String verInfoTransaccion(String codigoTransaccion) {
        Optional<Transaccion> transaccionAux = buscarTransaccion(codigoTransaccion);
        return transaccionAux.map(Transaccion::toString).orElse("❌ Transacción no encontrada.");
    }




    @Override
    public String toString() {
        return "Banco: " +
                "\n Nombre: " + nombre +
                "\n Nit: " + nit +
                "\n Lista de usuarios (Admins/Cajeros): " + listUsuarios +
                "\n Lista de clientes: " + listClientes +
                "\n Lista de cuentas: " + listCuentasBancarias +
                "\n Lista de transacciones: " + listTransacciones;
    }
}
