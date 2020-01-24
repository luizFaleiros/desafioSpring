package com.example.desafioSpring.domain.dto.request;


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
public class ParticipacaoStatusFlagUpdate {

    // private Integer IdParticipacao;
    @NotNull
    private Boolean flagPresente;
}