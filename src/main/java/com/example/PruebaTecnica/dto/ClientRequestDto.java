package com.example.PruebaTecnica.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientRequestDto {
    private String tipoIdentificacion;

    private String numeroIdentificacion;

    private String nombre;

    private String apellido;

    private String email;

    private LocalDate fechaNacimiento;


    private LocalDateTime fechaCreacion;


    private LocalDateTime fechaModificacion;
}
