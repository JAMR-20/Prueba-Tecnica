package com.example.PruebaTecnica.exception;
import com.example.PruebaTecnica.exception.resource.ErrorMessage;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleClientNotFoundException(ClientNotFoundException exception){
        logger.error("Cliente no encontrado: {}", exception.getMessage(), exception);

        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND).build();

     return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleConstraintViolationException  (ConstraintViolationException exception){
        logger.error("Constraint violation: {}", exception.getConstraintViolations(), exception);
        Map<String, String> errors = new HashMap<>();

        exception.getConstraintViolations().forEach(violation -> {
            String propertyName = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.put(propertyName, message);
        });
        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(HttpStatus.BAD_REQUEST)
                .errors(errors)
                .build();
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException (Exception ex){
        logger.error("Unexpected error: {}", ex.getMessage(), ex);

        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message("An unexpected error ocurred")
                .build();

        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR)
    }


}
