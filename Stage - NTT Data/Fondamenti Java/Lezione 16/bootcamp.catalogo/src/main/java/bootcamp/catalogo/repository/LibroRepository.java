package bootcamp.catalogo.repository;

import java.util.List;
import java.util.Optional;

import bootcamp.catalogo.model.CategoriaLibro;
import bootcamp.catalogo.model.Libro;

public interface LibroRepository {

	Libro save(Libro libro);

	Optional<Libro> findById(Long id);

	List<Libro> findAll();

	List<Libro> findByCategoria(CategoriaLibro c);

	void deleteById(Long id);

	boolean existsById(Long id);
	

}
