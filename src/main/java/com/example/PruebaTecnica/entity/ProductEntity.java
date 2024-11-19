package com.example.PruebaTecnica.entity;

import com.example.PruebaTecnica.enums.AccountStatus;
import com.example.PruebaTecnica.enums.TypeAccount;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Productos")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AccountStatus estado;

    @Column(name = "numero_cuenta", length = 10, unique = true)
    private String numeroCuenta;

    @DecimalMin(value = "0.0", inclusive = false, message = "El saldo debe ser mayor a $0")
    @Column(precision = 15, scale = 2)
    private String saldo;

    private Boolean exentaGMF;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaModificacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cuenta")
    private TypeAccount tipoCuenta;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClientEntity cliente;

}
