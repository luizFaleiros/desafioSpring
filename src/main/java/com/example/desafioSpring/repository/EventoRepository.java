package com.example.desafioSpring.repository;

import com.example.desafioSpring.domain.entities.Evento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    @Query(nativeQuery = true, value = " SELECT LoginParticipante FROM [dbo].[Participacao] WHERE [IdEvento] = :id")
    String QuemEstaInscrito(Integer id);
}
