package com.example.desafioSpring.domain.dto.participacao.request;

import javax.validation.constraints.Min;
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
    @Min(value = 1)
    private Integer idEvento;

    @NotEmpty
    private String loginParticipante;
}