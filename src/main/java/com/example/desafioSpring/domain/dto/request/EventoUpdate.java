package com.example.desafioSpring.domain.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * EventoUpdate
 */
@Data
public class EventoUpdate  extends EventoRequest{

    @NotNull
    private Integer idEventoStatus;

}