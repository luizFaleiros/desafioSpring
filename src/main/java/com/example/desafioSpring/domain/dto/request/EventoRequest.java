package com.example.desafioSpring.domain.dto.request;

import lombok.experimental.SuperBuilder;

import com.example.desafioSpring.domain.validator.GetDateValidator;



@SuperBuilder
@GetDateValidator
public class EventoRequest extends EventoBase {

    public EventoRequest() {
        super();
    }



}