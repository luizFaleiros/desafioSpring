package com.example.desafioSpring.domain.dto.request;

import javax.validation.constraints.NotNull;

import com.example.desafioSpring.domain.validator.GetCancel;

import lombok.Data;


/**
 * EventoUpdate
 */
@Data
@GetCancel
public class EventoUpdate  extends EventoRequest{

    @NotNull
    private Integer idEventoStatus;

}