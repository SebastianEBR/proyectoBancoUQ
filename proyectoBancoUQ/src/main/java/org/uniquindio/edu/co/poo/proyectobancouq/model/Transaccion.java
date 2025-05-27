package org.uniquindio.edu.co.poo.proyectobancouq.model;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

public class Transaccion implements IValidarDatos {

    // atributos de la clase
    private String    codigo;
    private LocalDate fecha;
    private double    monto;
    private String    descripcion;

    private Banco banco; // referencia al banco que administra las cuentas
    // conexion con clase enum
    private TipoTransaccion tipoTransaccion;

    public Transaccion(LocalDate fecha, String monto, String descripcion, TipoTransaccion tipoTransaccion, Banco banco) throws Exception {
        if (validarDatos(generarCodigoUnico(), fecha, monto, descripcion, tipoTransaccion)) {
            this.codigo = generarCodigoUnico();
            this.fecha = fecha;
            this.monto = Double.parseDouble(monto);
            this.descripcion = descripcion;
            this.tipoTransaccion = tipoTransaccion;
            this.banco = banco;
        }
    }

    private String generarCodigoUnico() {
        Random random = new Random();
        int randomNum = random.nextInt(9000) + 1000; // ✅ Número aleatorio de 4 dígitos
        return "TX-" + LocalDate.now().getYear() + "-" + randomNum;
    }

    // 🔹 Metodo auxiliar para validar que el monto es un número
    private boolean esNumeroValido(String montoTexto) {
        try {
            Double.parseDouble(montoTexto); // ✅ Usa `Double.parseDouble()` para mayor precisión
            return true;
        } catch (NumberFormatException e) {
            return false; // ❌ Si contiene letras o caracteres inválidos, retorna falso
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "Transaccion: "           +
                "\n codigo: "            + codigo      +
                "\n fecha: "             + fecha       +
                "\n monto: "             + monto       +
                "\n descripcion: "       + descripcion +
                "\n tipoTransaccion: " + tipoTransaccion;
    }



    // metodos para movimientos financieros en las cuentas bancarias
    //metodo para deposito
    public boolean deposito(String numeroCuentaBancaria, double cantidad) throws Exception {
        // 🔥 1️⃣ Verificar que el monto a depositar sea positivo
        if (cantidad <= 0) {
            throw new Exception("❌ El monto a depositar debe ser positivo.");
        }

        // 🔎 2️⃣ Buscar la cuenta en Banco
        Optional<CuentaBancaria> cuentaOpt = banco.buscarCuenta(numeroCuentaBancaria);

        // ❌ 3️⃣ Validar que la cuenta exista antes de modificar el saldo
        if (cuentaOpt.isEmpty()) {
            throw new Exception("❌ Error: La cuenta bancaria no está registrada.");
        }

        // ✅ 4️⃣ Si la cuenta existe, realizar el depósito
        CuentaBancaria cuenta = cuentaOpt.get();
        cuenta.setSaldo(cuenta.getSaldo() + cantidad);

        return true; // Depósito exitoso
    }


    // metodo para retiro
    public boolean retiro(String numCuentaBancaria, double cantidad) throws Exception {
        if (cantidad <= 0) {
            throw new Exception("❌ El monto a retirar debe ser positivo.");
        }

        Optional<CuentaBancaria> cuentaOpt = banco.buscarCuenta(numCuentaBancaria);

        if (cuentaOpt.isEmpty()) {
            throw new Exception("❌ No se encontró una cuenta con ese número.");
        }

        CuentaBancaria cuenta = cuentaOpt.get();

        // 🔥 Nueva validación: Saldo insuficiente
        if (cuenta.getSaldo() < cantidad) {
            throw new Exception("❌ Error: Saldo insuficiente. Saldo actual: " + cuenta.getSaldo());
        }

        // ✅ Si hay saldo suficiente, procesar el retiro
        cuenta.setSaldo(cuenta.getSaldo() - cantidad);
        return true;
    }

    // metodo para consultar el saldo disponible en mi cuenta
    public double verSaldo(String numCuentaBancaria) throws Exception {
        Optional<CuentaBancaria> cuentaBancaria = banco.buscarCuenta(numCuentaBancaria);

        if (cuentaBancaria.isPresent()) {
            return cuentaBancaria.get().getSaldo();
        } else {
            throw new Exception("❌ No se encuentra una cuenta con ese número de cuenta.");
        }
    }


    // metodo para hacer transferencias entre cuentas
    public boolean transferir(String numCuentaBancaria1, String numCuentaBancaria2, double cantidad) throws Exception {
        if (cantidad <= 0) {
            throw new Exception("❌ La cantidad a transferir debe ser positiva.");
        }

        Optional<CuentaBancaria> cuentaBancaria1 = banco.buscarCuenta(numCuentaBancaria1);
        Optional<CuentaBancaria> cuentaBancaria2 = banco.buscarCuenta(numCuentaBancaria2);

        if (cuentaBancaria1.isPresent() && cuentaBancaria2.isPresent()) {
            CuentaBancaria cBancaria1 = cuentaBancaria1.get();
            CuentaBancaria cBancaria2 = cuentaBancaria2.get();

            if (cBancaria1.getSaldo() >= cantidad) {
                cBancaria1.setSaldo(cBancaria1.getSaldo() - cantidad);
                cBancaria2.setSaldo(cBancaria2.getSaldo() + cantidad);
                return true; // Transferencia exitosa
            } else {
                throw new Exception("❌ Saldo insuficiente en la cuenta origen.");
            }
        } else {
            throw new Exception("❌ No se encontró una de las cuentas.");
        }
    }

    // metodo para generar los reportes

    // metodo para validar que los datos sean correctos antes de instanciar transccion
    @Override
    public boolean validarDatos(String codigo, LocalDate fecha, String monto, String descripcion, TipoTransaccion tipoTransaccion) throws Exception {
        if (!esNumeroValido(monto)) {
            throw new Exception("❌ El monto debe ser un número válido, sin letras ni símbolos.");
        }
        double montoDouble = Double.parseDouble(monto);

        if (codigo == null || codigo.isEmpty()) {
            throw new Exception("❌ El código de la transacción no puede estar vacío.");
        }
        if (montoDouble <= 0) {
            throw new Exception("❌ El monto debe ser mayor a cero.");
        }
        if (fecha == null) {
            throw new Exception("❌ La fecha no puede ser nula.");
        }
        if (tipoTransaccion == null) {
            throw new Exception("❌ Tipo de transacción inválido.");
        }
        return true;
    }
}
