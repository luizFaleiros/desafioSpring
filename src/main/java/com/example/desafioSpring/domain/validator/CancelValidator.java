package com.example.desafioSpring.domain.validator;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.request.EventoUpdate;

/**
 * Datealidator
 */
public class CancelValidator implements ConstraintValidator<GetDateValidator, EventoUpdate> {

    @Override
    public boolean isValid(EventoUpdate value, ConstraintValidatorContext context) {
        Calendar daata = Calendar.getInstance();
        daata.setTime(new Date());
        Calendar inicio = Calendar.getInstance();
        inicio.setTime(value.getDataHoraInicio());
        if ((value.getIdEventoStatus() == 4) && (inicio.get(Calendar.DATE) <= daata.get(Calendar.DATE))) {
            return false;
        }
        return true;
    }
}