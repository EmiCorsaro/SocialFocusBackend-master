package edu.proyectofinal.integradorrs.exceptions;

/**
 * Created by mariano on 25/03/16.
 */
abstract class AbstractApiRestException extends RuntimeException{

    protected AbstractApiRestException(String message){
        super(message);
    }

}
