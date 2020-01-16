package com.example.desafioSpring.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.desafioSpring.domain.dto.response.EventoResponse;
import com.example.desafioSpring.domain.mapper.EventoMapper;
import com.example.desafioSpring.services.Evento.EventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private EventoService eventoService;
    private EventoMapper mapper;

    @Autowired
	public EventoController(EventoService eventoService, EventoMapper eventoMapper) {
		this.eventoService = eventoService;
		this.mapper = eventoMapper;
    }
    
    @GetMapping
	public ResponseEntity<List<EventoResponse>> listEvento() {
		return ResponseEntity.ok(eventoService.listEvento().stream().map(x-> mapper.toDto(x)).collect(Collectors.toList()));
	}
    
}