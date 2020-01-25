// package com.example.desafioSpring.domain.validator.participacao;

// import static org.junit.Assert.assertTrue;

// import java.util.Calendar;

// import javax.validation.ConstraintValidatorContext;

// import com.example.desafioSpring.domain.entities.Evento;
// import com.example.desafioSpring.domain.entities.Participacao;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.MockitoJUnitRunner;

// /**
//  * FlagValidatortest
//  */
// @RunWith(MockitoJUnitRunner.class)
// public class FlagValidatortest {
//     @Mock
//     ConstraintValidatorContext constraintValidatorContext;
//     @Mock
//     Evento evento = Evento.builder().idEvento(1).build();

//     @InjectMocks
//     FlagValidator flagValidator;

//     @Test
//     public void should_beValid_whenDataInicialBiggerToday() {
//         Calendar c = Calendar.getInstance();
//         c.add(Calendar.HOUR, 1);
//         Participacao participacao = Participacao.builder().evento(evento).flagPresente(true).
//         build();
//         assertTrue(flagValidator.isValid(evento, constraintValidatorContext));
//     }

//  }