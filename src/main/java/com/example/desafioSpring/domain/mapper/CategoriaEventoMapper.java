package com.example.desafioSpring.domain.mapper;

import com.example.desafioSpring.domain.dto.response.CategoriaEventoResponse;
import com.example.desafioSpring.domain.entities.CategoriaEvento;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaEventoMapper {

    private final ModelMapper mapper;

    @Autowired
    public CategoriaEventoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public CategoriaEventoResponse toDto(CategoriaEvento x) {
        return mapper.map(x, CategoriaEventoResponse.class);
    }

}