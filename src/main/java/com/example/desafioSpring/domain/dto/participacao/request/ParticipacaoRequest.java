package com.example.desafioSpring.domain.dto.participacao.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class ParticipacaoRequest{

    // private Integer IdParticipacao;

    @NotNull
    @Min(value = 1)
    private Integer idEvento;

    @NotEmpty
    private String loginParticipante;
}