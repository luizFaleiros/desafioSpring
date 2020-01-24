package com.example.desafioSpring.domain.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

import com.example.desafioSpring.domain.validator.GetDateValidator;



@Data
@GetDateValidator
@SuperBuilder
public class EventoRequest extends EventoBase {


}