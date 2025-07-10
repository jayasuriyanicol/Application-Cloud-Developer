import React from "react";
import ProfiloUtente from "./esercizi/Eserrcizi Hook/Profilo Utente  - Esercitazione/profiloUtente";
import { utenti } from "./esercizi/Eserrcizi Hook/Profilo Utente  - Esercitazione/data";


const App = () => {

  /*Data la funzione della suddivisone, che ho trovato troppo complicata ho deciso di suddividere ogni "card" 
    attraverso due row. Nella prima row ho inserito le prime tre card mentre nella seconda l'ultima card con l'utente presente nell'array */

  return (
    <>
    <h5 className="text-center"> Anagrafica Utenti </h5>
  
    <br></br>
    <div className="container">
      <div className="row">
        <div className="col-md-4">
          <ProfiloUtente utentePuntatore={utenti[0]} />
        </div>
        <div className="col-md-4">
          <ProfiloUtente utentePuntatore={utenti[1]} />
        </div>
        <div className="col-md-4">
          <ProfiloUtente utentePuntatore={utenti[2]} />
        </div>
      </div>
    

      <div className="row mt-4">
        <div className="col-md-4">
          <ProfiloUtente utentePuntatore={utenti[3]} />
        </div>
      </div>
    </div>
    </>
    
     
  );
};

export default App;
