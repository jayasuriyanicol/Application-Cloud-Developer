








import React, { useState } from 'react';
import Componente1 from './Componente1';
import Clock from './Clock';

function getDate(date) {
  return date.toLocaleDateString() + " " + date.toLocaleTimeString();
}

let nome = "Nicol";

function App() {
  const [messaggio, setMessaggio] = useState(""); // ⬅️ stato per il messaggio
  const now = new Date();

  const saluta = () => {
    setMessaggio("Ciao " + nome + "!");
    // console.log("Ciao " + nome); // facoltativo
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






























import logo from './logo.svg';
import './App.css';
import Componente1 from './Componente1'
import Clock from './Clock';

function getDate(date){
  return date.toLocaleDateString()+" "+date.toLocaleTimeString()
}
let nome="Nicol";

const saluta=(e) => {

  console.log(e)


}
function App() {
  return (
    <div className="App">
      
      <Componente1 nome="Nicol" cognome="Jayasuriya" eta="21"></Componente1>
      <Componente1 nome="Nathan" cognome="Mbuyamba" eta="21"></Componente1>
      <Componente1 nome="Michael" cognome="Baciarello" eta="21"></Componente1>

      <h1> Prima App React {nome}</h1>
      <h2>

       {
          new Date().toLocaleDateString()+" "+ new Date().toLocaleTimeString()

       }


      </h2> 


     {/*Possiamo iterarlo più volte*/}

     <Clock timezone= "0" country="Italia"></Clock>
     <Clock timezone= "-6" country="USA"></Clock>
     <Clock timezone= "7" country="Japan"></Clock>
     <button className='btn btn -primary' onClick={(e)=>saluta(e)}>Salutami</button>
    </div>
  );
}

export default App;

