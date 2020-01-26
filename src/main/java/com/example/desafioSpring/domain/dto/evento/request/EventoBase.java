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
    protected Date DataHoraInicio;

    @NotNull
    protected Date DataHoraFim;

    @NotEmpty
    protected String Local;

    @NotEmpty
    protected String Descricao;

    @NotNull
    @Min(value = 1)
    protected Integer LimiteVagas;

}