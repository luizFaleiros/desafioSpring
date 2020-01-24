package com.example.desafioSpring.domain.dto.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.example.desafioSpring.domain.validator.GetDateValidator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * EventoUpdate
 */
@Data
@SuperBuilder
public class EventoUpdate extends EventoBase {
    @NotNull
    private Integer idEventoStatus;




}