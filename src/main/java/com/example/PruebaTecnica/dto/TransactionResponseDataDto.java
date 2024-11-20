package com.example.PruebaTecnica.dto;

import com.example.PruebaTecnica.entity.ProductEntity;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data

public class TransactionResponseDataDto {
    private String tipoTransaccion;

    private BigDecimal monto;

    private LocalDate fechaTransaccion;

    private ProductEntity cuentaOrigen;

    private ProductEntity cuentaDestino;
}
