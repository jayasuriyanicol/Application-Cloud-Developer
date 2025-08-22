import { useState } from "react";


const ModuloContatti = () => {
  const [datiPersonali, setDatiPersonali] = useState({
    nome: "",
    email: "",
    messaggio: ""
  });

  
  function gestioneCampiForm(gestioneEvento) {

    const { name, value } = gestioneEvento.target; 
    setDatiPersonali({
      ...datiPersonali,
      [name]: value
    });
  }

  
  function invioDati(gestioneEvento) {

    gestioneEvento.preventDefault();
    console.log("Dati inviati:", datiPersonali);

  }

  return (

    <form onSubmit={invioDati}>
      
      <div>

        <label>Nome: </label>
        <input type="text" name="nome" value={datiPersonali.nome} onChange={gestioneCampiForm}/>
      
      </div>


      <div>

        <label>Email: </label>
        <input type="text" name="email" value={datiPersonali.email} onChange={gestioneCampiForm}/>
      
      </div>

       <div>

        <label>Messaggio: </label>
        <textarea name="messaggio" value={datiPersonali.messaggio} onChange={gestioneCampiForm}/>
      
      </div>

      <button type="submit">Invia i DATI</button>

    </form>
  );
};

export default ModuloContatti;




/*Per l'avviamento in APP 

import React from "react";
import ModuloContatti from "./ModuloContatti";

function App() {
  return (
    <div>
      <ModuloContatti />
    </div>
  );
}

export default App;


*/




*