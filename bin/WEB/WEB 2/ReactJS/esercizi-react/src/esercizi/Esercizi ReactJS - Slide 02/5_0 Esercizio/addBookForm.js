import React from "react";

function AddBookForm({ onAggiungiLibro }) {

  function handleClick() {

    const titolo = prompt("Inserisci il titolo del libro:");
    
    if (titolo) {
      onAggiungiLibro(titolo);
    }
  }

  return (
    <div className="mt-3">
      <button className="btn btn-success" onClick={handleClick}>
        Aggiungi libro
      </button>
    </div>
  );
}

export default AddBookForm;
