package com.example.desafioSpring.domain.validator;

import static org.junit.Assert.assertFalse;

import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.entities.Evento;

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

    @Test
    public void should_not_beValid(){
        assertFalse(dateValidator.isValid(null, constraintValidatorContext));
    }
}