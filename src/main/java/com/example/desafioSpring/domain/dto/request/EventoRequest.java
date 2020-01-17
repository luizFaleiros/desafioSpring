package com.example.desafioSpring.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.validation.constraints.NotEmpty;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoRequest {


    private Integer idEventoStatus;
    
    private Integer idCategoriaEvento;

    @NotEmpty
    private String nome;

    
    private Date DataHoraInicio;

    
    private Date DataHoraFim;
    
    @NotEmpty
    private String Local;

    @NotEmpty
    private String Descricao;

    private Integer LimiteVagas;
}