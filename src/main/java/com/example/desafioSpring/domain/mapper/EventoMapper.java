package com.example.desafioSpring.domain.mapper;

import com.example.desafioSpring.domain.dto.evento.request.EventoRequest;
import com.example.desafioSpring.domain.dto.evento.response.EventoResponse;
import com.example.desafioSpring.domain.entities.Evento;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoMapper {

    private final ModelMapper mapper;

    @Autowired
    public EventoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public EventoResponse toDto(Evento input) {
        return mapper.map(input, EventoResponse.class);
    }

    public Evento fromDto(EventoRequest input) {
        return mapper.map(input, Evento.class);
    }


}