package bootcamp.catalogo;

import java.util.List;

import bootcamp.catalogo.dto.LibroRequest;
import bootcamp.catalogo.dto.LibroResponse;
import bootcamp.catalogo.exception.LibroNonTrovatoException;
import bootcamp.catalogo.mapper.LibroMapper;
import bootcamp.catalogo.model.CategoriaLibro;
import bootcamp.catalogo.repository.InMemoryLibroRepository;
import bootcamp.catalogo.repository.LibroRepository;
import bootcamp.catalogo.service.LibroService;

public class Main {
	
	
	public static void main(String[] args) {
		
		
		LibroRepository repository = new InMemoryLibroRepository();
		
		LibroMapper mapper = new LibroMapper();
		
		LibroService service = new LibroService(repository, mapper);
		
		
		
		
		
		LibroRequest l1 = new LibroRequest("Giacomo e le sue avventure", "Cristiano Coccia", CategoriaLibro.NARRATIVA, 121, 30.99);
		LibroRequest l2 = new LibroRequest("Leandro e la sua pazienza ", "Lanto il Paziente", CategoriaLibro.SCENTIFICO, 67, 24.88);
		LibroRequest l3 = new LibroRequest("Assert False", "Fiutini Franco", CategoriaLibro.PROGRAMMAZIONE, 99, 35.99);
		
		
		
		LibroResponse lr1 = service.creaLibro(l1);
		LibroResponse lr2 = service.creaLibro(l2);
		LibroResponse lr3 = service.creaLibro(l3);
		
		
		System.out.println("\nSUCCESSO ! sono stati inseriti i seguenti libri: \n" + l1 +"\n\n" + l2 +"\n\n" + l3 +"\n\n");
		  
		
		
	   // TEST 2
	   try {
		   
		   service.creaLibro(new LibroRequest("", "Dockerina Hackerina", CategoriaLibro.PROGRAMMAZIONE, 99999, 99999.99));
	   }
	   catch(IllegalArgumentException e) {
		   
		   System.out.println("\nATTENZIONE ! ERRORE campo mancante\nERRORE: " + e.getMessage() + "\n");
		   
	   }
	   
	   // TEST 3
	   
	   LibroResponse libroRicercato  = service.trovaPerId(1L);
	   System.out.println("\nSUCCESSO ! Libro correttamente trovato.\nDETTAGLI :\n\n " + libroRicercato + "\n" );
	   
	   
	   // TEST 3
	   
	   try {
		 
		   service.trovaPerId(424L);
	   } catch(LibroNonTrovatoException e) {
		   
		   System.out.println("\nATTENZIONE ! ERRORE nel sistema \nERRORE: " + e.getMessage() + "\n");
		   
	   }
	   
	   
	   //TEST 4 
	   
	   List<LibroResponse> archivioLibri = service.trovaTutti();
	   
	   archivioLibri.forEach(System.out::println);
	   
	   System.out.println("\nTOTALE LIBRI: " + archivioLibri.size() + " libri") ;
	   
	   
	   
	   
	   // TEST 5 
	   
	   List<LibroResponse> libriNarrativa = service.trovaPerCategoria(CategoriaLibro.NARRATIVA);
	   
	   libriNarrativa.forEach(System.out::println);
	   
	   System.out.println("\nTOTALE LIBRI NARRATIVA: " + libriNarrativa.size() + " libri") ;
	   

	   // TEST 6
	   
	   List<LibroResponse> libriCostosi = service.trovaLibriCostosi(30.0); 
	   libriCostosi.forEach(System.out::println);
	   
	   System.out.println("\nTOTALE LIBRI COSTOSU: " + libriCostosi.size() + " libri") ;
	   
	   
	   
	   // TEST 7.1
	   
	   service.rimuoviPerId(1L);
	   System.out.println("\nSUCCESSO ! Libro rimosso.");
	   
	   
	   
	   // TEST 7.2 
	   
	   try {
		   
		  service.trovaPerId(1L); 
	   } catch (LibroNonTrovatoException e) {
		   
		   System.out.println( "\nATTENZIONE ! Libro non trovato");
		   
	   }
	   
	
	   


		
	}

}
