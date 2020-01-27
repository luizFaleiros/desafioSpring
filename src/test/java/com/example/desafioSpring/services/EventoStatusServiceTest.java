package com.example.desafioSpring.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.desafioSpring.domain.entities.StatusEvento;
import com.example.desafioSpring.repository.EventoStatusRepository;
import com.example.desafioSpring.exception.DataNotFoundException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.rules.ExpectedException;

/**
 * eventoStatusServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class EventoStatusServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private EventoStatusRepository repositoryMock;

    @InjectMocks
    EventoStatusService service;

    private final Integer id = 1;
    private final String nome = "Some String";
    StatusEvento entity = StatusEvento.builder().NomeStatus(nome).idEventoStatus(id).build();

    @Test
    public void should_throwDataNotFoundException() {
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Status não encontrado");

        service.findById(1);
    }

    @Test
    public void should_findById() {
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        StatusEvento model = service.findById(anyInt());

        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("StatusEvento deve ser encontrado", model);
    }

    @Test
    public void should_ListOneItem() {
        List<StatusEvento> list = new ArrayList<StatusEvento>();
        list.add(entity);
        when(repositoryMock.findAll()).thenReturn(list);

        List<StatusEvento> model = service.listStatusEvento();

        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", model);
        assertEquals("Array deve conter um item", 1, model.size());
        assertEquals("Array deve ser do tipo StatusEvento", entity.getIdEventoStatus(),
                model.get(0).getIdEventoStatus());
    }
}