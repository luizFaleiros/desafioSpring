package com.example.desafioSpring.domain.dto.request;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.desafioSpring.domain.validator.GetDateValidator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EventoBase
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@GetDateValidator
public class EventoBase {
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