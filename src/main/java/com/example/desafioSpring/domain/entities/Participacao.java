package com.example.desafioSpring.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Participacao
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Participacao")
public class Participacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParticipacao;

    @ManyToOne
    @JoinColumn(name="IdEvento", nullable = false)
    private Evento evento;

    @Column(nullable = false)
    private String loginParticipante;

    @Column(nullable = false)
    private Boolean flagPresente;

    @Column
    private Integer Nota;
    
    @Column(length = 1000)
    private String comentario;
    
}