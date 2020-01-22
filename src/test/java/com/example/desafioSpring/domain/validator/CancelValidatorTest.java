package com.example.desafioSpring.domain.validator;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.request.EventoUpdate;

import org.aspectj.lang.annotation.Before;
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
    EventoUpdate testeEventoUpdate;

    @Test
    public void should_beValid() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 3);
        c.set(Calendar.HOUR, 10);
        Date ini = c.getTime();
        c.set(Calendar.HOUR, 11);
        Date fim = c.getTime();
        testeEventoUpdate.builder().idEventoStatus(4).DataHoraInicio(ini.getTime()).build();
        assertTrue(cancelValidator.isValid(testeEventoUpdate, constraintValidatorContext));
    }
}