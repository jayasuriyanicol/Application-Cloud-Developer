package com.spring.cc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.cc.entity.Utente;
import org.springframework.stereotype.Repository;


@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer>{
	
    // ? Verifying if an email already exists in the database (logic business)
	public boolean existsByEMail(String email);


}
