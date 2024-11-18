package com.example.PruebaTecnica.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Clientes")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;

    @Column(name = "numero_identificacion", unique = true)
    @NotBlank(message = "El numero de indentificacion en obligatorio")
    private String numeroIdentificacion;

    @Column(name = "nombre")
    @NotBlank(message = "El nombre del cliente es obligatorio")
    @Size(min = 2, message = "El nombre debe tener al menos dos caracteres")
    private String nombre;

    @Column(name = "apellido")
    @NotBlank(message = "El apellido del cliente es obligatorio")
    @Size(min = 2, message = "El apellido debe tener al menos dos caracteres")
    private String apellido;

    @Column(name = "correro_electronico", unique = true, nullable = false)
    @NotBlank(message = "El correo electronico es obligatorio")
    @Email (message = "Ingrese un correo con un formato xxxx@xxxxx.xxx")
    private String email;

    private LocalDate fechaNacimiento;


    private LocalDateTime fechaCreacion;


    private LocalDateTime fechaModificacion;



}
