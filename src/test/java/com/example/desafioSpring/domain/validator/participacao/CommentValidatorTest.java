package com.example.desafioSpring.domain.validator.participacao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.participacao.request.ParticipacaoCommentRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * CommentValidator
 */

@RunWith(MockitoJUnitRunner.class)
public class CommentValidatorTest {
    @Mock
    ConstraintValidatorContext constraintValidatorContext;

    @InjectMocks
    CommentValidator commentValidator;

    @Test
    public void should_beNotValid_when_ValueIsNull() {

        ParticipacaoCommentRequest participacaoCommentRequest = null;

        assertFalse(commentValidator.isValid(participacaoCommentRequest, constraintValidatorContext));
    }

    @Test
    public void should_beValid_when_FlagPresenteIsTrue() {

        ParticipacaoCommentRequest participacaoCommentRequest = ParticipacaoCommentRequest.builder().comentario("Teste")
                .flagPresente(true).nota(5).build();

        assertTrue(commentValidator.isValid(participacaoCommentRequest, constraintValidatorContext));
    }

    @Test
    public void should_beNotValid_whenFlagPresenteIsFalse() {

        ParticipacaoCommentRequest participacaoCommentRequest = ParticipacaoCommentRequest.builder().comentario("Teste")
                .flagPresente(false).nota(5).build();

        assertFalse(commentValidator.isValid(participacaoCommentRequest, constraintValidatorContext));

    }

}