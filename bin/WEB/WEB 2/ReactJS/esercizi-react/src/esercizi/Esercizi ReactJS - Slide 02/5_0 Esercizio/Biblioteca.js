/*
5- Creare un componente Biblioteca che visualizza una lista di libri e permette agli utenti di aggiungere un nuovo libro alla lista.

1.Componente Biblioteca: Il componente principale che ospita gli altri componenti.

2.Componente BookList: Un componente che mostra la lista dei libri.

3. Componente AddBookForm: Un componente che al momento mostra solo la scritta ‘form inserimento libro’ 
con un pulsante che al click mostra un alert(‘libro inserito’) 

*/

import React from "react";
import BookList from "./BookList";
import AddBookForm from "./addBookForm";

let libri = [

    { titolo: "Il mio segreto - J.B.Cooper" },
    { titolo: "La storia dei 4 ragazzi" },
    { titolo: "Il mio nome è Diego !" }

];

function aggiungiLibro(titolo) {
  libri.push({ titolo });

  //Aggiungiamo la lista dei libri già esistenti nel DOM, creando prima la colonna e poi la riga per il nuovo libro passando come parametro il libro
  const ul = document.getElementById("lista-libri");
  const li = document.createElement("li");
  li.className = "list-group-item";
  li.textContent = titolo;
  ul.appendChild(li);

  alert("Libro inserito!");
}


function Biblioteca() {
  return (
    <div className="container mt-4">
      <h2>Biblioteca</h2>
      <BookList libri={libri} />
      <AddBookForm onAggiungiLibro={aggiungiLibro} />
    </div>
  );
}

export default Biblioteca;
