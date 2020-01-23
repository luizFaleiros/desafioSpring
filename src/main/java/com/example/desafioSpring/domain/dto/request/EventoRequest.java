package com.example.desafioSpring.domain.dto.request;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

import com.example.desafioSpring.domain.validator.GetDateValidator;



@Data
@GetDateValidator
public class EventoRequest extends EventoBase {

    @Builder
    public EventoRequest(Integer idCategoriaEvento, String nome, Date DataHoraInicio, Date DataHoraFim,String Local, String Descricao,Integer LimiteVagas, Integer idEventoStatus) {
        super(idCategoriaEvento, nome, DataHoraInicio, DataHoraFim, Local,Descricao, LimiteVagas);
    }

}