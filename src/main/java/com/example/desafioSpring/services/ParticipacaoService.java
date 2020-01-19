package com.example.desafioSpring.services;

import java.util.List;
import java.util.Optional;

import com.example.desafioSpring.domain.entities.Participacao;
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

    public Participacao cadastrarParticipacao(Participacao model){
        return participacaoRepository.save(model);
    }
    public boolean deletarParticipacao(Integer id) {
        findById(id);
        participacaoRepository.deleteById(id);
        return true;
        
    }
}