package com.example.desafioSpring.domain.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;


/**
 * EventoUpdate
 */
@Data
@Builder
public class EventoUpdate  extends EventoBase{

    @NotNull
    private Integer idEventoStatus;

}