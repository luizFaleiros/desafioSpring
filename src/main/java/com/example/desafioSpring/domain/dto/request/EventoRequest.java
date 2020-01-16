package com.example.desafioSpring.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.example.desafioSpring.domain.validators.clientvalidator.Phone;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoRequest {



    @NotEmpty
    private Integer idCategoriaEvento;

    @NotEmpty
    private String nome;

    @NotEmpty
    private Date DataHoraInicio;

    @NotEmpty
    private Date DataHoraFim;
    
    @NotEmpty
    private String Local;

    @NotEmpty
    private String Descricao;

    @NotEmpty
    private Integer LimiteVagas;
}