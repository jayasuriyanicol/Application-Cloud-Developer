import React from 'react';

function Componente1() {
  const nome = "Nicol";
  const cognome = "Jayasuriya";
  const impiego = "Studente";

  return (
    <div>
      <h2>Informazioni Utente</h2>
      <p><strong>Nome:</strong> {nome}</p>
      <p><strong>Cognome:</strong> {cognome}</p>
      <p><strong>Professione:</strong> {impiego}</p>
    </div>
  );
}

export default Componente1;
