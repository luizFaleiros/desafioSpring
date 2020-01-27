package com.example.desafioSpring.domain.validator.evento;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.evento.request.EventoUpdate;

/**
 * Datealidator
 */
public class CancelValidator implements ConstraintValidator<GetDateValidator, EventoUpdate> {

    @Override
    public boolean isValid(EventoUpdate value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        if (value.getDataHoraInicio() == null) {
            return false;
        }
        if (value.getIdEventoStatus() == null) {
            return false;
        }
        Calendar daata = Calendar.getInstance();
        daata.setTime(new Date());
        daata.set(Calendar.HOUR, 0);
        daata.set(Calendar.MINUTE, 0);
        daata.set(Calendar.SECOND, 0);
        daata.set(Calendar.MILLISECOND, 1);

        Calendar inicio = Calendar.getInstance();
        inicio.setTime(value.getDataHoraInicio());
        Calendar fim = Calendar.getInstance();
        fim.setTime(value.getDataHoraInicio());
        if (value.getIdEventoStatus() == 4) {
            if (inicio.getTimeInMillis() >= daata.getTimeInMillis()) {

                return false;

            }
        }
        return true;
    }
}