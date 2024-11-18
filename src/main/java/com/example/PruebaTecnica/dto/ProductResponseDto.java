package com.example.PruebaTecnica.dto;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    private String code;
    private String message;
    private ProductDataDto data;
}
