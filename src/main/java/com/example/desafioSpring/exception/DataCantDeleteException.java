package com.example.desafioSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * DataCantDeleteException
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DataCantDeleteException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = -7996239318820068880L;

    public DataCantDeleteException(String message) {
        super(message);
    }

    public DataCantDeleteException(String message, Throwable e) {
        super(message, e);
    }

    
}