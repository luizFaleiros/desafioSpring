package com.example.desafioSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * DataCantBeCreate
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DataCantBeCreate extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 3467464333361340173L;

    /**
     *
     */

    public DataCantBeCreate(String message) {
        super(message);
    }
    public DataCantBeCreate(String message,  Throwable e) {
        super(message, e);
    }
}