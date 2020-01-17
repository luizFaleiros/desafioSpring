package com.example.desafioSpring.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaEventoResponse {

    private Integer IdCategoriaEvento;

    private String NomeCategoria;

}