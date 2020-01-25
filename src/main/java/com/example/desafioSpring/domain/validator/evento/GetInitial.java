package com.example.desafioSpring.domain.validator.evento;

import javax.validation.Payload;

/**
 * GetInitial
 */
public @interface GetInitial {
    String message() default "Data invalida.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}