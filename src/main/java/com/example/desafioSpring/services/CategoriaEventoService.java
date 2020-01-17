package com.example.desafioSpring.services;

import java.util.List;

import com.example.desafioSpring.domain.entities.CategoriaEvento;
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

}