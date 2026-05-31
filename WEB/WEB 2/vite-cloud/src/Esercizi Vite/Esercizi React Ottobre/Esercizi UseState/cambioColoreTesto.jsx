import React from "react";
import { useState } from "react";


const CambioColoreTesto = () =>{


    const[cambioColore, setCambioColore] = useState ("black")
    
    return (

        <div>

            <h1>Esercizio Numero 2</h1> <h3><b> Cambia Colore Testo</b></h3>
        <br></br>
        <h1 style={{color :cambioColore }}>Ciao Mondo !</h1>

        <button style={{background:"red"}} onClick={() => setCambioColore("red")}>Rosso</button>

        <button style={{background:"green"}} onClick={() => setCambioColore("green")}>Verde</button>

        <button style={{background:"blue"}} onClick={() => setCambioColore("blue")}>Blu</button>
        </div>

        
    )


}

export default CambioColoreTesto