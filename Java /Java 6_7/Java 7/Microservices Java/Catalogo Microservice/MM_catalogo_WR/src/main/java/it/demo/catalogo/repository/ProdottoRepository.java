package it.demo.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.demo.catalogo.entity.Prodotto;


public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {

}
