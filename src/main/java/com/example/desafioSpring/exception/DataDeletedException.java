package com.example.desafioSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * DataCreatedException
 */
@ResponseStatus(code = HttpStatus.OK)
public class DataDeletedException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -1353582647270573676L;
    
    public DataDeletedException(String message) {
        super(message);
    }
    public DataDeletedException(String message,  Throwable e) {
        super(message, e);
    }
}