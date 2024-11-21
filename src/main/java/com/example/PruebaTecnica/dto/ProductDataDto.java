package com.example.PruebaTecnica.dto;
import com.example.PruebaTecnica.entity.ClientEntity;
import com.example.PruebaTecnica.enums.AccountStatus;
import com.example.PruebaTecnica.enums.TypeAccount;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.math.BigDecimal;


@Builder
@Data

public class ProductDataDto {

    private TypeAccount tipoCuenta;
    private BigDecimal saldo;
    private Boolean exentaGMF;
    private Long clienteId;
}
