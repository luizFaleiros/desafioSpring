package com.example.desafioSpring.domain.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.example.desafioSpring.configuration.MapperConfig;
import com.example.desafioSpring.domain.dto.participacao.request.ParticipacaoCommentRequest;
import com.example.desafioSpring.domain.dto.participacao.request.ParticipacaoRequest;
import com.example.desafioSpring.domain.dto.participacao.request.ParticipacaoStatusFlagUpdate;
import com.example.desafioSpring.domain.dto.participacao.response.ParticipacaoResponse;
import com.example.desafioSpring.domain.entities.CategoriaEvento;
import com.example.desafioSpring.domain.entities.Evento;
import com.example.desafioSpring.domain.entities.Participacao;
import com.example.desafioSpring.domain.entities.StatusEvento;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

/**
 * ParticipacaoEventoMapperTest
 */
@RunWith(MockitoJUnitRunner.class)
public class ParticipacaoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();
    @InjectMocks
    ParticipacaoMapper mapper;

    @Test
    public void should_convert_Participacao_to_participacaoResponse() {
        CategoriaEvento categoriaEvento = CategoriaEvento.builder().idCategoriaEvento(1).nomeCategoria("Testes")
                .build();
        StatusEvento eventoStatus = StatusEvento.builder().idEventoStatus(1).NomeStatus("Teste").build();
        Evento evento = Evento.builder().categoriaEvento(categoriaEvento).eventoStatus(eventoStatus)
                .dataHoraFim(new Date()).dataHoraInicio(new Date()).descricao("Teste").idEvento(1).limiteVagas(10)
                .local("Em Casa").nome("Dart").build();
        Participacao participacao = Participacao.builder().comentario("Teste").evento(evento).flagPresente(true)
                .idParticipacao(1).loginParticipante("String").nota(10).build();
        ParticipacaoResponse participacaoResponse = mapper.toDto(participacao);

        assertEquals("Valor não esperado", participacaoResponse.getComentario(), participacao.getComentario());
        assertEquals("Valor não esperado", participacaoResponse.getEvento(), participacao.getEvento());
        assertEquals("Valor não esperado", participacaoResponse.getFlagPresente(), participacao.getFlagPresente());
        assertEquals("Valor não esperado", participacaoResponse.getIdParticipacao(), participacao.getIdParticipacao());
        assertEquals("Valor não esperado", participacaoResponse.getLoginParticipante(),
                participacao.getLoginParticipante());
        assertEquals("Valor não esperado", participacaoResponse.getNota(), participacao.getNota());
    }

    @Test
    public void should_convert_participacaoRequest_to_Participacao() {
        ParticipacaoRequest participacaoRequest = ParticipacaoRequest.builder().idEvento(1).loginParticipante("String")
                .build();
        Participacao participacao = mapper.fromDto(participacaoRequest);

        assertEquals("Valor não esperado", participacao.getLoginParticipante(),participacaoRequest.getLoginParticipante());
    }

    @Test
    public void should_convert_participacaoStatusFlagUpdate_to_Participacao() {
        ParticipacaoStatusFlagUpdate participacaoRequest = ParticipacaoStatusFlagUpdate.builder().flagPresente(true).build();
        Participacao participacao = mapper.fromDtoFlagUpdate(participacaoRequest);

        assertEquals("Valor não esperado", participacao.getFlagPresente(),participacaoRequest.getFlagPresente());
    }

    @Test
    public void should_convert_ParticipacaoCommentRequest_to_Participacao() {
        ParticipacaoCommentRequest  participacaoRequest = ParticipacaoCommentRequest.builder().comentario("Show").nota(1).build();
        Participacao participacao = mapper.fromDtoCommentUpdate(participacaoRequest);

        assertEquals("Valor não esperado", participacao.getComentario(),participacaoRequest.getComentario());
        assertEquals("Valor não esperado", participacao.getNota(),participacaoRequest.getNota());
    }
}