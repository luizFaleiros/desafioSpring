package com.example.desafioSpring.domain.validator.evento;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.evento.request.EventoUpdate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * StatusConcluidoValidatorTest
 */
@RunWith(MockitoJUnitRunner.class)
public class StatusConcluidoValidatorTest {
    @Mock
    ConstraintValidatorContext constraintValidatorContext;

    @InjectMocks
    StatusConcluidoValidator statusConcluidoValidator;

    @Test
    public void should_beValid_WhenStatusNotTrhree() {
        EventoUpdate eventoUpdate = EventoUpdate.builder().idEventoStatus(4).build();
        assertTrue(statusConcluidoValidator.isValid(eventoUpdate, constraintValidatorContext));
    }

    @Test
    public void should_beInvalid_whenEventoUpdateisNull() {
        assertFalse(statusConcluidoValidator.isValid(null, constraintValidatorContext));
    }

    @Test
    public void should_beInValid_WhenStatusIsNull() {
        EventoUpdate eventoUpdate = EventoUpdate.builder().idEventoStatus(null).build();
        assertFalse(statusConcluidoValidator.isValid(eventoUpdate, constraintValidatorContext));
    }

    @Test
    public void should_beInvalid_whenStatusIsThreeAndtodayIsBiggerThanInicio() {
        Calendar ini = Calendar.getInstance();
        ini.set(Calendar.HOUR, -1);

        EventoUpdate eventoUpdate = EventoUpdate.builder().idEventoStatus(3).dataHoraInicio(ini.getTime()).build();

        assertFalse(statusConcluidoValidator.isValid(eventoUpdate, constraintValidatorContext));
    }

    @Test
    public void should_beValid_whenStatusIsThreeAndtodayIsSmallerThanInicio() {
        Calendar ini = Calendar.getInstance();
        ini.add(Calendar.HOUR, 1);

        EventoUpdate eventoUpdate = EventoUpdate.builder().idEventoStatus(3).dataHoraInicio(ini.getTime()).build();

        assertTrue(statusConcluidoValidator.isValid(eventoUpdate, constraintValidatorContext));
    }

}