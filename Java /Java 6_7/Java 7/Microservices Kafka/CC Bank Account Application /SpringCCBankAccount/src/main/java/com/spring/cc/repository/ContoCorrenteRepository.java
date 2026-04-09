package com.spring.cc.repository;

import com.spring.cc.entity.ContoCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContoCorrenteRepository extends JpaRepository<ContoCorrente, Integer> {
	
    // ? Here a Native Query to calculate the total balance in the CC: no nativeQuery or value directly the SQL query to avoid the syntax one
	@Query("SELECT SUM(c.saldo) FROM ContoCorrente c")
	public Double getPatrimonioComplessivo();

}
