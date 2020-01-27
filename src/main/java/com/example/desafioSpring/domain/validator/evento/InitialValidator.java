package com.example.desafioSpring.domain.validator.evento;

import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.evento.request.EventoUpdate;

/**
 * InitialValidator
 */
public class InitialValidator implements ConstraintValidator<GetInitial, EventoUpdate> {

    @Override
    public boolean isValid(EventoUpdate value, ConstraintValidatorContext context) {
        Calendar c = Calendar.getInstance();
        if (value.getIdEventoStatus() == 2) {
            if ((value.getDataHoraInicio().getTime() > c.getTimeInMillis())) {
                return false;
            }
            if ((c.getTimeInMillis() > value.getDataHoraFim().getTime())) {
                return false;
            }
            return true;
        }
        return true;
    }

}