package com.example.desafioSpring.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.desafioSpring.domain.entities.Evento;
import com.example.desafioSpring.domain.entities.Participacao;
import com.example.desafioSpring.exception.DataCantBeCreate;
import com.example.desafioSpring.exception.DataNotFoundException;
import com.example.desafioSpring.repository.ParticipacaoRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * ParticipacaoServerTest
 */
@RunWith(MockitoJUnitRunner.class)
public class ParticipacaoServiceTest {
    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private ParticipacaoRepository repositoryMock;

    @InjectMocks
    ParticipacaoService service;

    private final Date dataHoraInicio = new Date();
    private final Integer idParticipacao = 1;
    private final Evento evento = Evento.builder().idEvento(1).nome("Dart").dataHoraInicio(dataHoraInicio).build();
    private final String loginParticipante = "String";
    private final Boolean flagPresente = true;
    private final Integer nota = null;
    private final String comentario = null;

    Participacao participacao = Participacao.builder().comentario(comentario).evento(evento).flagPresente(flagPresente)
            .idParticipacao(idParticipacao).loginParticipante(loginParticipante).nota(nota).build();

    @Test
    public void should_throwDataNotFoundException() {

        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Participacao nao Encontrada");
        service.findById(1);

    }

    @Test
    public void should_findById() {
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(participacao));

        Participacao model = service.findById(anyInt());

        verify(repositoryMock, times(1)).findById(anyInt());

        assertNotNull("Valor não esperado", model);
    }

    @Test
    public void should_ThrowDataCantBeCreateException() {
        expected.expect(DataCantBeCreate.class);
        expected.expectMessage("Usuario ja cadastrado");
        service.cadastrarParticipacao(participacao);
    }

    @Test
    public void should_beCreate() {
        when(repositoryMock.save(participacao)).thenReturn(participacao);
        when(repositoryMock.JaInscrito(anyInt(), anyString())).thenReturn(null);

        Participacao model = service.cadastrarParticipacao(participacao);

        verify(repositoryMock, times(1)).save(participacao);

        assertNotNull("Valor não esperado", model);
    }

    @Test
    public void should_ListOneItem() {
        List<Participacao> list = new ArrayList<Participacao>();
        list.add(participacao);
        when(repositoryMock.findAll()).thenReturn(list);

        List<Participacao> model = service.listParticipacao();

        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", model);
        assertEquals("Array deve conter um item", 1, model.size());
        assertEquals("Array deve ser do tipo Evento", participacao.getIdParticipacao(),
                model.get(0).getIdParticipacao());
    }

    @Test
    public void should_beDelete() {
        should_findById();

        service.deletarParticipacao(anyInt());
    }

    @Test
    public void should_ChangeFlag() {
        when(repositoryMock.save(participacao)).thenReturn(participacao);
        should_findById();
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.HOUR, -1);
        participacao.getEvento().setDataHoraInicio(ca.getTime());
        Participacao model = service.ChangeFlag(anyInt(), participacao);
        assertNotNull("Valor inesperado", model);
        assertEquals("Valores não iguais", model.getIdParticipacao(), participacao.getIdParticipacao());
    }

    @Test
    public void should_DataNotFoundExceptionChangeFlag() {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.HOUR, 1);
        participacao.getEvento().setDataHoraInicio(ca.getTime());
        should_findById();
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Ainda não começou evento 😘");
        service.ChangeFlag(anyInt(), participacao);
    }

    @Test
    public void should_comentario() {
        when(repositoryMock.save(participacao)).thenReturn(participacao);
        should_findById();
        Participacao model = service.comentario(anyInt(), participacao);
        assertNotNull("Valor inesperado", model);
        assertEquals("Valores não iguais", model.getIdParticipacao(), participacao.getIdParticipacao());
    }

    @Test
    public void should_DataNotFoundExceptionComentario() {
        participacao.setFlagPresente(false);
        should_findById();
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Pessoa não participou");
        service.comentario(anyInt(), participacao);
    }

    @Test
    public void should_qntParticipantes() {
        when(repositoryMock.qntInscritos(anyInt())).thenReturn(1);
        Integer qnt = service.qntParticipantes(anyInt());
        assertNotNull("Valor não esperado", qnt);
    }

}