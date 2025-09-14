package dev.java10x.EventClean.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateEventExceptions(DuplicateEventException exc) {

        Map<String, String> response = new HashMap<>();
        response.put("error", exc.getMessage());
        response.put("message", "Por favor, insira um identificador válido e tente novamente.");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);

    }

}
