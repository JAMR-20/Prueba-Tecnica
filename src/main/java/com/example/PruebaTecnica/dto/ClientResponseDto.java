package com.example.PruebaTecnica.dto;
import lombok.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientResponseDto {
    private String code;
    private String message;
    private ClientDataDto data;
}
