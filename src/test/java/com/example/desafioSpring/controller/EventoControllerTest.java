package com.example.desafioSpring.controller;

import com.example.desafioSpring.domain.mapper.EventoMapper;
import com.example.desafioSpring.services.EventoService;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * EventoControllerTest
 */
@RunWith(MockitoJUnitRunner.class)
public class EventoControllerTest {
    @Mock
    EventoMapper eventoMapper;
    @Mock
    EventoService eventoService;
    @InjectMocks
    EventoController eventoController;


}