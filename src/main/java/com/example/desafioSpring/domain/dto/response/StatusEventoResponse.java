package com.example.desafioSpring.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * StatusEventoResponse
 */

 @Data
 @NoArgsConstructor
 @AllArgsConstructor
 @Builder
public class StatusEventoResponse {

    private Integer IdEventoStatus;
    private String NomeStatus;
    
}