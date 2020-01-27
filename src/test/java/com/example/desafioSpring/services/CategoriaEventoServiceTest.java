package com.example.desafioSpring.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.example.desafioSpring.domain.entities.CategoriaEvento;
import com.example.desafioSpring.exception.DataNotFoundException;
import com.example.desafioSpring.repository.CategoriaEventoRepository;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * CategoriaEventoServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoriaEventoServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private CategoriaEventoRepository repositoryMock;

    @InjectMocks
    CategoriaEventoService service;

    private final Integer id = 1;
    private final String nome = "Some String";
    CategoriaEvento entity = CategoriaEvento.builder().nomeCategoria(nome).idCategoriaEvento(id).build();


    @Test
    public void should_throwDataNotFoundException() {
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Categoria não encontrado");

        service.findById(1);
    }

    @Test
    public void should_findById() {
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        CategoriaEvento model = service.findById(anyInt());

        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("StatusEvento deve ser encontrado", model);
    }

    @Test
    public void should_ListOneItem() {
        List<CategoriaEvento> list = new ArrayList<CategoriaEvento>();
        list.add(entity);
        when(repositoryMock.findAll()).thenReturn(list);

        List<CategoriaEvento> model = service.listCategoriaEvento();

        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", model);
        assertEquals("Array deve conter um item", 1, model.size());
        assertEquals("Array deve ser do tipo StatusEvento", entity.getIdCategoriaEvento(),
                model.get(0).getIdCategoriaEvento());
    }
}