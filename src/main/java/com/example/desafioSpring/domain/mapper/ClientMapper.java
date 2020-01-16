package com.example.desafioSpring.domain.mapper;

import com.example.desafioSpring.domain.dto.response.ClientResponse;
import com.example.desafioSpring.domain.dto.request.ClientCreateRequest;
import com.example.desafioSpring.domain.entities.Client;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    private final ModelMapper mapper;

    @Autowired
    public ClientMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ClientResponse toDto(Client input) {
        return mapper.map(input, ClientResponse.class);
    }

    public Client fromDto(ClientCreateRequest input) {
        return mapper.map(input, Client.class);
    }

} 