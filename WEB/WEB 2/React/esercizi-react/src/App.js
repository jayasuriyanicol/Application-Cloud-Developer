
import React, { useState } from 'react';
import Componente1 from './Componente1';
import Clock from './Clock';

function getDate(date) {
  return date.toLocaleDateString() + " " + date.toLocaleTimeString();
}

let nome = "Nicol";

function App() {
  const [messaggio, setMessaggio] = useState("");
  const now = new Date();

  const saluta = () => {
    setMessaggio("Ciao " + nome + "!");
  };

  return (
    <div className="App container text-center mt-5">
      <Componente1 nome="Nicol" cognome="Jayasuriya" eta="21" />
      <Componente1 nome="Nathan" cognome="Mbuyamba" eta="21" />
      <Componente1 nome="Michael" cognome="Baciarello" eta="21" />

      <h1>Prima App React, benvenuto {nome}!</h1>

      <h2>{getDate(now)}</h2>

      <Clock timezone="0" country="Italia" />
      <Clock timezone="-6" country="USA" />
      <Clock timezone="7" country="Japan" />

      <button className="btn btn-primary mt-3" onClick={saluta}>
        Salutami
      </button>

      {/* Messaggio dinamico */}
      {messaggio && <p className="mt-3">{messaggio}</p>}
    </div>
  );
}

export default App;

