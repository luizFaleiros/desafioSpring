package com.example.desafioSpring.domain.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import com.example.desafioSpring.configuration.MapperConfig;
import com.example.desafioSpring.domain.dto.evento.request.EventoRequest;
import com.example.desafioSpring.domain.dto.evento.request.StatusChange;
import com.example.desafioSpring.domain.dto.evento.response.EventoResponse;
import com.example.desafioSpring.domain.entities.CategoriaEvento;
import com.example.desafioSpring.domain.entities.Evento;
import com.example.desafioSpring.domain.entities.StatusEvento;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

/**
 * EventoMapperTest
 */

@RunWith(MockitoJUnitRunner.class)
public class EventoMapperTest {
    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private EventoMapper mapper;

    @Test
    public void shoul_Convert_Evento_To_EventoResponse() {
        CategoriaEvento categoriaEvento = CategoriaEvento.builder().idCategoriaEvento(1).nomeCategoria("Testes")
                .build();
        StatusEvento eventoStatus = StatusEvento.builder().idEventoStatus(1).NomeStatus("Teste").build();
        Evento evento = Evento.builder().categoriaEvento(categoriaEvento).eventoStatus(eventoStatus)
                .dataHoraFim(new Date()).dataHoraInicio(new Date()).descricao("Teste").idEvento(1).limiteVagas(10)
                .local("Em Casa").nome("Dart").build();
        EventoResponse dto = mapper.toDto(evento);
        assertEquals("Valor inesperado", dto.getCategoriaEvento(), evento.getCategoriaEvento());
        assertEquals("Valor inesperado", dto.getDataHoraFim(), evento.getDataHoraFim());
        assertEquals("Valor inesperado", dto.getDataHoraInicio(), evento.getDataHoraInicio());
        assertEquals("Valor inesperado", dto.getDescricao(), evento.getDescricao());
        assertEquals("Valor inesperado", dto.getEventoStatus(), evento.getEventoStatus());
        assertEquals("Valor inesperado", dto.getIdEvento(), evento.getIdEvento());
        assertEquals("Valor inesperado", dto.getLimiteVagas(), evento.getLimiteVagas());
        assertEquals("Valor inesperado", dto.getLocal(), evento.getLocal());
        assertEquals("Valor inesperado", dto.getNome(), evento.getNome());
    }

    @Test
    public void should_beConvert_EventoRequest_ToEvento() {

        EventoRequest dto = EventoRequest.builder().dataHoraFim(new Date()).dataHoraInicio(new Date())
                .descricao("Teste").limiteVagas(10).local("La em casa").idCategoriaEvento(1).nome("Teste").build();
        Evento evento = mapper.fromDto(dto);

        assertEquals("Valor inesperado", dto.getDataHoraFim(), evento.getDataHoraFim());
        assertEquals("Valor inesperado", dto.getDataHoraInicio(), evento.getDataHoraInicio());
        assertEquals("Valor inesperado", dto.getDescricao(), evento.getDescricao());
        assertEquals("Valor inesperado", dto.getLimiteVagas(), evento.getLimiteVagas());
        assertEquals("Valor inesperado", dto.getLocal(), evento.getLocal());
        assertEquals("Valor inesperado", dto.getNome(), evento.getNome());
    }

    @Test
    public void should_be_convert_StatusChanve_to_StatusEvento() {
        StatusChange statusChange = StatusChange.builder().idEventoStatus(1).build();

        Evento evento = mapper.fromDtoStatusChange(statusChange);

       assertNotNull("Valor inesperado", evento);
    }

}