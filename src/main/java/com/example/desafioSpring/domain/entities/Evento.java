package com.example.desafioSpring.domain.entities;

import java.util.Date;

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

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvento;

    @ManyToOne
    @JoinColumn(name = "IDEventoStatus", nullable = false)
    private StatusEvento eventoStatus;

    @ManyToOne
    @JoinColumn(name = "IdCategoriaEvento", nullable = false)
    private CategoriaEvento categoriaEvento;

    @Column(nullable = false, length = 250)
    private String nome;

    @Column(nullable = false)
    private Date dataHoraInicio;

    @Column(nullable = false)
    private Date dataHoraFim;

    @Column(nullable = false, length = 250)
    private String local;

    @Column(nullable = false, length = 1000)
    private String descricao;

    @Column(nullable = false)
    private Integer limiteVagas;
}