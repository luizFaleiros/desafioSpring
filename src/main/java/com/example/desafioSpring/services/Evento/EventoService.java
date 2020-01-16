package com.example.desafioSpring.services.Evento;

import java.util.List;
import java.util.Optional;

import com.example.desafioSpring.domain.entities.Evento;
import com.example.desafioSpring.repository.evento.EventoRepository;

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