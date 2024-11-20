package com.example.PruebaTecnica.dto;

import lombok.*;

@Builder
@Data
public class ClientResponseDataDto {

    private String numeroIdentificacion;

    private String nombre;

    private String apellido;

    private String email;
}
