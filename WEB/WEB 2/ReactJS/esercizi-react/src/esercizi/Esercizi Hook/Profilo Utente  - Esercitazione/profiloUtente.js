/*Disattivo gli import dato che rapprensentano 3 warninbg nel sistema poichè non utilizzati qui ma solo sul main.js
import react from "react"
import { useState } from "react"
import { utenti } from "./data";
*/




const ProfiloUtente = ({utentePuntatore}) => {

  const mostraDettagliUtente = () => {

    alert(`Il numero identificativo dell'utente: ${utentePuntatore.id}

    Di seguito i dettagli d'identificazione dell'UTENTE:

    Nome:  ${utentePuntatore.nome}
    Cognome: ${utentePuntatore.cognome}
    Professione: ${utentePuntatore.professione}
    Età: ${utentePuntatore.eta}  
    Email: ${utentePuntatore.email}`);

   };



return (
   

<div className="card h-100">
  <div className="card-header text-center">

   <h5>Utente: {utentePuntatore.cognome} {utentePuntatore.nome}</h5>

  <p>Nome: {utentePuntatore.nome} {utentePuntatore.cognome}</p>
  <p>Età: {utentePuntatore.eta} anni</p>
  <p>Professione: {utentePuntatore.professione}</p>
  <p>Indirizzo Email: {utentePuntatore.email}</p>

  </div>
  <div className="card-body text-center">
  
  </div>
  <div className="card-footer text-center">
   <button onClick={(mostraDettagliUtente)}> Mostra Dettagli</button>
  </div>
</div>


);
};

export default ProfiloUtente;
