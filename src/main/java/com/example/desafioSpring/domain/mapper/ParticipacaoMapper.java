package com.example.desafioSpring.domain.mapper;

import com.example.desafioSpring.domain.dto.participacao.request.ParticipacaoCommentRequest;
import com.example.desafioSpring.domain.dto.participacao.request.ParticipacaoRequest;
import com.example.desafioSpring.domain.dto.participacao.request.ParticipacaoStatusFlagUpdate;
import com.example.desafioSpring.domain.dto.participacao.response.ParticipacaoResponse;
import com.example.desafioSpring.domain.entities.Participacao;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ParticipacaoMapper
 */
@Component
public class ParticipacaoMapper {

    private final ModelMapper mapper;

    @Autowired
    public ParticipacaoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ParticipacaoResponse toDto(Participacao input) {
        return mapper.map(input, ParticipacaoResponse.class);
    }

    public Participacao fromDto(ParticipacaoRequest model) {
        return mapper.map(model, Participacao.class);

    }

    public Participacao fromDtoFlagUpdate(ParticipacaoStatusFlagUpdate model) {
        return mapper.map(model, Participacao.class);
    }

    public Participacao fromDtoCommentUpdate(ParticipacaoCommentRequest model) {
        return mapper.map(model, Participacao.class);
    }
}