import React from "react";


function CardUtente (props){

        return(

            <div>
                
            <h2>{props.nome}</h2>
            <p>{props.email}</p>
            <img src={props.imgUrl} alt="Avatar Utente" />

            </div>
        )
        }

export default CardUtente;


/*Per l'avviamento in APP

import CardUtente from "./Esercizi Vite/Esercizi React Agosto /Esercizio 2/CardUtente";


function App (){

  return (
    <div>
      <CardUtente
      nome="Nicol Jayasuriya"
      email="jayasuriyanicol28@gmail.com"
      imgUrl="https://palcehold.co/150x150"
      
      /> 

      <CardUtente
      nome="Cristiano Coccia"
      email="assertfalse89@gmail.com "
      imgUrl="https://palcehold.co/150x150"
      
      /> 

    </div>

  )

}

export default App;

*/