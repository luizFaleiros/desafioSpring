package com.example.desafioSpring.domain.validator.evento;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * getStatusConcluido
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CancelValidator.class)
@Documented
public @interface GetStatusConcluido {
    String message() default "Data invalida.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}