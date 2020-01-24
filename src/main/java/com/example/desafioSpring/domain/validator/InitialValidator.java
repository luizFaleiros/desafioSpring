package com.example.desafioSpring.domain.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.evento.request.EventoUpdate;

/**
 * InitialValidator
 */
public class InitialValidator implements ConstraintValidator<GetInitial, EventoUpdate> {

    @Override
    public boolean isValid(EventoUpdate value, ConstraintValidatorContext context) {
        
        return false;
    }

    
}