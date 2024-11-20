package com.example.PruebaTecnica.dto;
import com.example.PruebaTecnica.entity.ProductEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Builder
@Data

public class TransactionDataDto {
    private String tipoTransaccion;

    private String saldoDisponible;

    private LocalDate fechaTransaccion;

    private ProductEntity cuentaOrigen;

    private ProductEntity cuentaDestino;
}
