package com.example.PruebaTecnica.service;

import com.example.PruebaTecnica.dto.ClientDataDto;
import com.example.PruebaTecnica.dto.ClientResponseDto;
import com.example.PruebaTecnica.entity.ClientEntity;
import com.example.PruebaTecnica.exception.ClientNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<ClientEntity> findAll();

    ClientResponseDto findById(Long id) throws ClientNotFoundException;

    Object save (ClientDataDto clientDataDto);

    void delete (Long id) throws ClientNotFoundException;

    ClientEntity update (Long id, ClientEntity clientEntity) throws ClientNotFoundException;

    ClientResponseDto findClienteByName (String nombre) throws ClientNotFoundException;



}
