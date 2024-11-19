package com.example.PruebaTecnica.mapper;

import com.example.PruebaTecnica.dto.ProductDataDto;
import com.example.PruebaTecnica.dto.ProductRequestDto;
import com.example.PruebaTecnica.dto.ProductResponseDto;
import com.example.PruebaTecnica.entity.ClientEntity;
import com.example.PruebaTecnica.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductEntity toProductEntity (ProductRequestDto productRequestDto){
        return ProductEntity.builder()
                .saldo(productRequestDto.getSaldo())
                .estado(productRequestDto.getEstado())
                .numeroCuenta(productRequestDto.getNumeroCuenta())
                .exentaGMF(productRequestDto.getExentaGMF())
                .cliente(productRequestDto.getCliente())
                .tipoCuenta(productRequestDto.getTypeAccount())
                .fechaModificacion(productRequestDto.getCliente().getFechaModificacion()).build();
    }
    public ProductDataDto toProductDto (ProductEntity productEntity){
        return ProductDataDto.builder()
                .cliente(productEntity.getCliente())
                .estado(productEntity.getEstado())
                .exentaGMF(productEntity.getExentaGMF())
                .numeroCuenta(productEntity.getNumeroCuenta())
                .saldo(productEntity.getSaldo())
                .typeAccount(productEntity.getTipoCuenta())
                .build();
    }
    public ProductResponseDto toResponseDto (ProductEntity productEntity){
        ProductDataDto productDataDto = toProductDto(productEntity);
        return ProductResponseDto.builder()
                .code("200")
                .message("")
                .data(productDataDto).build();
    }
}
