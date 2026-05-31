import React from "react";
import { useState } from "react";


const EchoInput = () =>{


    const [testo,setTesto] = useState ("Scrivi qui il tuo testo")


    function gestioneTesto (event){

        setTesto(event.target.value)
    };


    return (


        <div>

            <h3>ESERCIZIO NUMERO 3</h3> <h3>ECHO INPUT</h3>
            <input style={{textAlign:"center"}} value={testo} onChange={gestioneTesto}></input>

            <div>Hai scritto: <b>{testo}</b></div>
        </div>

    )

}


export default EchoInput;