package com.example.PruebaTecnica.dto;

import com.example.PruebaTecnica.entity.ProductEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data

public class TransactionResponseDataDto {
    private String tipoTransaccion;

    private String saldoDisponible;

    private LocalDate fechaTransaccion;

    private ProductEntity cuentaOrigen;

    private ProductEntity cuentaDestino;
}
