package com.example.PruebaTecnica.service;

import java.math.BigDecimal;

public interface TransactionService {
    String realizarConsignacion(String numeroCuenta, BigDecimal monto);
    String realizarRetiro(String numeroCuenta, BigDecimal monto);
    String realizarConsignacion(String cuentaOrigen, String cuentaDestino, BigDecimal monto);
}
