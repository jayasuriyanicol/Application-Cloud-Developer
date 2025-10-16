import React from "react";
import { useState } from "react";


const SelettorePizza = () =>{


    const [pizzaSelezionata, setPizzaSelezionata] = useState("Nessuna Pizza Selezionata") 


    function gestionePizze(event){

        setPizzaSelezionata(event.target.value)

    }


    return(

        <div>
        
        <h3>ESERCIZIO NUMERO 4 - SELETTORE PIZZE</h3>

        <select value={pizzaSelezionata} onChange={gestionePizze}>

            <option value={ "Margherita"}>Margherita</option>
            <option value={ "Diavola"}>Diavola</option>
            <option value={  "Capricciosa"}> Capricciosa </option>
            <option value={ "Patate"}> Patate </option>
            <option value={  "Marinara"}> Marinara </option>
        </select>
       
       <div>Hai scelto: <b>{pizzaSelezionata}</b></div>
        </div>

    
    )



}

export default SelettorePizza;