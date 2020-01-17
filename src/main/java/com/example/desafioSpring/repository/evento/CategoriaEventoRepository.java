package com.example.desafioSpring.repository.evento;


import com.example.desafioSpring.domain.entities.CategoriaEvento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoriaEventoRepository extends JpaRepository<CategoriaEvento, Integer> {


} 
