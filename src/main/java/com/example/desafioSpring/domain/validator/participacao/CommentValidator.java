package com.example.desafioSpring.domain.validator.participacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.desafioSpring.domain.dto.participacao.request.ParticipacaoCommentRequest;

/**
 * CommentValidator
 */
public class CommentValidator implements ConstraintValidator<GetComment, ParticipacaoCommentRequest> {

    @Override
    public boolean isValid(ParticipacaoCommentRequest value, ConstraintValidatorContext context) {
        if(value == null){
            return false;
        }
        if (value.getFlagPresente()) {
            return true;
        }
        return false;
    }

    
}