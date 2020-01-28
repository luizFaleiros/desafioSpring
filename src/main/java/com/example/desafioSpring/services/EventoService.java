package com.example.desafioSpring.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.desafioSpring.domain.entities.CategoriaEvento;
import com.example.desafioSpring.domain.entities.Evento;
import com.example.desafioSpring.exception.DataNotFoundException;
import com.example.desafioSpring.repository.EventoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EventoService {
    private EventoRepository eventoRepository;
    private CategoriaEventoService categoriaEventoService;

    @Autowired
    public EventoService(EventoRepository eventoRepository, EventoStatusService eventoStatusService,
            CategoriaEventoService categoriaEventoService) {
        this.eventoRepository = eventoRepository;
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

    public List<Evento> listByCategoria(Integer id) {
        CategoriaEvento categoriaEvento =  categoriaEventoService.findById(id);
        return eventoRepository.findByCategoriaEvento(categoriaEvento);
    }

    public List<Evento> listByData(Date ini, Date fim){
        return eventoRepository.findByDataHoraInicioBetween(ini, fim);
    }

    public Evento putStatusChange(Integer id, Evento model){
        Evento evento = findById(id);
        evento.setEventoStatus(model.getEventoStatus());
        return eventoRepository.save(evento);
    }
}