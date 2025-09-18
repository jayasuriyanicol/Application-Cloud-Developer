import { useEffect,useState } from "react";



const AggiornaTitolo = () =>{

    const[nome, setNome] = useState ('');
    
    function mostraTesto(testoTempoReale){

        setNome(testoTempoReale.target.value);

    }
 useEffect(() =>{

    if (nome === ''){

        document.title = "Benvenuto ! ";
}else {
     document.title = "Ciao, " + nome + "!";
}});


return (

    <div>

        <input type="text" value={nome} onChange={mostraTesto} placeholder="Inserisci il NOME" />

        <p>
          {nome === '' ? "Benvenuto !" : "Ciao, " + nome + "!"}
        </p>

    </div>
);
};


export default AggiornaTitolo;




/*Per l'avviamento in APP 

import React from "react";
import AggiornaTitolo from "./AggiornaTitolo";

function App() {
  return (
    <div>
      <AggiornaTitolo />
    </div>
  );
}

export default App;



*/

