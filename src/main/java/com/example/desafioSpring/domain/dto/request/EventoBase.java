package com.example.desafioSpring.domain.dto.request;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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