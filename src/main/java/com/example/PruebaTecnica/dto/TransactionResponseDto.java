package com.example.PruebaTecnica.dto;
import lombok.*;
@Builder
@Data

public class TransactionResponseDto {
    private String code;
    private String message;
    private TransactionDataDto data;
}
