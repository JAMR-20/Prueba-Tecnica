package com.example.PruebaTecnica.service.Impl;

import com.example.PruebaTecnica.dto.ClientDataDto;
import com.example.PruebaTecnica.dto.ClientResponseDto;
import com.example.PruebaTecnica.entity.ClientEntity;
import com.example.PruebaTecnica.exception.ClientNotFoundException;
import com.example.PruebaTecnica.mapper.ClientMapper;
import com.example.PruebaTecnica.repository.ClienRepository;
import com.example.PruebaTecnica.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.CannotLoadBeanClassException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Validated

public class ClientserviceImpl implements ClientService {
    private final ClienRepository clienRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientEntity> findAll() {
        return clienRepository.findAll();
    }

    @Override
    public ClientResponseDto findById(Long id) throws ClientNotFoundException, CannotLoadBeanClassException {
        Optional<ClientEntity> cliente = clienRepository.findById(id);

        if (!cliente.isPresent()){
            throw new ClientNotFoundException("Client is not available");

        }
        return ClientMapper.clienteEntityToClienteResponseDto("Client is available: ", cliente.get());
    }

    private boolean esMayorEdad (LocalDate fechaNacimiento){
        if (fechaNacimiento == null){
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        LocalDate hoy = LocalDate.now();
        Period edad = Period.between(fechaNacimiento, hoy);
        return edad.getYears() >= 18;
    }
    @Override
    public Object save(ClientDataDto clientDataDto) {
        if (esMayorEdad(clientDataDto.getFechaNacimiento())){
            ClientEntity MapperClient = clientMapper.toClientEntity(clientDataDto);
            MapperClient.setFechaNacimiento(LocalDate.now());
            MapperClient.setFechaModificacion(null);
            return clienRepository.save(MapperClient);
        }

        return "No es mayor de edad";

    }

    @Override
    public void delete(Long id) throws ClientNotFoundException {
        if (!clienRepository.existsById(id)) {
            throw new ClientNotFoundException("Cliente no encontrado con id " + id);
        }
        try {
            clienRepository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalStateException("Error al intentar eliminar el cliente con id " + id, e);
        }
        clienRepository.deleteById(id);
    }

    @Override
    public ClientEntity update(Long id, ClientEntity clientEntity) throws ClientNotFoundException {
        ClientEntity client = clienRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Cliente no encontrado con id: "+id));
        client.setFechaNacimiento(clientEntity.getFechaNacimiento());
        client.setApellido(clientEntity.getApellido());
        client.setFechaModificacion(clientEntity.getFechaModificacion());
        client.setEmail(clientEntity.getEmail());
        client.setFechaCreacion(clientEntity.getFechaCreacion());
        client.setNombre(clientEntity.getNombre());
        client.setNumeroIdentificacion(clientEntity.getNumeroIdentificacion());

        return clienRepository.save(client);
    }

    @Override
    public ClientResponseDto findClienteByName(String nombre) throws ClientNotFoundException {
         Optional<ClientEntity> client = clienRepository.findByName(nombre);
         if (!client.isPresent()){
             throw new IllegalArgumentException("El cliente no ha sido encontrado");
         }
         return clientMapper.clienteEntityToClienteResponseDto("El cliente ha sido encontrado con el nombre: ",client.get());
    }
}


