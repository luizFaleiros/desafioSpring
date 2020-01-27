package com.example.desafioSpring.domain.mapper;

import static org.junit.Assert.assertEquals;


import com.example.desafioSpring.configuration.MapperConfig;
import com.example.desafioSpring.domain.dto.response.StatusEventoResponse;
import com.example.desafioSpring.domain.entities.StatusEvento;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

/**
 * StatusEventoMapper
 */

@RunWith(MockitoJUnitRunner.class)
public class StatusEventoMapperTest {
    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private StatusEventoMapper mapper;

    @Test
    public void should_be_convert_StatusEvento_to_statusEventoResponse() {
        StatusEvento statusEvento = StatusEvento.builder().idEventoStatus(1).NomeStatus("Teste").build();
        StatusEventoResponse statusEventoResponse = mapper.toDto(statusEvento);

        assertEquals("Valor definido invalido", statusEvento.getIdEventoStatus(),
                statusEventoResponse.getIdEventoStatus());
        assertEquals("Valor definido invalido", statusEvento.getNomeStatus(), statusEventoResponse.getNomeStatus());
    }

}