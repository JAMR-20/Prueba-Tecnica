package com.example.PruebaTecnica.mapper;

import com.example.PruebaTecnica.dto.ClientDataDto;
import com.example.PruebaTecnica.dto.ClientRequestDto;
import com.example.PruebaTecnica.dto.ClientResponseDto;
import com.example.PruebaTecnica.entity.ClientEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientMapper {
    public ClientEntity toClientEntity (ClientRequestDto clientRequestDto){
        return ClientEntity.builder()
                .apellido(clientRequestDto.getApellido())
                .email(clientRequestDto.getEmail())
                .fechaCreacion(clientRequestDto.getFechaCreacion())
                .fechaModificacion(clientRequestDto.getFechaModificacion())
                .fechaNacimiento(clientRequestDto.getFechaNacimiento())
                .nombre(clientRequestDto.getNombre())
                .tipoIdentificacion(clientRequestDto.getTipoIdentificacion()).build();
    }
    public ClientDataDto toClientDto (ClientEntity clientEntity){
        return ClientDataDto.builder()
                .apellido(clientEntity.getApellido())
                .email(clientEntity.getEmail())
                .nombre(clientEntity.getNombre())
                .numeroIdentificacion(clientEntity.getNumeroIdentificacion())
                .build();
    }
    public ClientResponseDto toClientResponse (ClientEntity clientEntity){
        ClientDataDto clientDataDto = toClientDto(clientEntity);
        return ClientResponseDto.builder()
                .code("200")
                .data(clientDataDto)
                .message("")
                .build();
    }
}
