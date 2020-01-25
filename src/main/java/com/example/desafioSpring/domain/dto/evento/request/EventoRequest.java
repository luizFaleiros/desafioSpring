package com.example.desafioSpring.domain.dto.evento.request;

import lombok.experimental.SuperBuilder;

import com.example.desafioSpring.domain.validator.evento.GetDateValidator;



@SuperBuilder
@GetDateValidator
public class EventoRequest extends EventoBase {

    public EventoRequest() {
        super();
    }



}