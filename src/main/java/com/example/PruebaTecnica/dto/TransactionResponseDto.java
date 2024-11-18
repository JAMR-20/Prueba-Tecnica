package com.example.PruebaTecnica.dto;
import lombok.*;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDto {
    private String code;
    private String message;
    private TransactionDataDto data;
}
