package com.example.desafioSpring.domain.validator;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.request.EventoRequest;

/**
 * Datealidator
 */
public class DateValidator implements ConstraintValidator<GetDateValidator, EventoRequest> {

    @Override
    public boolean isValid(EventoRequest value, ConstraintValidatorContext context) {
        Calendar inicio = Calendar.getInstance();
        Calendar fim = Calendar.getInstance();
        inicio.setTime(value.getDataHoraInicio());
        fim.setTime(value.getDataHoraFim());
        if (inicio == null || fim == null) {
            return false;
        }
        if (inicio.getTimeInMillis() >= fim.getTimeInMillis()) {
            return false;
        }
        if (!validaData(inicio, fim)) {
            return false;
        }
        return true;
    }

    private Boolean validaData(Calendar ini, Calendar fim) {
        Calendar c = Calendar.getInstance();
        if (!(c.get(Calendar.DATE) >= ini.get(Calendar.DATE))) {
            return false;
        }
        if ((ini.get(Calendar.DATE) != fim.get(Calendar.DATE)) || (ini.get(Calendar.MONTH) != fim.get(Calendar.MONTH))  || (ini.get(Calendar.YEAR) != fim.get(Calendar.YEAR)) ) {
            return false;
        }
        return true;
    }
}