package com.example.PruebaTecnica.service.Impl;

import com.example.PruebaTecnica.dto.ProductResponseDataDto;
import com.example.PruebaTecnica.entity.ClientEntity;
import com.example.PruebaTecnica.entity.ProductEntity;
import com.example.PruebaTecnica.enums.AccountStatus;
import com.example.PruebaTecnica.enums.TypeAccount;
import com.example.PruebaTecnica.exception.ClientNotFoundException;
import com.example.PruebaTecnica.repository.ClienRepository;
import com.example.PruebaTecnica.repository.ProductRepository;
import com.example.PruebaTecnica.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Validated
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ClienRepository clienRepository;

    private String generarNumero(TypeAccount tipoCuenta){
        String prefijo = tipoCuenta == TypeAccount.AHORROS ? "33" : "53";
        String numeroRestante = String.format("%08d", (int) (Math.random() * 100000000));
        return prefijo + numeroRestante;
    }

    @Override
    public ProductEntity save(TypeAccount tipocuenta, BigDecimal saldo, Boolean exentaGMF, Long clienteId) throws ClientNotFoundException {
        if (tipocuenta == TypeAccount.AHORROS && saldo.compareTo(BigDecimal.ZERO)<=0){
            throw new IllegalArgumentException("La cuenta de ahorros debe ser mayor a cero");
        }

        String numeroCuenta = generarNumero(tipocuenta);

        if (productRepository.existByNumeroCuenta(numeroCuenta)){
            throw new IllegalArgumentException("El cliente ya existe");
        }
        ClientEntity client = clienRepository.findById(clienteId)
                .orElseThrow(()-> new ClientNotFoundException("El cliente ya existe con el id: " + clienteId));

        ProductEntity producto = new ProductEntity();
        producto.setTipoCuenta(tipocuenta);
        producto.setNumeroCuenta(numeroCuenta);
        producto.setEstado(AccountStatus.ACTIVA);
        producto.setSaldo(producto.getSaldo());
        producto.setExentaGMF(exentaGMF);
        producto.setFechaCreacion(LocalDateTime.now());
        producto.setFechaModificacion(null);
        producto.setCliente(client);

        return productRepository.save(producto);
    }

    @Override
    public ProductEntity updateProduct(Long id, ProductResponseDataDto productResponseDataDto){
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Producto no encontrado con id: " +id));

        if (productResponseDataDto.getEstado() != null){
            product.setEstado(productResponseDataDto.getEstado());

            if (product.getTipoCuenta() == TypeAccount.AHORROS&&
                product.getEstado() == AccountStatus.CANCELADA&&
                product.getSaldo().compareTo(BigDecimal.ZERO) <= 0){
                throw new IllegalArgumentException("El valor para las cuentas de ahorros debe ser mayor a cero");
            }
        }
        product.setFechaModificacion(LocalDateTime.now());
        return productRepository.save(product);
    }
}
