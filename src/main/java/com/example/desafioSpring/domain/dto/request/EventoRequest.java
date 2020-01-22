package com.example.desafioSpring.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.desafioSpring.domain.validator.GetDateValidator;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@GetDateValidator
public class EventoRequest {


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