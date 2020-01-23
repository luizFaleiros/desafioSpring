package com.example.desafioSpring.domain.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.request.ParticipacaoRequest;

/**
 * VagaValidator
 */
public class VagaValidator implements ConstraintValidator<GetVaga, ParticipacaoRequest> {

    @Override
    public boolean isValid(ParticipacaoRequest value, ConstraintValidatorContext context) {

        return false;
    }

    
}