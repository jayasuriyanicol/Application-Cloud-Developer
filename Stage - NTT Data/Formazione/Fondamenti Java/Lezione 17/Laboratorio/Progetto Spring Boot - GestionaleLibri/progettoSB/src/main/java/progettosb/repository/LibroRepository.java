package progettosb.repository;

import org.springframework.stereotype.Repository;
import progettosb.model.CategoriaLibro;
import progettosb.model.Libro;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository {

        Libro save(Libro libro);

        Optional<Libro> findById(Long id);

        List<Libro> findAll();

        List<Libro> findByCategoria(CategoriaLibro c);

        void deleteById(Long id);

        boolean existsById(Long id);


    }

