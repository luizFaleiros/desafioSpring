package com.example.desafioSpring.domain.dto.evento.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EventoSearchData
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventoSearchData {

    @NotNull
    private Date dataHoraInicio;

    @NotNull
    private Date dataHoraFim;

}