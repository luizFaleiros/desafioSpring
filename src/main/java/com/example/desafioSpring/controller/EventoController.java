package com.example.desafioSpring.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.desafioSpring.domain.dto.evento.request.EventoRequest;
import com.example.desafioSpring.domain.dto.evento.request.EventoSearchData;
import com.example.desafioSpring.domain.dto.evento.request.EventoUpdate;
import com.example.desafioSpring.domain.dto.evento.request.StatusChange;
import com.example.desafioSpring.domain.dto.evento.response.EventoResponse;
import com.example.desafioSpring.domain.entities.CategoriaEvento;
import com.example.desafioSpring.domain.entities.Evento;
import com.example.desafioSpring.domain.mapper.EventoMapper;
import com.example.desafioSpring.services.CategoriaEventoService;
import com.example.desafioSpring.services.EventoService;
import com.example.desafioSpring.services.EventoStatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
		evento.setCategoriaEvento(categoriaEventoService.findById(model.getIdCategoriaEvento()));
		eventoService.cadastroEvento(evento);
		return ResponseEntity.ok(mapper.toDto(evento));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<EventoResponse> put(@Valid @PathVariable Integer id, @RequestBody EventoUpdate model) {
		Evento evento = eventoService.findById(id);
		evento.setDataHoraFim(model.getDataHoraFim());
		evento.setDataHoraInicio(model.getDataHoraInicio());
		evento.setDescricao(model.getDescricao());
		evento.setLimiteVagas(model.getLimiteVagas());
		evento.setLocal(model.getLocal());
		evento.setNome(model.getNome());
		evento.setCategoriaEvento(categoriaEventoService.findById(model.getIdCategoriaEvento()));
		evento.setEventoStatus(eventoStatusService.findById(model.getIdEventoStatus()));
		return ResponseEntity.ok(mapper.toDto(eventoService.cadastroEvento(evento)));
	}

	@GetMapping(value = "/categoria/{id}")
	public ResponseEntity<List<EventoResponse>> findByCategoria(@Valid @PathVariable Integer id) {
		CategoriaEvento categoriaEvento =  categoriaEventoService.findById(id);
		return ResponseEntity
				.ok(eventoService.listByCategoria(categoriaEvento).stream().map(x -> mapper.toDto(x)).collect(Collectors.toList()));
	}
	@PostMapping(value = "/dataSearch/")
	public ResponseEntity<List<EventoResponse>> listByDate(@RequestBody EventoSearchData model){
		List<Evento> evento = eventoService.listByData(model.getDataHoraInicio(), model.getDataHoraFim());
		return ResponseEntity
				.ok(evento.stream().map(x -> mapper.toDto(x)).collect(Collectors.toList()));
	}

	@PatchMapping(value = "/Status/{id}")
	public ResponseEntity<EventoResponse> putStatusChange(@Valid @RequestBody StatusChange model, @PathVariable Integer id){
		Evento evento = eventoService.findById(id);
		return ResponseEntity.ok(mapper.toDto(eventoService.putStatusChange(id, evento)));
	}
}