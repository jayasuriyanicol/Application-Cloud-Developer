import React from 'react'
import { useState } from 'react'


const Termostato = () => {

const[temperatura, setTemperatura] = useState(0);


const Aumenta = () => {
    setTemperatura((indiceTemperatura)=> indiceTemperatura + 1); 
};

const Decrementa = () => {

    setTemperatura((indiceTemperatura) => {
        if (indiceTemperatura == 0) return indiceTemperatura;
        return indiceTemperatura - 1;
  
});
};

return (
    <div>
    <h1>Temperatura attuale è pari a {temperatura} GRADI</h1>

    

    <button onClick={Aumenta} > + </button>
    <button onClick={Decrementa}> - </button>
    </div>
);
};

export default Termostato;



/*Per l'avviamento in APP 

import React from "react";
import Termostato from "./Termostato";

function App() {
  return (
    <div>
      <Termostato />
    </div>
  );
}

export default App;



*/