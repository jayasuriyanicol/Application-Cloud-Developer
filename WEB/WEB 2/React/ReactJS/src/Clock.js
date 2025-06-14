import React from "react";

const Clock = (props) => {
    console.log(props.timezone, props.country)
    const t = Date.now()+3600*props.timezone*1000;

   {/* Attraverso il props proveniente da CHILD e richimando la funzione props.nome riusciremo a vedere il contenuto su console.*/}
    
    const NewTime = new Date(t);
   return (
     
  <h3>In {props.country} sono le {NewTime.toLocaleDateString()} del giorno {NewTime.toLocaleTimeString()}</h3>
 )

}

export default Clock

