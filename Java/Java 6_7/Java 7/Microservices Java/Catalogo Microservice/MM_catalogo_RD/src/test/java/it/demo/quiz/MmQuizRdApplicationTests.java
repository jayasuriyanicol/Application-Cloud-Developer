package it.demo.quiz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.demo.catalogo.entity.Domanda;
import it.demo.catalogo.entity.Risposta;
import it.demo.catalogo.entity.TipoDomanda;
import it.demo.catalogo.repository.CatalogoRepository;

@SpringBootTest
class MmQuizRdApplicationTests {

	@Autowired
	private CatalogoRepository daoD;
	
	@Test
	void testInsert() {
		Domanda d = new Domanda("capitale della Francia", 1, TipoDomanda.UNA_CORRETTA);
		d.addRisposta(new Risposta(1,"Roma","Roma è capitale dl'Italia", false));
		d.addRisposta(new Risposta(2,"Parigi","Parigi è corretta", true));
		d.addRisposta(new Risposta(3,"Berlino","Berlino è capitale della Germania", false));
		
		daoD.save(d);
	}

}
