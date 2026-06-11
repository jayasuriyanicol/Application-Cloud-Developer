package bootcamp.catalogo;

import bootcamp.catalogo.dto.LibroRequest;
import bootcamp.catalogo.dto.LibroResponse;
import bootcamp.catalogo.exception.LibroNonTrovatoException;
import bootcamp.catalogo.mapper.LibroMapper;
import bootcamp.catalogo.model.CategoriaLibro;
import bootcamp.catalogo.model.Libro;
import bootcamp.catalogo.repository.InMemoryLibroRepository;
import bootcamp.catalogo.repository.LibroRepository;
import bootcamp.catalogo.service.LibroService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibroServiceTest {

    private LibroService service;
    private LibroRepository repo;

    @BeforeEach
    void inizializzazione() {
        
        repo = new InMemoryLibroRepository();
        LibroMapper libroMapper = new LibroMapper();
        service = new LibroService(repo, libroMapper);
    }

    @Test
    void creaLibro() {
      
        LibroRequest r = new LibroRequest("TITOLO", "AUTORE", CategoriaLibro.PROGRAMMAZIONE, 21, 22.00);

        LibroResponse lr = service.creaLibro(r);

  
        assertNotNull(lr.id(), "ATTENZIONE ! l'ID dovrebbe essere generato dal sistema");
        assertEquals("TITOLO", lr.titolo());
        assertEquals("AUTORE", lr.autore());
        assertEquals(CategoriaLibro.PROGRAMMAZIONE, lr.categoria());
        assertEquals(21, lr.pagine());
        assertEquals(22.00, lr.prezzo());
        assertNotNull(lr.dataInserimento(), "ATTENZIONE ! La data di inserimento deve essere presente");
    }

    @Test
    void creaLibroTitoloVuoto() {

        LibroRequest ri = new LibroRequest("", "AUTORE", CategoriaLibro.PROGRAMMAZIONE, 21, 22.00);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            service.creaLibro(ri);
        });

     
        assertTrue(e.getMessage().contains("titolo"));
    }

    @Test
    void trovaPerId() {
  
        LibroRequest r = new LibroRequest("Il Titolo", "Pirandello", CategoriaLibro.NARRATIVA, 121, 20.50);
        LibroResponse ls = service.creaLibro(r);

      LibroResponse libroTrovato = service.trovaPerId(ls.id());

      
        assertNotNull(libroTrovato);
        assertEquals(ls.id(), libroTrovato.id());
        assertEquals("Il Titolo", libroTrovato.titolo()); 
    }

    @Test
    void trovaPerIdInesistente() {
        
        assertThrows(LibroNonTrovatoException.class, () -> {
            service.trovaPerId(999L);
        });
    }

    @Test
    void trovaLibriCostosi() {
       
    	LibroRequest r1 = new LibroRequest("PRIMO", "IO", CategoriaLibro.ALTRO, 32, 2.00);
    	LibroRequest r2 = new LibroRequest("SECONDO", "TE", CategoriaLibro.SAGGISTICA, 500, 102.00);
    	
    	
        service.creaLibro(r1);
        service.creaLibro(r2);

        
        List<LibroResponse> libriCostosi = service.trovaLibriCostosi(50.0);

      
        assertEquals(1, libriCostosi.size(), "ATTENZIONE ! Dovrebbe esserci un solo libro costoso");
        assertEquals("SECONDO", libriCostosi.get(0).titolo());
    }

    @Test
    void rimuoviPerId() {
       
    	LibroRequest r = new LibroRequest("Titolo", "Autore", CategoriaLibro.SAGGISTICA, 200, 20.00);
        LibroResponse l = service.creaLibro(r);
        Long idRimosso = l.id();
        
        
        service.rimuoviPerId(idRimosso);

       
        assertThrows(LibroNonTrovatoException.class, () -> {
            service.trovaPerId(idRimosso);
        });
    }
}
