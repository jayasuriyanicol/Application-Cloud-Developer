import React from 'react';

function Componente1() {
  const nome = "Mario";
  const cognome = "Rossi";
  const rta = "React Trainer Assistant";

  return (
    <div>
      <h2>Informazioni Utente</h2>
      <p><strong>Nome:</strong> {nome}</p>
      <p><strong>Cognome:</strong> {cognome}</p>
      <p><strong>RTA:</strong> {rta}</p>
    </div>
  );
}

export default Componente1;
