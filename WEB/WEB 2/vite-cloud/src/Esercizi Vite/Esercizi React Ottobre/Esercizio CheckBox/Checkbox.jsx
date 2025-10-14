import React from "react";
import { useState,useEffect } from 'react';


const Checkbox = () => {
  const tecnologie = [
    { id: 1, name: "JavaScript" },
    { id: 2, name: "React" },
    { id: 3, name: "Vue" },
    { id: 4, name: "Angular" },
    { id: 5, name: "TypeScript" },
    { id: 6, name: "Node.js" },
    { id: 7, name: "PHP" },
    { id: 8, name: "Laravel" },
    { id: 9, name: "WordPress" },
    { id: 10, name: "CSS/SASS" }
  ];


  const [oggettoSelezionato, setOggettoSelezionato] = useState([]);

  const gestioneCheckBox = (id) => {
    let oggettiSelezionati = [];
    let oggettoTrovato = false;

    for (let i = 0; i < oggettoSelezionato.length; i++) {
      if (oggettoSelezionato[i] === id) {
        oggettoTrovato = true; 
      } else {
        oggettiSelezionati.push(oggettoSelezionato[i]);
      }
    }

    if (!oggettoTrovato) {
      oggettiSelezionati.push(id);
    }

    setOggettoSelezionato(oggettiSelezionati);
  };

useEffect (() =>{
    

if (oggettoSelezionato.length > 5){
    alert("ATTENZIONE ! Hai selezionato più di 5 skills !");}},[oggettoSelezionato]); 



const mostraSelezioni = () => {
    if (oggettoSelezionato.length > 0) {
      return oggettoSelezionato.length + " / 10";
    } else {
      return "Nessuna Selezione";
    }
  };


const riepilogo = () =>{
    
    let nomiSkills = [];
    for (let i =0; i <tecnologie.length; i++){
        for (let j=0; j< oggettoSelezionato.length; j++){
            
            if (tecnologie[i].id === oggettoSelezionato[j]){

                nomiSkills.push(tecnologie[i].name);
            }
        }
    }

        return nomiSkills;

};

const resetSelezioni = () => {
    setOggettoSelezionato([]);
}
  return (
    <div>
        <h3><b>ESERCIZIO Checkbox</b> - Ottobre 2025</h3>
        <br></br>
        <br></br>
      <ul>
        {tecnologie.map(tecnologia => (
          <li key={tecnologia.id}>
            <label
            style={{
            backgroundColor: oggettoSelezionato.includes(tecnologia.id)
                  ? "#d0f0c0"
                  : "transparent",
                padding: "2px 5px",
                borderRadius: "3px",
                display: "inline-block"
              }}>
              <input
                type="checkbox"
                checked={oggettoSelezionato.includes(tecnologia.id)}
                onChange={() => gestioneCheckBox(tecnologia.id)}
              />
              {tecnologia.name}
            </label>
          </li>
        ))}
      </ul>

<p
        style={{
          color: oggettoSelezionato.length > 5 ? "red" : "black",
        }} >

<br></br>
Selezionate: <b>{mostraSelezioni()}</b></p>

<br></br>
<p>RIEPILOGO Skills selezionate:  <b>{riepilogo().length > 0 ? riepilogo().join(", ") : "Nessuna Selezione"}</b></p>

<div style={{textAlign:"center",marginTop:"10px"}}>
<button onClick={resetSelezioni} >Reset</button>
</div>



    </div>
  );
};

export default Checkbox;
