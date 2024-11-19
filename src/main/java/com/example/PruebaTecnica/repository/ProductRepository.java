package com.example.PruebaTecnica.repository;

import com.example.PruebaTecnica.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    boolean existByNumeroCuenta(String numeroCuenta);

    ProductEntity findByNumeroCuenta(String numeroCuenta);
}
