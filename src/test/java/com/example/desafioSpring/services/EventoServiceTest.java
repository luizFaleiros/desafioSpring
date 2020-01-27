package com.example.desafioSpring.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.desafioSpring.domain.entities.CategoriaEvento;
import com.example.desafioSpring.domain.entities.Evento;
import com.example.desafioSpring.domain.entities.StatusEvento;
import com.example.desafioSpring.exception.DataNotFoundException;
import com.example.desafioSpring.repository.EventoRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * EventoServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class EventoServiceTest {
    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private EventoRepository repositoryMock;

    @InjectMocks
    private EventoService eventoService;

    private final Integer id = 1;
    private final String nome = "Alguma String";
    private final CategoriaEvento categoriaEvento = CategoriaEvento.builder().idCategoriaEvento(1)
            .nomeCategoria("Logica").build();
    private final StatusEvento eventoStatus = StatusEvento.builder().NomeStatus("Indo").idEventoStatus(1).build();
    private final String local = "Em casa";
    private final String descricao = "Aprendendo String em todos os frameworks javaScript";
    private final Integer limiteVagas = 1;
    private final Date dataHoraInicio = new Date();
    private final Date dataHoraFim = new Date();

    Evento entity = Evento.builder().categoriaEvento(categoriaEvento).dataHoraFim(dataHoraFim)
            .dataHoraInicio(dataHoraInicio).descricao(descricao).eventoStatus(eventoStatus).idEvento(id)
            .limiteVagas(limiteVagas).nome(nome).local(local).build();

    @Test
    public void should_ThrowDataNotFoundException_whenNotFounds() {
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Evento não Encontrado");

        eventoService.findById(1);
    }

    @Test
    public void should_findById() {
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        Evento model = eventoService.findById(anyInt());

        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Evento deve ser encontrado", model);
    }

    @Test
    public void Should_beCreate() {
        when(repositoryMock.save(entity)).thenReturn(entity);

        Evento model = eventoService.cadastroEvento(entity);

        verify(repositoryMock, times(1)).save(entity);
        assertNotNull(model);
    }

    @Test
    public void should_ListOneItem() {
        List<Evento> list = new ArrayList<Evento>();
        list.add(entity);
        when(repositoryMock.findAll()).thenReturn(list);

        List<Evento> model = eventoService.listEvento();

        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", model);
        assertEquals("Array deve conter um item", 1, model.size());
        assertEquals("Array deve ser do tipo Evento", entity.getIdEvento(), model.get(0).getIdEvento());
    }
}