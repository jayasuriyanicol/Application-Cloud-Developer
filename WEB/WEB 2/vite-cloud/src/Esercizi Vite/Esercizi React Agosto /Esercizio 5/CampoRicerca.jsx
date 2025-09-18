import { useState } from "react";


const CampoRicerca= () => {


    const [testoRicerca, setTestoRicerca]= useState('') 

    function cambiamentoRealeTesto(cambiamentoTempoReale){ 

        setTestoRicerca(cambiamentoTempoReale.target.value)
    }

    return(

        <div>

            <input type="text" value={testoRicerca} onChange={cambiamentoRealeTesto} />

            <p>Benvenuto, attualmente stai scrivendo: {testoRicerca}</p>

            <button onClick={ () => setTestoRicerca('') }>

                Resetta Casella Testo
            </button>
        </div>
    );
};


export default CampoRicerca;



/*Per l'avviamento in APP 

import React from "react";
import CampoRicerca from "./CampoRicerca";

function App() {
  return (
    <div>
      <CampoRicerca />
    </div>
  );
}

export default App;



*/