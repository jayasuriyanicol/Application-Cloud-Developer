/*ESERCIZIO numero 1:

Creare un componente che rappresenta per la mia applicazione un  contatore utilizzando useState con un valore di default uguale a zero.
Sotto il contatore andiamo a creare due bottoni, uno <<diminuisci>> ed uno <<aumenta>> che al loro click andranno ad aumentare e a 
diminuire il valore del contatore.


Utilizzando bootstrap per rendere gradevole il nostro componente (a nostro piacimento)

*/

import React from "react"
import { useState } from "react"



function contatore = () => { 
    
    const [contare, setContatore] = useState = 0
    
    return (

        <div> 
        <button onClick={() => setContatore(contare + 1)}

        
        </div>
    )







};