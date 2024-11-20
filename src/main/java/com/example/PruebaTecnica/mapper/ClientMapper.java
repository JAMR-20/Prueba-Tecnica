package com.example.PruebaTecnica.mapper;

import com.example.PruebaTecnica.dto.ClientDataDto;
import com.example.PruebaTecnica.dto.ClientResponseDataDto;
import com.example.PruebaTecnica.dto.ClientResponseDto;
import com.example.PruebaTecnica.entity.ClientEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {


    public ClientEntity toClientEntity (ClientDataDto clientDataDto){
        return ClientEntity.builder()
                .apellido(clientDataDto.getApellido())
                .email(clientDataDto.getEmail())
                .nombre(clientDataDto.getNombre())
                .numeroIdentificacion(clientDataDto.getNumeroIdentificacion())
                .build();
    }
    public ClientDataDto toClientDto (ClientEntity clientEntity){
        return ClientDataDto.builder()
                .apellido(clientEntity.getApellido())
                .email(clientEntity.getEmail())
                .nombre(clientEntity.getNombre())
                .numeroIdentificacion(clientEntity.getNumeroIdentificacion())
                .tipoIdentificacion(clientEntity.getTipoIdentificacion())
                .fechaNacimiento(clientEntity.getFechaNacimiento())
                .build();
    }


    public static ClientResponseDto clienteEntityToClienteResponseDto(String message, ClientEntity cliente){
        return ClientResponseDto.
                builder()
                .code("200")
                .message(message)
                .data(
                        ClientResponseDataDto
                                .builder()
                                .apellido(cliente.getApellido())
                                .nombre(cliente.getNombre())
                                .numeroIdentificacion(cliente.getNumeroIdentificacion())
                                .email(cliente.getEmail())
                                .build()
                )
                .build();
    }
}
