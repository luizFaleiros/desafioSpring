package com.example.desafioSpring.domain.dto.evento.request;


import javax.validation.constraints.NotNull;

import com.example.desafioSpring.domain.validator.GetCancel;
import com.example.desafioSpring.domain.validator.GetInitial;

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
@GetCancel
@GetInitial
public class EventoUpdate extends EventoBase {
    @NotNull
    private Integer idEventoStatus;

}