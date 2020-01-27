package com.example.desafioSpring.domain.validator.evento;

import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.evento.request.EventoUpdate;

/**
 * StatusConcluidoValidator
 */
public class StatusConcluidoValidator implements ConstraintValidator<GetStatusConcluido, EventoUpdate> {

    @Override
    public boolean isValid(EventoUpdate value, ConstraintValidatorContext context) {
        if(value == null){
            return false;
        }
        if(value.getIdEventoStatus() == null){
            return false;
        }
        Calendar c = Calendar.getInstance();
        if (value.getIdEventoStatus() == 3) {
            if (c.getTimeInMillis() < value.getDataHoraInicio().getTime()) {
                return true;
            }
            return false;
        }
        return true;
    }

}