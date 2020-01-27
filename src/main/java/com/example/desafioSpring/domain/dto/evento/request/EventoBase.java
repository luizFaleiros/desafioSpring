package com.example.desafioSpring.domain.dto.evento.request;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.desafioSpring.domain.validator.evento.GetDateValidator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * EventoBase
 */
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@GetDateValidator
public abstract class EventoBase {

    @NotNull
    protected Integer idCategoriaEvento;

    @NotEmpty
    protected String nome;

    @NotNull
    protected Date dataHoraInicio;

    @NotNull
    protected Date dataHoraFim;

    @NotEmpty
    protected String local;

    @NotEmpty
    protected String descricao;

    @NotNull
    @Min(value = 1)
    protected Integer limiteVagas;

}