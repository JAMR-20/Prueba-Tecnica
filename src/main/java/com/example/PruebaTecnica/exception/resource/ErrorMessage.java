package com.example.PruebaTecnica.exception.resource;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ErrorMessage {
    public HttpStatus status;
    public String message;
    public Map<String, String> errors;
}
