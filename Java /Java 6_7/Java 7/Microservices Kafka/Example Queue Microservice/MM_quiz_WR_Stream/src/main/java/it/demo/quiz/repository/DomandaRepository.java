package it.demo.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.demo.quiz.entity.Domanda;

public interface DomandaRepository extends JpaRepository<Domanda, Integer> {

}
