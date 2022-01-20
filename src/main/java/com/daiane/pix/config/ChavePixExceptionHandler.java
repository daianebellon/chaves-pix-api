package com.daiane.pix.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class ChavePixExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity<String> tratarErrosDeValidacao(Exception exception) {
        exception.printStackTrace();
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> tratarErrosConstraints(ConstraintViolationException exception) {
        exception.printStackTrace();

        String mensagemErro = exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessageTemplate)
                .collect(Collectors.joining("\n"));

        return ResponseEntity.badRequest().body(mensagemErro);
    }
}

