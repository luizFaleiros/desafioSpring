package com.example.desafioSpring.services;

import java.util.List;
import java.util.Optional;

import com.example.desafioSpring.domain.entities.StatusEvento;
import com.example.desafioSpring.exception.DataNotFoundException;
import com.example.desafioSpring.repository.EventoStatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EventoStatusService
 */
@Service
public class EventoStatusService {
    private EventoStatusRepository eventoStatusRepository;

    @Autowired
    public EventoStatusService(EventoStatusRepository eventoStatusRepository) {
        this.eventoStatusRepository = eventoStatusRepository;
    }

    public List<StatusEvento> listStatusEvento() {
        return eventoStatusRepository.findAll();
    }

    public StatusEvento findById(Integer id) {
        Optional<StatusEvento> evento = eventoStatusRepository.findById(id);
        return evento.orElseThrow(() -> new DataNotFoundException("Status não encontrado"));
    }
}