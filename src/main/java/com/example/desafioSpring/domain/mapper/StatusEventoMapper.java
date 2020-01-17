package com.example.desafioSpring.domain.mapper;

import com.example.desafioSpring.domain.dto.response.StatusEventoResponse;
import com.example.desafioSpring.domain.entities.StatusEvento;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * StatusEventoMapper
 */
@Component
public class StatusEventoMapper {
    
    private final ModelMapper mapper;
    
    @Autowired
    public StatusEventoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public StatusEventoResponse toDto(StatusEvento x){
        return mapper.map(x, StatusEventoResponse.class);
    }
    
}