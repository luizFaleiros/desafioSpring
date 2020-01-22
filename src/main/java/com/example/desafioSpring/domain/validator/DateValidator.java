package com.example.desafioSpring.domain.validator;

import java.util.Calendar;

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
        if (value.getDataHoraFim() == null || value.getDataHoraInicio() == null) {
            return false;
        }
        inicio.setTime(value.getDataHoraInicio());
        fim.setTime(value.getDataHoraFim());
        if (inicio.getTime().getTime() >= fim.getTime().getTime()) {
            return false;
        }
        Boolean testaData = validaData(inicio, fim);
        if (testaData) {
            return true;
        }
        return false;
    }
    
    private Boolean validaData(Calendar ini, Calendar fim) {
        Calendar c = Calendar.getInstance();
        if ((c.get(Calendar.DATE) >= ini.get(Calendar.DATE))) {
            return false;
        }
        if ((ini.get(Calendar.DATE) != fim.get(Calendar.DATE)) || (ini.get(Calendar.MONTH) != fim.get(Calendar.MONTH))  || (ini.get(Calendar.YEAR) != fim.get(Calendar.YEAR)) ) {
            return false;
        }
        return true;
    }
}