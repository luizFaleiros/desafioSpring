package com.example.desafioSpring.domain.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ParticipacaoRequest
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
 public class ParticipacaoRequest {

    // private Integer IdParticipacao;

    @NotNull
    private Integer IdEvento;

    @NotEmpty
    private String LoginParticipante;
    
    @NotNull
    private Boolean FlagPresente;
    
    @NotNull
    private Integer Nota;

    @Size(max = 1000)
    private String Comentario;
}