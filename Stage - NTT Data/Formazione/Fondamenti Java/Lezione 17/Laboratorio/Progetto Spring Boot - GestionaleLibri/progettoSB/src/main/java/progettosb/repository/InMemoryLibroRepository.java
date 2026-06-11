package progettosb.repository;

import org.springframework.stereotype.Repository;
import progettosb.model.CategoriaLibro;
import progettosb.model.Libro;
import progettosb.repository.LibroRepository;

import java.util.*;

@Repository
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
