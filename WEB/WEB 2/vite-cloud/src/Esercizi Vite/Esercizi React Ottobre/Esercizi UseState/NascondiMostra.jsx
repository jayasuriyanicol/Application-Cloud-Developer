import React from "react";
import { useState } from "react";


const NascondiMostra = () =>{

const [mostraTesto, setMostraTesto] =  useState (false)


function mostraContenuto  (){

    setMostraTesto(!mostraTesto)


}


return(


    <div>

        <h1>Esercizio Numero 1</h1> <h3><b>Mostra e Nascondi Bottone</b></h3>


        <br></br>


        <button onClick={mostraContenuto}>

           {mostraTesto ?  "Nascondi" : "Mostra"}
        </button>

        {mostraTesto && <p>Primo esercizio BASE SU REACT !</p>}

    </div>


)
}
 export default NascondiMostra;