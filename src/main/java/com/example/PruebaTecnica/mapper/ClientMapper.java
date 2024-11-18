package com.example.PruebaTecnica.mapper;

import com.example.PruebaTecnica.dto.ClientRequestDto;
import com.example.PruebaTecnica.entity.ClientEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientEntity toClientDto (ClientRequestDto clientRequestDto){
        return ClientEntity.builder()
                .apellido(clientRequestDto.getApellido())
                .email(clientRequestDto.getEmail())
                .fechaCreacion(clientRequestDto.getFechaCreacion())
                .fechaModificacion(clientRequestDto.getFechaModificacion())
                .fechaNacimiento(clientRequestDto.getFechaNacimiento())
                .nombre(clientRequestDto.getNombre())
                .tipoIdentificacion(clientRequestDto.getTipoIdentificacion()).build();
    }
}
