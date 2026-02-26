package com.spring.azienda.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.azienda.entity.Dipendente;

@Repository
public interface DipendenteDAO extends JpaRepository<Dipendente, Integer> {
	
	
	List<Dipendente> findBySalarioDipendente(Double salario);

    Optional<Dipendente> findByMatricola(String idMatricola);

}
