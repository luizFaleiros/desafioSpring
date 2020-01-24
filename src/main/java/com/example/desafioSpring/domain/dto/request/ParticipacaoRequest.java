package com.example.desafioSpring.domain.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * ParticipacaoRequest
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ParticipacaoRequest {

    // private Integer IdParticipacao;

    @NotNull
    private Integer IdEvento;

    @NotEmpty
    private String LoginParticipante;
}