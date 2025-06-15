import React, { useState } from "react";

function AddBookForm({ onAggiungiLibro }) {
  const [titolo, setTitolo] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (titolo.trim()) {
      onAggiungiLibro(titolo);
      alert("Libro inserito");
      setTitolo("");
    }
  };

  return (
    <form onSubmit={handleSubmit} className="mt-3">
      <h4>Form inserimento libro</h4>
      <div className="input-group">
        <input
          type="text"
          value={titolo}
          onChange={(e) => setTitolo(e.target.value)}
          className="form-control"
          placeholder="Titolo del libro"
        />
        <button type="submit" className="btn btn-primary">
          Aggiungi
        </button>
      </div>
    </form>
  );
}

export default AddBookForm;
