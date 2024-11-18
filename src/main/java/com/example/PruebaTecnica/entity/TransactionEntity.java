package com.example.PruebaTecnica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Productos")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_transaccion")
    private String tipoTransaccion;

    private String saldoDisponible;

    @Column(name = "fecha_transaccion")
    private LocalDate fechaTransaccion;

    @ManyToOne
    @JoinColumn(name = "cuenta_id_origen")
    private ProductEntity cuentaOrigen;

    @ManyToOne
    @JoinColumn(name = "cuenta_id_destino")
    private ProductEntity cuentaDestino;
}
