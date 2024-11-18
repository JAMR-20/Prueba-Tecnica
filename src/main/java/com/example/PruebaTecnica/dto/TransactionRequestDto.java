package com.example.PruebaTecnica.dto;

import com.example.PruebaTecnica.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDto {
    private String tipoTransaccion;

    private String saldoDisponible;

    private LocalDate fechaTransaccion;

    private ProductEntity cuentaOrigen;

    private ProductEntity cuentaDestino;
}
