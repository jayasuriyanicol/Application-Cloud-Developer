import {useState} from "react";

const MessaggioSegreto = () => {

    const[mostra, setMostra] = useState(false)
    
    function tastoPremuto(){
        setMostra(!mostra)
    }

    return(


        <div>
            <button onClick={tastoPremuto}>

               {mostra ? "Nascondi il Messaggio Segreto" : "Mostra il Messaggio Segreto"}

            </button>

           {mostra && <p>Questo è il MESSAGGIO SEGRETO: 1234</p>}
        </div>
    );


};

export default MessaggioSegreto;





/*Per l'avviamento in APP 

import React from "react";
import MessaggioSegreto from "./MessaggioSegreto";

function App() {
  return (
    <div>
      <MessaggioSegreto />
    </div>
  );
}

export default App;



*/