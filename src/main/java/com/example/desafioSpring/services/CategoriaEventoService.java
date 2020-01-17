package com.example.desafioSpring.services;

import java.util.List;
import java.util.Optional;

import com.example.desafioSpring.domain.entities.CategoriaEvento;
import com.example.desafioSpring.exception.DataNotFoundException;
import com.example.desafioSpring.repository.CategoriaEventoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CategoriaEventoService {
    private CategoriaEventoRepository categoriaEventoRepository;

    @Autowired
    public CategoriaEventoService(CategoriaEventoRepository categoriaEventoRepository) {
        this.categoriaEventoRepository = categoriaEventoRepository;
    }

    public List<CategoriaEvento> listCategoriaEvento() {
        return categoriaEventoRepository.findAll();
    }

    public CategoriaEvento findById(Integer id) {
        Optional<CategoriaEvento> evento = categoriaEventoRepository.findById(id);
        return evento.orElseThrow(() -> new DataNotFoundException("Categoria não encontrado"));
    }

}