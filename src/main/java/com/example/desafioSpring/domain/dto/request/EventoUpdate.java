package com.example.desafioSpring.domain.dto.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * EventoUpdate
 */
@Data
@AllArgsConstructor
public class EventoUpdate extends EventoBase {
    @NotNull
    private Integer idEventoStatus;

    @Builder
    public EventoUpdate(Integer idCategoriaEvento, String nome, Date DataHoraInicio, Date DataHoraFim,String Local, String Descricao,Integer LimiteVagas, Integer idEventoStatus) {
        super(idCategoriaEvento, nome, DataHoraInicio, DataHoraFim, Local,Descricao, LimiteVagas);
        this.idEventoStatus = idEventoStatus;
    }


}