package com.example.desafioSpring.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvento;

    @Column(nullable = false)
    private Integer idEventStatus;

    @Column(nullable = false, length = 255)
    private Integer idCategoriaEvento;

    @Column(nullable = false, length = 250)
    private String nome;

    @Column(nullable = false)
    private Date DataHoraInicio;

    @Column(nullable = false)
    private Date DataHoraFim;
    
    @Column(nullable = false, length = 250)
    private String Local;

    @Column(nullable = false, length = 1000)
    private String Descricao;

    @Column(nullable = false)
    private Integer LimiteVagas;
} 