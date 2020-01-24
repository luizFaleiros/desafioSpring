package com.example.desafioSpring.domain.dto.participacao.response;

import com.example.desafioSpring.domain.entities.Evento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ParticipacaoResponse
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipacaoResponse {

    
    private Integer idParticipacao;


    private Evento evento;


    private String loginParticipante;
    

    private Boolean flagPresente;

    private Integer nota;

    private String comentario;
    
}