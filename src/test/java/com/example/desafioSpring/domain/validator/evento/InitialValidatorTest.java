package com.example.desafioSpring.domain.validator.evento;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.evento.request.EventoUpdate;
import com.example.desafioSpring.domain.validator.evento.InitialValidator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * CancelValidatorTest
 */
@RunWith(MockitoJUnitRunner.class)
public class InitialValidatorTest {
    @Mock
    ConstraintValidatorContext constraintValidatorContext;

    @InjectMocks
    InitialValidator initialValidator;

    @Test
    public void should_beNotValid_whenFimIsBiggerThanToday() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 3);
        c.set(Calendar.HOUR, 10);
        Date ini = c.getTime();
        c.set(Calendar.HOUR, 11);
        Date fim = c.getTime();
        EventoUpdate testeEventoUpdate = EventoUpdate.builder().idEventoStatus(2).DataHoraFim(fim).DataHoraInicio(ini)
                .build();
        assertFalse(initialValidator.isValid(testeEventoUpdate, constraintValidatorContext));
    }
    @Test
    public void should_beValid_whenEventoInitiToday() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR, -1);
        Date ini = c.getTime();
        c.add(Calendar.HOUR, 11);
        Date fim = c.getTime();
        EventoUpdate testeEventoUpdate = EventoUpdate.builder().idEventoStatus(2).DataHoraFim(fim).DataHoraInicio(ini)
                .build();
        assertTrue(initialValidator.isValid(testeEventoUpdate, constraintValidatorContext));
    }
    @Test
    public void should_beNotvalid_whenEventoFimIsSmallerToday() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR, -1);
        Date ini = c.getTime();
        c.add(Calendar.HOUR, -1);
        Date fim = c.getTime();
        EventoUpdate testeEventoUpdate = EventoUpdate.builder().idEventoStatus(2).DataHoraFim(fim).DataHoraInicio(ini)
                .build();
        assertFalse(initialValidator.isValid(testeEventoUpdate, constraintValidatorContext));
    }
}