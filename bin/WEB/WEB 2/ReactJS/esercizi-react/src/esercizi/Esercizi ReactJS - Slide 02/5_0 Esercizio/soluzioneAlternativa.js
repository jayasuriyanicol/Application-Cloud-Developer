// Definizione della classe
class Libro {
  constructor(nome, autore, id) {
    this.id = id;
    this.nome = nome;
    this.autore = autore;
  }
}

// Array iniziale di libri
let libri = [
  new Libro("Divina Commedia", "Dante Alighieri", "DADIVCOMM"),
  new Libro("Libro", "Qualcuno", "AAAA"),
];

// Funzione per aggiungere un libro
function addBook(nome, autore, id) {
  alert("Libro inserito");
  libri.push(new Libro(nome, autore, id));
  console.log(libri);
}

// Componente lista libri
const BookList = () => {
  return (
    <ul>
      {libri.map((book) => (
        <li key={book.id}>
          {book.nome} - {book.autore}
        </li>
      ))}
    </ul>
  );
};

// Componente per aggiunta libro (usa solo nome come esempio)
const AddBookForm = () => {
  return (
    <>
      <input type="text" id="nome" />
      <button
        onClick={() =>
          addBook(
            document.getElementById("nome").value,
            "Autore Sconosciuto",
            Date.now().toString()
          )
        }
      >
        Form inserimento libro
      </button>
    </>
  );
};

// Componente principale
export const Biblioteca = () => {
  return (
    <>
      <BookList />
      <AddBookForm />
    </>
  );
};

export default Biblioteca;
