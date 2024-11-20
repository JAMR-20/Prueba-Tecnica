package com.example.PruebaTecnica.dto;
import com.example.PruebaTecnica.entity.ClientEntity;
import com.example.PruebaTecnica.enums.AccountStatus;
import com.example.PruebaTecnica.enums.TypeAccount;
import lombok.*;

@Builder
@Data


    public class ProductResponseDataDto {
    private AccountStatus estado;

    private String numeroCuenta;

    private String saldo;

    private Boolean exentaGMF;

    private TypeAccount typeAccount;

    private ClientEntity cliente;
}
