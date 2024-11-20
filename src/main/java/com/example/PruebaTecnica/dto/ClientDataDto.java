package com.example.PruebaTecnica.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Builder
@Data
public class ClientDataDto {

    @NotBlank(message = "El numero de indentificacion en obligatorio")
    private String numeroIdentificacion;

    @NotBlank(message = "El nombre del cliente es obligatorio")
    @Size(min = 2, message = "El nombre debe tener al menos dos caracteres")
    private String nombre;

    @NotBlank(message = "El apellido del cliente es obligatorio")
    @Size(min = 2, message = "El apellido debe tener al menos dos caracteres")
    private String apellido;

    @NotBlank(message = "El correo electronico es obligatorio")
    @Email(message = "Ingrese un correo con un formato xxxx@xxxxx.xxx")
    private String email;

    private String tipoIdentificacion;

    private LocalDate fechaNacimiento;
}
