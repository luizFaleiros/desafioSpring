package com.example.desafioSpring.domain.validator.evento;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.evento.request.EventoUpdate;
import com.example.desafioSpring.domain.validator.evento.CancelValidator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * CancelValidatorTest
 */
@RunWith(MockitoJUnitRunner.class)
public class CancelValidatorTest {
    @Mock
    ConstraintValidatorContext constraintValidatorContext;

    @InjectMocks
    CancelValidator cancelValidator;

    @Test
    public void should_beNotValid_whenDateIsNotTodayAndTodayIsSamllerThenFim() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 3);
        c.set(Calendar.HOUR, 10);
        Date ini = c.getTime();
        c.set(Calendar.HOUR, 11);
        Date fim = c.getTime();
        EventoUpdate testeEventoUpdate = EventoUpdate.builder().idEventoStatus(4).dataHoraFim(fim).dataHoraInicio(ini)
                .build();
        assertFalse(cancelValidator.isValid(testeEventoUpdate, constraintValidatorContext));
    }

    @Test
    public void should_beValid_whenDateIsNotTodayAndTodayIsBiggerThenFim() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -3);
        c.set(Calendar.HOUR, 10);
        Date ini = c.getTime();
        c.set(Calendar.HOUR, 11);
        Date fim = c.getTime();
        EventoUpdate testeEventoUpdate = EventoUpdate.builder().idEventoStatus(4).dataHoraFim(fim).dataHoraInicio(ini)
                .build();
        assertTrue(cancelValidator.isValid(testeEventoUpdate, constraintValidatorContext));
    }

    @Test
    public void should_beNotValid_whenDateIsToday() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR, 10);
        Date ini = c.getTime();
        c.set(Calendar.HOUR, 11);
        Date fim = c.getTime();
        EventoUpdate testeEventoUpdate = EventoUpdate.builder().idEventoStatus(4).dataHoraFim(fim).dataHoraInicio(ini)
                .build();
        assertFalse(cancelValidator.isValid(testeEventoUpdate, constraintValidatorContext));
    }

    @Test
    public void should_beNotValid_whenIsNull() {
        assertFalse(cancelValidator.isValid(null, constraintValidatorContext));
    }

    @Test
    public void should_beNotValid_whenDateIsNull() {
        EventoUpdate testeEventoUpdate = EventoUpdate.builder().idEventoStatus(4).dataHoraFim(null).dataHoraInicio(null)
                .build();
        assertFalse(cancelValidator.isValid(testeEventoUpdate, constraintValidatorContext));
    }

    @Test
    public void should_beNotValid_whenStatusIsNull() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 3);
        c.set(Calendar.HOUR, 10);
        c.set(Calendar.HOUR, 11);
        Date fim = c.getTime();
        EventoUpdate testeEventoUpdate = EventoUpdate.builder().idEventoStatus(null).dataHoraFim(new Date())
                .dataHoraInicio(fim).build();
        assertFalse(cancelValidator.isValid(testeEventoUpdate, constraintValidatorContext));
    }

    @Test
    public void should_beValid_whenStatusIsNotFor() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -3);
        c.set(Calendar.HOUR, 10);
        Date ini = c.getTime();
        c.set(Calendar.HOUR, 11);
        Date fim = c.getTime();
        EventoUpdate testeEventoUpdate = EventoUpdate.builder().idEventoStatus(3).dataHoraFim(fim).dataHoraInicio(ini)
                .build();
        assertTrue(cancelValidator.isValid(testeEventoUpdate, constraintValidatorContext));
    }

}