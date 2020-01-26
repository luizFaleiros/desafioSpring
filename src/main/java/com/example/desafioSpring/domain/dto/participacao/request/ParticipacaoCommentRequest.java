package com.example.desafioSpring.domain.dto.participacao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ParticipacaoCommentRequest
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipacaoCommentRequest{

    private Integer nota;

    private String comentario;

}