package com.example.PruebaTecnica.service;

import com.example.PruebaTecnica.dto.ProductResponseDataDto;
import com.example.PruebaTecnica.dto.ProductResponseDto;
import com.example.PruebaTecnica.entity.ProductEntity;
import com.example.PruebaTecnica.enums.TypeAccount;
import com.example.PruebaTecnica.exception.ClientNotFoundException;
import com.example.PruebaTecnica.exception.ProductNotFoundException;

import java.math.BigDecimal;

public interface ProductService {
    ProductEntity save(TypeAccount tipocuenta, BigDecimal saldo, Boolean exentaGMF, Long clienteId) throws ClientNotFoundException;
    ProductEntity updateProduct(Long id, ProductResponseDataDto productResponseDataDto);
}
