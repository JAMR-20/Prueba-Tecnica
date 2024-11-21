package com.example.PruebaTecnica.dto;
import com.example.PruebaTecnica.entity.ClientEntity;
import com.example.PruebaTecnica.enums.AccountStatus;
import com.example.PruebaTecnica.enums.TypeAccount;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Data


    public class ProductRequestDto {
    private AccountStatus estado;

    private String numeroCuenta;

    private BigDecimal saldo;

    private Boolean exentaGMF;

    private TypeAccount typeAccount;

    private ClientEntity cliente;
}
