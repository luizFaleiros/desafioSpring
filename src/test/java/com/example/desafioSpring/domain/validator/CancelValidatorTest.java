package com.example.desafioSpring.domain.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.request.EventoUpdate;

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
    public void should_beValid_whenDateIsNotToday() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 3);
        c.set(Calendar.HOUR, 10);
        Date ini = c.getTime();
        c.set(Calendar.HOUR, 11);
        Date fim = c.getTime();
        EventoUpdate testeEventoUpdate = EventoUpdate.builder().idEventoStatus(4).DataHoraFim(fim).DataHoraInicio(ini)
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
        EventoUpdate testeEventoUpdate = EventoUpdate.builder().idEventoStatus(4).DataHoraFim(fim).DataHoraInicio(ini)
                .build();
        assertFalse(cancelValidator.isValid(testeEventoUpdate, constraintValidatorContext));
    }
    @Test
    public void should_beNotValid_whenIsNull() {
        assertFalse(cancelValidator.isValid(null, constraintValidatorContext));
    }
    @Test
    public void should_beNotValid_whenDateIsNull() {
        EventoUpdate testeEventoUpdate = EventoUpdate.builder().idEventoStatus(4).DataHoraFim(null).DataHoraInicio(null)
                .build();
        assertFalse(cancelValidator.isValid(testeEventoUpdate, constraintValidatorContext));
    }
    @Test
    public void should_beNotValid_whenStatusIsNull() {
        EventoUpdate testeEventoUpdate = EventoUpdate.builder().idEventoStatus(null).DataHoraFim(null).DataHoraInicio(null)
                .build();
        assertFalse(cancelValidator.isValid(testeEventoUpdate, constraintValidatorContext));
    }
}