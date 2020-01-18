package com.example.desafioSpring.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Participacao
 */
@Data
@Entity
@Table(name="Participacao")
public class Participacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdParticipacao;

    @ManyToOne
    @JoinColumn(name="IdEvento", nullable = false)
    private Evento evento;
    @Column(nullable = false)
    private String LoginParticipante;
    @Column(nullable = false)
    private Boolean FlagPresente;
    @Column
    private Integer Nota;
    @Column(length = 1000)
    private String Comentario;
    
}