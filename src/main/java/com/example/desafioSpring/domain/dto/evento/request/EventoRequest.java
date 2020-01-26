package com.example.desafioSpring.domain.dto.evento.request;

import com.example.desafioSpring.domain.validator.evento.GetDateValidator;

import lombok.experimental.SuperBuilder;



@SuperBuilder
@GetDateValidator
public class EventoRequest extends EventoBase {

    public EventoRequest() {
        super();
    }



}