package progettosb.mapper;

import org.springframework.stereotype.Component;
import progettosb.dto.LibroRequest;
import progettosb.dto.LibroResponse;
import progettosb.model.Libro;

import java.time.LocalDate;
import java.util.List;

@Component
public class LibroMapper {

    public Libro toModel(Long id, LibroRequest request) {


        return new Libro(

                id,
                request.titolo(),
                request.autore(),
                request.categoria(),
                request.pagine(),
                request.prezzo(),
                LocalDate.now()
        );
    }

    public LibroResponse toResponse(Libro libro) {


        return new LibroResponse(

                libro.getId(),
                libro.getTitolo(),
                libro.getAutore(),
                libro.getCategoria().name(),
                libro.getPagine(),
                libro.getPrezzo(),
                libro.getDataInserimento()
        );
    }


    public List<LibroResponse> toResponseList(List<Libro> libri) {
        if (libri == null) {
            return List.of();
        }

        return libri.stream()
                .map(this::toResponse)
                .toList();
    }
}
