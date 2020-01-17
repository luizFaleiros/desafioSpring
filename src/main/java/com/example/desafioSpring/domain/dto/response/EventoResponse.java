package com.example.desafioSpring.domain.dto.response;

import java.util.Date;

import com.example.desafioSpring.domain.entities.CategoriaEvento;
import com.example.desafioSpring.domain.entities.StatusEvento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoResponse {

    
    private StatusEvento  eventoStatus;

    private CategoriaEvento categoriaEvento;

    private String nome;

    private Date DataHoraInicio;

    private Date DataHoraFim;
    
    private String Local;

    private String Descricao;

    private Integer LimiteVagas;
}