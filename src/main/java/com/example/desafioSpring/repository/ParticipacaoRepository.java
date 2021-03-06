package com.example.desafioSpring.repository;

import com.example.desafioSpring.domain.entities.Participacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * ParticipacaoRepository
 */
@Repository
public interface ParticipacaoRepository extends JpaRepository<Participacao, Integer> {
    @Query(nativeQuery = true, value = " SELECT COUNT(*) AS [QntPessoas] FROM [dbo].[Participacao] WHERE [IdEvento] = :id GROUP BY [idEvento]")
    Integer qntInscritos(Integer id);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) AS [QntPessoas] FROM [dbo].[Participacao] WHERE [IdEvento] = :id  AND [LoginParticipante]Like ':login' GROUP BY [idEvento]")
    Integer JaInscrito(Integer id, String login);


}