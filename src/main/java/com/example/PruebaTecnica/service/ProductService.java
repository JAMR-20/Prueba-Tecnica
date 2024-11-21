package com.example.PruebaTecnica.service;

import com.example.PruebaTecnica.dto.ProductRequestDto;
import com.example.PruebaTecnica.entity.ProductEntity;
import com.example.PruebaTecnica.enums.TypeAccount;
import com.example.PruebaTecnica.exception.ClientNotFoundException;

import java.math.BigDecimal;

public interface ProductService {
    ProductEntity save(TypeAccount tipocuenta, BigDecimal saldo, Boolean exentaGMF, Long clienteId) throws ClientNotFoundException;
    ProductEntity updateProduct(Long id, ProductRequestDto productRequestDto);
}
