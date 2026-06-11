package bootcamp.catalogo.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import bootcamp.catalogo.model.CategoriaLibro;
import bootcamp.catalogo.model.Libro;
public class InMemoryLibroRepository implements LibroRepository {
	
	
	private final Map<Long, Libro> archivio = new HashMap<>();

	@Override
	public Libro save(Libro libro) {
		
		archivio.put(libro.getId(), libro);
		
		return libro;
	}

	@Override
	public Optional<Libro> findById(Long id) {
		
	    return Optional.ofNullable(archivio.get(id));
	}

	@Override
	public List<Libro> findAll() {
	
		return new ArrayList<>(archivio.values());
	}

	@Override
	public List<Libro> findByCategoria(CategoriaLibro c) {
		
		return archivio.values().stream()
				
				.filter(l -> l.getCategoria().equals(c))
				.toList();
	}

	@Override
	public void deleteById(Long id) {
		
		archivio.remove(id);
		
	}

	@Override
	public boolean existsById(Long id) {
		
		return archivio.containsKey(id);
	}
	
	
	
	
}
