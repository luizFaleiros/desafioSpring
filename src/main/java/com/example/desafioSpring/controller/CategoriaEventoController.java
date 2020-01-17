package com.example.desafioSpring.controller;

import java.util.List;

import java.util.stream.Collectors;


import com.example.desafioSpring.domain.dto.response.CategoriaEventoResponse;

import com.example.desafioSpring.domain.mapper.CategoriaEventoMapper;
import com.example.desafioSpring.services.CategoriaEventoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria-eventos")
public class CategoriaEventoController {

    private CategoriaEventoService categoriaEventoService;
    private CategoriaEventoMapper mapper;

    @Autowired
	public CategoriaEventoController(CategoriaEventoService categoriaEventoService, CategoriaEventoMapper categoriaEventoMapper) {
		this.categoriaEventoService = categoriaEventoService;
		this.mapper = categoriaEventoMapper;
    }
    
    @GetMapping
	public ResponseEntity<List<CategoriaEventoResponse>> listCategoriaEvento() {
		return ResponseEntity.ok(categoriaEventoService.listCategoriaEvento().stream().map(x -> mapper.toDto(x)).collect(Collectors.toList()));
							 
	}
    
}