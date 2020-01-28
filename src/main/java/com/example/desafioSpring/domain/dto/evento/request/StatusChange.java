package com.example.desafioSpring.domain.dto.evento.request;

import javax.validation.constraints.NotNull;

import com.example.desafioSpring.domain.validator.evento.GetCancel;
import com.example.desafioSpring.domain.validator.evento.GetInitial;
import com.example.desafioSpring.domain.validator.evento.GetStatusConcluido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * StatusChange
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@GetCancel
@GetInitial
@GetStatusConcluido
public class StatusChange {

    @NotNull
    private Integer idEventoStatus;
}