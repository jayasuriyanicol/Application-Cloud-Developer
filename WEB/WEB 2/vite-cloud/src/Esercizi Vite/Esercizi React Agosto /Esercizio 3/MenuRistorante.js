import React from "react";
import {piatti} from "./piatti"



const MenuRistorante = () => {

    return (

        <ul>
          {piatti.map((piatto) =>(<li key= {piatto.id}>

            NOME PIATTO: {piatto.nome}
            PREZZO PIATTO: {piatto.prezzo} euro
          </li> ))}
        </ul>
    );
};


export default MenuRistorante;




/* Per l'avviamento in APP 



import React from "react";
import MenuRistorante from "./Esercizi Vite/Esercizi React Agosto /Esercizio 3/piatti";



function App (){

    return(

    <div>

        <MenuRistorante />
    </div>
    );

}


export default App;

*/