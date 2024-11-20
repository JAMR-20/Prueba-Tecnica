package com.example.PruebaTecnica.dto;
import lombok.*;
@Builder
@Data
public class ClientResponseDto {
    private String code;
    private String message;
    private ClientResponseDataDto data;
}
