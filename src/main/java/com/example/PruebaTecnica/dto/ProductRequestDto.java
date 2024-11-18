package com.example.PruebaTecnica.dto;
import com.example.PruebaTecnica.entity.ClientEntity;
import com.example.PruebaTecnica.enums.EstadoCuenta;
import com.example.PruebaTecnica.enums.TipoCuenta;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

    public class ProductRequestDto {
    private EstadoCuenta estado;

    private String numeroCuenta;

    private String saldo;

    private Boolean exentaGMF;

    private TipoCuenta tipoCuenta;

    private ClientEntity cliente;
}
