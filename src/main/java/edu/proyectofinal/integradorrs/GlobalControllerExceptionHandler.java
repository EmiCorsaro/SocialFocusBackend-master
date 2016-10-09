package edu.proyectofinal.integradorrs;

import edu.proyectofinal.integradorrs.exceptions.EmptyResultException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by mariano on 25/03/16.
 */
@ControllerAdvice
class GlobalControllerExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not Found")
    @ExceptionHandler(EmptyResultException.class)
    public void emptyResult() {

    }
}
