package com.example.desafioSpring.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoRequest {

    @NotNull
    private Integer idEventoStatus;
    
    @NotNull
    private Integer idCategoriaEvento;
    
    @NotEmpty
    private String nome;
    
    
    @NotNull
    private Date DataHoraInicio;
    
    
    @NotNull
    private Date DataHoraFim;
    
    @NotEmpty
    private String Local;
    
    @NotEmpty
    private String Descricao;
    
    @NotNull
    @Min(value = 1)
    private Integer LimiteVagas;
}