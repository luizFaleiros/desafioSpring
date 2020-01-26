package com.example.desafioSpring.domain.validator.evento;

import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.evento.request.EventoBase;

/**
 * Datealidator
 */
public class DateValidator implements ConstraintValidator<GetDateValidator, EventoBase> {

    @Override
    public boolean isValid(EventoBase value, ConstraintValidatorContext context) {
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
        Long dia = (24*60*60*1000)-1L;
        ini.set(Calendar.HOUR, 0);
        ini.set(Calendar.MINUTE, 0);
        ini.set(Calendar.SECOND, 0);
        ini.set(Calendar.MILLISECOND, 0);
        Long date = ini.getTime().getTime() + dia;
        if (fim.getTimeInMillis() >= date){
            return false;
        }
        return true;
    }
}