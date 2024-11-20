package com.example.PruebaTecnica.dto;
import com.example.PruebaTecnica.entity.ClientEntity;
import com.example.PruebaTecnica.enums.AccountStatus;
import com.example.PruebaTecnica.enums.TypeAccount;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;



@Builder
@Data

public class ProductDataDto {
    private AccountStatus estado;

    private String numeroCuenta;
    @DecimalMin(value = "0.0", inclusive = false, message = "El saldo debe ser mayor a $0")
    private String saldo;

    private Boolean exentaGMF;

    private TypeAccount typeAccount;

    private ClientEntity cliente;
}
