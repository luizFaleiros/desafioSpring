package com.example.desafioSpring.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.desafioSpring.domain.entities.CategoriaEvento;
import com.example.desafioSpring.domain.entities.Evento;
import com.example.desafioSpring.domain.entities.StatusEvento;
import com.example.desafioSpring.exception.DataNotFoundException;
import com.example.desafioSpring.repository.EventoRepository;
import com.example.desafioSpring.utils.StatusChangeTeste;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private CategoriaEventoService categoriaEventoService;
    @Autowired
    private EventoStatusService eventoStatusService;

    @Autowired
    public EventoService(EventoRepository eventoRepository, EventoStatusService eventoStatusService,
            CategoriaEventoService categoriaEventoService) {
        this.eventoRepository = eventoRepository;
        this.categoriaEventoService = categoriaEventoService;
        this.eventoStatusService = eventoStatusService;
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

    public List<Evento> listByCategoria(CategoriaEvento categoriaEvento) {
        return eventoRepository.findByCategoriaEvento(categoriaEvento);
    }

    public List<Evento> listByData(Date ini, Date fim) {
        return eventoRepository.findByDataHoraInicioBetween(ini, fim);
    }

    public Evento putStatusChange(Integer id, Evento model) {
        Evento evento = findById(id);
        StatusEvento status = eventoStatusService.findById(model.getEventoStatus().getIdEventoStatus());
        evento.setEventoStatus(status);
        Integer ide = evento.getEventoStatus().getIdEventoStatus();
        Date ini = evento.getDataHoraInicio();
        Date fim = evento.getDataHoraFim();
        StatusChangeTeste statusChangeTeste = new StatusChangeTeste();
        if (statusChangeTeste.Validate(ide, ini,fim)) {
            return eventoRepository.save(evento);

        }
        throw new DataNotFoundException("Não foi possivel Fazer update");
    }
}