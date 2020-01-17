package com.example.desafioSpring.services;

import java.util.List;

import com.example.desafioSpring.domain.entities.Evento;
import com.example.desafioSpring.repository.EventoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EventoService {
    private EventoRepository eventoRepository;

    @Autowired
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> listEvento() {
        return eventoRepository.findAll();
    }

}