package com.example.desafioSpring.domain.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.evento.request.EventoRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * DateValidatorTest
 */
@RunWith(MockitoJUnitRunner.class)
public class DateValidatorTest {

    @Mock
    ConstraintValidatorContext constraintValidatorContext;

    @InjectMocks
    DateValidator dateValidator;

    private Date DataHoraInicio = new Date();

    private Date DataHoraFim = new Date();

    EventoRequest eventoRequest = EventoRequest.builder().DataHoraFim(DataHoraFim).DataHoraInicio(DataHoraInicio)
            .build();

    @Test
    public void should_not_beValid_whenDaysAreTheSame() {

        assertFalse(dateValidator.isValid(eventoRequest, constraintValidatorContext));
    }

    @Test
    public void should_not_beValid_whenDayIniAreNull() {
        EventoRequest testeEventoRequest = EventoRequest.builder().DataHoraFim(new Date()).DataHoraInicio(null).build();

        assertFalse(dateValidator.isValid(testeEventoRequest, constraintValidatorContext));
    }

    @Test
    public void should_not_beValid_whenDayFimAreNull() {
        EventoRequest testeEventoRequest = EventoRequest.builder().DataHoraFim(null).DataHoraInicio(new Date()).build();

        assertFalse(dateValidator.isValid(testeEventoRequest, constraintValidatorContext));
    }

    @Test
    public void should_not_beValid_whenBothDaysAreNull() {
        EventoRequest testeEventoRequest = EventoRequest.builder().DataHoraFim(null).DataHoraInicio(null).build();

        assertFalse(dateValidator.isValid(testeEventoRequest, constraintValidatorContext));
    }

    @Test
    public void Should_beNot_Valid_whenDayiniIsSmallerToDay() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -2);
        c.set(Calendar.HOUR, 10);
        Date ini = c.getTime();
        c.set(Calendar.HOUR, 11);
        Date fim = c.getTime();
        EventoRequest testeEventoRequest = EventoRequest.builder().DataHoraFim(fim).DataHoraInicio(ini).build();
        assertFalse(dateValidator.isValid(testeEventoRequest, constraintValidatorContext));
    }

    @Test
    public void Should_beNot_Valid_whenDayiniIsFinalDayIsDiferentOfInitDay() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 2);
        c.set(Calendar.HOUR, 10);
        Date ini = c.getTime();
        c.add(Calendar.DATE, 3);
        c.set(Calendar.HOUR, 11);
        Date fim = c.getTime();
        EventoRequest testeEventoRequest = EventoRequest.builder().DataHoraFim(fim).DataHoraInicio(ini).build();
        assertFalse(dateValidator.isValid(testeEventoRequest, constraintValidatorContext));
    }

    @Test
    public void should_beValid() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 2);
        c.set(Calendar.HOUR, 10);
        Date ini = c.getTime();
        c.set(Calendar.HOUR, 11);
        Date fim = c.getTime();
        EventoRequest testeEventoRequest = EventoRequest.builder().DataHoraFim(fim).DataHoraInicio(ini).build();
        assertTrue(dateValidator.isValid(testeEventoRequest, constraintValidatorContext));
    }

}