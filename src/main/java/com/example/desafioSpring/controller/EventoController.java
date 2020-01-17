package com.example.desafioSpring.controller;

import java.util.List;
import java.util.stream.Collectors;



import com.example.desafioSpring.domain.dto.response.EventoResponse;
import com.example.desafioSpring.domain.mapper.EventoMapper;
import com.example.desafioSpring.services.EventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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