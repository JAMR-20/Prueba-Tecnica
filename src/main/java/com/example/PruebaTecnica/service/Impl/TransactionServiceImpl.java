package com.example.PruebaTecnica.service.Impl;

import com.example.PruebaTecnica.entity.ProductEntity;
import com.example.PruebaTecnica.repository.ProductRepository;
import com.example.PruebaTecnica.repository.TransactionRepository;
import com.example.PruebaTecnica.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Validated
@Service
@RequiredArgsConstructor

public class TransactionServiceImpl implements TransactionService {
    private final ProductRepository productRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public String realizarConsignacion(String numeroCuenta, BigDecimal monto) {
        ProductEntity product = productRepository.findByNumeroCuenta(numeroCuenta);
        if (product == null){
            return "Numero de cuenta no encontrado";
        }

        if (monto.compareTo(BigDecimal.ZERO)<=0){
            return "El monto debe ser mayor a cero";
        }
        product.setSaldo(product.getSaldo().add(monto));
        productRepository.save(product);
        return "Consignacion exitosa";
    }

    @Override
    public String realizarRetiro(String numeroCuenta, BigDecimal monto) {
        ProductEntity cuenta = productRepository.findByNumeroCuenta(numeroCuenta);
        if (cuenta == null){
            return "Numero de cuenta no encontrado";
        }
        if (monto.compareTo(BigDecimal.ZERO)<=0){
            return "El valor debe ser mayor a cero";
        }
        if (cuenta.getSaldo().compareTo(monto)<0){
            return "Saldo insuficiente";
        }
        cuenta.setSaldo(cuenta.getSaldo().subtract(monto));
        productRepository.save(cuenta);
        return "Retiro realizado";
    }

    @Override
    public String realizarConsignacion(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {
        ProductEntity CuentaOrigen = productRepository.findByNumeroCuenta(cuentaOrigen);
        ProductEntity CuentaDestino = productRepository.findByNumeroCuenta(cuentaDestino);

        if (CuentaOrigen == null || CuentaDestino == null){
            return "Una o ambas cuentas no existen";
        }
        if (monto == null || monto.compareTo(BigDecimal.ZERO)<=0){
            return "El monto debe ser mayor a cero";
        }
        if (CuentaOrigen.getSaldo().compareTo(BigDecimal.ZERO)<0){
            return "Saldo insuficiente en la cuenta origen";
        }
        CuentaOrigen.setSaldo(CuentaOrigen.getSaldo().subtract(monto));
        CuentaDestino.setSaldo(CuentaDestino.getSaldo().add(monto));

        productRepository.save(CuentaOrigen);
        productRepository.save(CuentaDestino);

        return "La consignacion fue realizada con exito";
    }
}
