package com.example.desafioSpring.domain.dto.participacao.request;

import javax.validation.constraints.NotNull;

import com.example.desafioSpring.domain.validator.participacao.GetFlag;

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
@GetFlag
public class ParticipacaoStatusFlagUpdate extends ParticipacaoRequest {

    // private Integer IdParticipacao;
    @NotNull
    private Boolean flagPresente;
}