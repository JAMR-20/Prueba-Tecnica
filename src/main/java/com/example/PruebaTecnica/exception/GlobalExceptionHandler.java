package com.example.PruebaTecnica.exception;
import com.example.PruebaTecnica.exception.resource.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



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


}
