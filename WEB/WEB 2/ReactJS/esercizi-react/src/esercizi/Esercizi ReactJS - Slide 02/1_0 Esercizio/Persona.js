import React from 'react';

{/*
1- Scrivere un componente Persona che mostri a video i dati anagrafici contenuti in
un oggetto persona. Formattare il layout con bootstrap
*/ }


function Persona() {

  const persona = {

    nomeCompleto: 'Shane Nicol',
    cognomeCompleto: 'Jayasuriya Kuranage Perera',
    eta: '21 anni',
    indirizzoResidenza: 'Via Cesare Pavese, 305',
    indirizzoemail: 'jayasuriyanicol28@gmail.com'
};

return (
    <div className="container mt-4">
      <div className="card p-4 shadow-sm">
        <h3>Dati Anagrafici</h3> <br></br>
        <ul className="list-group">
          <li className="list-group-item"><strong>Nome Completo:</strong> {persona.nomeCompleto}</li>
          <li className="list-group-item"><strong>Cognome Completo:</strong> {persona.cognomeCompleto}</li>
          <li className="list-group-item"><strong>Età:</strong> {persona.eta}</li>
          <li className="list-group-item"><strong>Email:</strong> {persona.indirizzoemail}</li>
          <li className="list-group-item"><strong>Indirizzo di Residenza:</strong> {persona.indirizzoResidenza}</li>
        </ul>
      </div>
    </div>
  );
}

export default Persona;













