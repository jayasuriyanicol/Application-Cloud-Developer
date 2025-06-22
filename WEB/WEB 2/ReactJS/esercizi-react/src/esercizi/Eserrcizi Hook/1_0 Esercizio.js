/*ESERCIZIO numero 1:
Creare un componente che rappresenta per la mia applicazione un  contatore utilizzando useState con un valore di default uguale a zero.
Sotto il contatore andiamo a creare due bottoni, uno <<diminuisci>> ed uno <<aumenta>> che al loro click andranno ad aumentare e a 
diminuire il valore del contatore.


Utilizzando bootstrap per rendere gradevole il nostro componente (a nostro piacimento)

*/

import React from "react"
import { useState } from "react"



const Contatore = () => { 
    
    const [contare, setContatore] = useState (0)
    
    return (

        <div className="container text-center mt-4"> 
        <h2 className="mb-4"> Contatore </h2>
         <p>Il contatore al momento è pari ad: <b>{contare}</b></p>
        <button onClick={() => setContatore(contare + 1)}>Aumento Contatore</button>
        <button onClick={ () => setContatore (contare -1 )}> Diminuire Contatore</button>
       
        </div>
      
       
    );
};

export default Contatore;