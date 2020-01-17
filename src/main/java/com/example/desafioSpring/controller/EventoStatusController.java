package com.example.desafioSpring.controller;

import com.example.desafioSpring.domain.mapper.StatusEventoMapper;
import com.example.desafioSpring.services.EventoStatusService;
import com.example.desafioSpring.domain.dto.response.StatusEventoResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * EventoStatusController
 */
@RestController
@RequestMapping("evento-status")
public class EventoStatusController {

    private EventoStatusService eventoStatusService;
    private StatusEventoMapper mapper;

    @Autowired
    public EventoStatusController(EventoStatusService eventoStatusService, StatusEventoMapper mapper) {
        this.eventoStatusService = eventoStatusService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<StatusEventoResponse>> listEventoStatus(){
        return ResponseEntity.ok(eventoStatusService.listStatusEvento().stream().map(x -> mapper.toDto(x)).collect(Collectors.toList()));
    }
    
}