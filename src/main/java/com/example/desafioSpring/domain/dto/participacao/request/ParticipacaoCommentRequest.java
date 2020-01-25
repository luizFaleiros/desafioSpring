package com.example.desafioSpring.domain.dto.participacao.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * ParticipacaoCommentRequest
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ParticipacaoCommentRequest extends ParticipacaoStatusFlagUpdate{

    private Integer nota;

    private String comentario;

}