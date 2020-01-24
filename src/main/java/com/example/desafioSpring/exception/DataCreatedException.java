package com.example.desafioSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * DataCreatedException
 */
@ResponseStatus(code = HttpStatus.CREATED)
public class DataCreatedException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -258872239885317281L;

    public DataCreatedException(String message) {
        super(message);
    }
    public DataCreatedException(String message,  Throwable e) {
        super(message, e);
    }
}