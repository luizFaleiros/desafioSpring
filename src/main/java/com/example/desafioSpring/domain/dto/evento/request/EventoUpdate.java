package com.example.desafioSpring.domain.dto.evento.request;

import java.util.Date;

import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * EventoUpdate
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class EventoUpdate extends EventoBase {
    @NotNull
    private Integer idEventoStatus;

}