package com.example.PruebaTecnica.repository;

import com.example.PruebaTecnica.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<ProductEntity, Long> {
}
