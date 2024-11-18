package com.example.PruebaTecnica.dto;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDataDto {

    private String numeroIdentificacion;

    private String nombre;

    private String apellido;

    private String email;
}
