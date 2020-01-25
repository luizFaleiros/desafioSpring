package com.example.desafioSpring.domain.validator.participacao;

import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.participacao.request.ParticipacaoStatusFlagUpdate;
import com.example.desafioSpring.domain.entities.Evento;
import com.example.desafioSpring.services.EventoService;

/**
 * FlagValidator
 */
public class FlagValidator implements ConstraintValidator<GetFlag, ParticipacaoStatusFlagUpdate> {
    EventoService eventoService;

    @Override
    public boolean isValid(ParticipacaoStatusFlagUpdate value, ConstraintValidatorContext context) {
        Evento evento = eventoService.findById(value.getIdEvento());
        Calendar c = Calendar.getInstance();
        if (evento.getDataHoraInicio().getTime() > c.getTimeInMillis()) {
            return true;
        }
        return false;
    }

}