package com.example.PruebaTecnica.repository;

import com.example.PruebaTecnica.dto.ClientDataDto;
import com.example.PruebaTecnica.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByName (String nombre);
    }