package com.example.desafioSpring.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.desafioSpring.domain.dto.request.EventoRequest;
import com.example.desafioSpring.domain.dto.request.EventoUpdate;
import com.example.desafioSpring.domain.dto.response.EventoResponse;
import com.example.desafioSpring.domain.entities.Evento;
import com.example.desafioSpring.domain.mapper.EventoMapper;
import com.example.desafioSpring.services.CategoriaEventoService;
import com.example.desafioSpring.services.EventoService;
import com.example.desafioSpring.services.EventoStatusService;

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
	private EventoStatusService eventoStatusService;
	private CategoriaEventoService categoriaEventoService;

	@Autowired
	public EventoController(EventoService eventoService, EventoMapper eventoMapper,
			EventoStatusService eventoStatusService, CategoriaEventoService categoriaEventoService) {
		this.eventoService = eventoService;
		this.mapper = eventoMapper;
		this.eventoStatusService = eventoStatusService;
		this.categoriaEventoService = categoriaEventoService;
	}

	@GetMapping
	public ResponseEntity<List<EventoResponse>> listEvento() {
		return ResponseEntity
				.ok(eventoService.listEvento().stream().map(x -> mapper.toDto(x)).collect(Collectors.toList()));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EventoResponse> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(mapper.toDto(eventoService.findById(id)));
	}

	@PostMapping
	public ResponseEntity<EventoResponse> post(@Valid @RequestBody EventoRequest model) {
		Evento evento = mapper.fromDto(model);
		evento.setEventoStatus(eventoStatusService.findById(1));
		evento.setCategoriaEvento(categoriaEventoService.findById(1));
		eventoService.cadastroEvento(evento);
		return ResponseEntity.ok(mapper.toDto(evento));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<EventoResponse> put(@Valid @PathVariable Integer id, @RequestBody EventoUpdate model) {
		Evento evento = eventoService.updateEvento(id, model);
		return ResponseEntity.ok(mapper.toDto(evento));
	}

	@DeleteMapping(value = "/{id}")
	public Boolean delete(@PathVariable Integer id) {
		if (eventoService.deleteEvento(id)) {
			return true;
		}
		return false;
	}

}