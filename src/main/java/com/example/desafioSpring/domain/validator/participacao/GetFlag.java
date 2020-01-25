package com.example.desafioSpring.domain.validator.participacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.desafioSpring.domain.validator.evento.CancelValidator;

/**
 * GetFlag
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CancelValidator.class)
@Documented
public @interface GetFlag {
    
    String message() default "Flag Nao pode ser trocada.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}