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
        if(inicio == null || fim == null){
            return false;
        }
        if(inicio.getTime().getTime() >= fim.getTime().getTime()){
            return false;
        }
        return true;
	}
    


}