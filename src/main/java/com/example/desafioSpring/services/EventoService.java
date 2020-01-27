package com.example.desafioSpring.services;

import java.util.List;
import java.util.Optional;

import com.example.desafioSpring.domain.dto.evento.request.EventoUpdate;
import com.example.desafioSpring.domain.entities.Evento;
import com.example.desafioSpring.exception.DataCantDeleteException;
import com.example.desafioSpring.exception.DataNotFoundException;
import com.example.desafioSpring.repository.EventoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EventoService {
    private EventoRepository eventoRepository;
    private EventoStatusService eventoStatusService;
    private CategoriaEventoService categoriaEventoService;

    @Autowired
    public EventoService(EventoRepository eventoRepository, EventoStatusService eventoStatusService,
            CategoriaEventoService categoriaEventoService) {
        this.eventoRepository = eventoRepository;
        this.eventoStatusService = eventoStatusService;
        this.categoriaEventoService = categoriaEventoService;
    }

    public List<Evento> listEvento() {
        return eventoRepository.findAll();
    }

    public Evento findById(Integer id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        return evento.orElseThrow(() -> new DataNotFoundException("Evento não Encontrado"));
    }

    public Evento cadastroEvento(Evento model) {
        return eventoRepository.save(model);
    }

    

    // public void deleteEvento(Integer id) {
    //     findById(id);
    //     try {
    //         eventoRepository.deleteById(id);
    //     } catch (Exception e) {
    //         throw new DataCantDeleteException("Não pode ser deletado");
    //     }
    // }
}