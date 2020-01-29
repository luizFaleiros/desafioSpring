package com.example.desafioSpring.domain.mapper;

import static org.junit.Assert.assertEquals;

import com.example.desafioSpring.configuration.MapperConfig;
import com.example.desafioSpring.domain.dto.response.CategoriaEventoResponse;
import com.example.desafioSpring.domain.entities.CategoriaEvento;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

/**
 * CategoriaEventoMapperTest
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoriaEventoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private CategoriaEventoMapper mapper;

    @Test
    public void should_be_convert_StatusEvento_to_statusEventoResponse() {
        CategoriaEvento categoriaEvento = CategoriaEvento.builder().idCategoriaEvento(1).nomeCategoria("Teste").build();
        CategoriaEventoResponse categoriaEventoResponse = mapper.toDto(categoriaEvento);

        assertEquals("Valor definido invalido", categoriaEvento.getIdCategoriaEvento(),
                categoriaEventoResponse.getIdCategoriaEvento());
        assertEquals("Valor definido invalido", categoriaEvento.getNomeCategoria(), categoriaEventoResponse.getNomeCategoria());
    }
 
}