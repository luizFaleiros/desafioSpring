package com.example.desafioSpring.repository.evento;

import java.util.List;

import com.example.desafioSpring.domain.entities.Evento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {


} 
