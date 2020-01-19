package com.example.desafioSpring.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.desafioSpring.domain.dto.request.ParticipacaoRequest;
import com.example.desafioSpring.domain.dto.response.ParticipacaoResponse;
import com.example.desafioSpring.domain.entities.Participacao;
import com.example.desafioSpring.domain.mapper.ParticipacaoMapper;
import com.example.desafioSpring.services.EventoService;
import com.example.desafioSpring.services.ParticipacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ParticipacaoController
 */
@RestController
@RequestMapping("/participacao")
public class ParticipacaoController {
    private ParticipacaoService participacaoService;
    private ParticipacaoMapper mapper;
    private EventoService eventoService;

    @Autowired
    public ParticipacaoController(ParticipacaoService participacaoService, ParticipacaoMapper mapper,
            EventoService eventoService) {
        this.participacaoService = participacaoService;
        this.mapper = mapper;
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<List<ParticipacaoResponse>> listParticipacao() {
        return ResponseEntity.ok(
                participacaoService.listParticipacao().stream().map(x -> mapper.toDto(x)).collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParticipacaoResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(mapper.toDto(participacaoService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ParticipacaoResponse> postMethodName(@Valid @RequestBody ParticipacaoRequest model) {
        Participacao participacao = mapper.fromDto(model);
        participacao.setEvento(eventoService.findById(model.getIdEvento()));
        participacaoService.cadastrarParticipacao(participacao);
        return ResponseEntity.ok(mapper.toDto(participacao));
    }
    
    @PutMapping(value = "/{id}")
	public ResponseEntity<ParticipacaoResponse> put(@Valid @PathVariable Integer id, @RequestBody ParticipacaoRequest model) {
        Participacao participacao = participacaoService.findById(id);
        participacao.setEvento(eventoService.findById(model.getIdEvento()));
        participacao.setComentario(model.getComentario());
        participacao.setFlagPresente(model.getFlagPresente());
        participacao.setLoginParticipante(model.getLoginParticipante());
        participacao.setNota(model.getNota());
        participacaoService.cadastrarParticipacao(participacao);
        return ResponseEntity.ok(mapper.toDto(participacao));
    }
    
    @DeleteMapping(value = "/{id}")
	public Boolean delete(@PathVariable Integer id) {
		if (participacaoService.deletarParticipacao(id)) {
			return true;
		}
		return false;
	}

}