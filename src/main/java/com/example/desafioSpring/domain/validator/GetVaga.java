package com.example.desafioSpring.domain.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * GetVaga
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VagaValidator.class)
@Documented
public @interface GetVaga {

    String message() default "Data invalida.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}