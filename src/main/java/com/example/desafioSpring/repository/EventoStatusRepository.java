package com.example.desafioSpring.repository;

import com.example.desafioSpring.domain.entities.StatusEvento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EventoStatusRepository extends JpaRepository<StatusEvento, Integer> {


} 
