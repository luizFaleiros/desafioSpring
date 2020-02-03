package com.example.desafioSpring.domain.dto.evento.request;

import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * StatusChange
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusChange {

    @NotNull
    private Integer idEventoStatus;
}