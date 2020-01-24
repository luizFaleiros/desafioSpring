package com.example.desafioSpring.services;

import java.util.List;
import java.util.Optional;

import com.example.desafioSpring.domain.entities.Participacao;
import com.example.desafioSpring.exception.DataCantBeCreate;
import com.example.desafioSpring.exception.DataCantDeleteException;
import com.example.desafioSpring.exception.DataDeletedException;
import com.example.desafioSpring.exception.DataNotFoundException;
import com.example.desafioSpring.repository.ParticipacaoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ParticipacaoService
 */
@Service
public class ParticipacaoService {

    private ParticipacaoRepository participacaoRepository;

    @Autowired
    public ParticipacaoService(ParticipacaoRepository participacaoRepository) {
        this.participacaoRepository = participacaoRepository;
    }

    public List<Participacao> listParticipacao() {
        return participacaoRepository.findAll();
    }

    public Participacao findById(Integer id) {
        Optional<Participacao> participacao = participacaoRepository.findById(id);
        return participacao.orElseThrow(() -> new DataNotFoundException("Participacao nao Encontrada"));
    }

    public Participacao cadastrarParticipacao(Participacao model) {
        if(!this.JaInscrito(model.getEvento().getIdEvento(),model.getLoginParticipante())){
            throw new DataCantBeCreate("Usuario ja cadastrado");
        }
        model.setFlagPresente(false);
        model.setNota(null);
        model.setComentario(null);
        return participacaoRepository.save(model);
    }

    public void deletarParticipacao(Integer id) {
        findById(id);
        try {
            participacaoRepository.deleteById(id);
        } catch (Exception e) {
            new DataCantDeleteException("Impossibru", e);
        }
    }

    public Integer qntParticipantes(Integer id) {
        return participacaoRepository.qntInscritos(id);
    }

    public Boolean JaInscrito(Integer id, String login) {
        if (participacaoRepository.JaInscrito(id, login) != null) {
            return false;
        }
        return true;
    }
}