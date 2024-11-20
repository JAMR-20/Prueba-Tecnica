package com.example.PruebaTecnica.dto;
import lombok.*;

@Builder
@Data

public class ProductResponseDto {
    private String code;
    private String message;
    private ProductDataDto data;
}
