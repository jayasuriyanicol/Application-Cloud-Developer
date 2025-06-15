/*
5- Creare un componente Biblioteca che visualizza una lista di libri e permette agli utenti di aggiungere un nuovo libro alla lista.

1.Componente Biblioteca: Il componente principale che ospita gli altri componenti.

2.Componente BookList: Un componente che mostra la lista dei libri.

3. Componente AddBookForm: Un componente che al momento mostra solo la scritta ‘form inserimento libro’ 
con un pulsante che al click mostra un alert(‘libro inserito’) */


import React, { useState } from "react";
import BookList from "./BookList";
import AddBookForm from "./addBookForm";

function Biblioteca() {
  const [libri, setLibri] = useState([
    { titolo: "Il mio segreto - J.B.Cooper" },
    { titolo: "La storia dei 4 ragazzi" },
    { titolo: "Il mio nome è Diego !" }
  ]);

  const aggiungiLibro = (titolo) => {
    setLibri([...libri, { titolo }]);
  };

  return (
    <div className="container mt-4">
      <h2>Biblioteca</h2>
      <BookList libri={libri} />
      <AddBookForm onAggiungiLibro={aggiungiLibro} />
    </div>
  );
}

export default Biblioteca;
