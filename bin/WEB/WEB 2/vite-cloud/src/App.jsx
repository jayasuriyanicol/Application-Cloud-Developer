import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import {useState} from 'react';

import Saluto from './Esercizi Vite/Esercizi React Agosto /Esercizio 1/Saluto';
import CardUtente from './Esercizi Vite/Esercizi React Agosto /Esercizio 2/CardUtente';
import MenuRistorante from './Esercizi Vite/Esercizi React Agosto /Esercizio 3/MenuRistorante';
import piatti from "./Esercizi Vite/Esercizi React Agosto /Esercizio 3/piatti";
import Termostato from './Esercizi Vite/Esercizi React Agosto /Esercizio 4/Termostato';
import CampoRicerca from './Esercizi Vite/Esercizi React Agosto /Esercizio 5/CampoRicerca';
import MessaggioSegreto from './Esercizi Vite/Esercizi React Agosto /Esercizio 6/MessaggioSegreto';
import AggiornaTitolo from './Esercizi Vite/Esercizi React Agosto /Esercizio 7/AggiornaTitolo';
import GalleriaFoto from './Esercizi Vite/Esercizi React Agosto /Esercizio 8/GalleriaFoto';
import ModuloContatti from './Esercizi Vite/Esercizi React Agosto /Esercizio 9/ModuloContatti';
import BlogApp from './Esercizi Vite/Esercizi React Agosto /Esercizio 10/BlogApp';
import TodoApp from './Esercizi Vite/Esercizi React Agosto /Esercizio 11/TodoApp';

function App() {

  let [paginaCorrente, setValore] = useState(Saluto) 

  let NavbarTitles= ["Saluto", "CardUtente","MenuRistorante","Termostato","CampoRicerca",
                      "MessaggioSegreto","AggiornaTitolo","GalleriaFoto","ModuloContatti","BlogApp","ToDoApp"] 

  function impostaValore () {

    switch (paginaCorrente){

      case "Saluto":

      return(<Saluto/>)

      case "CardUtente":

      return (
          <>
            <CardUtente nome="Nicol" email="jayasuriyanicol28@gmail.com" imgUrl="https://placehold.co/600x400" />
            <CardUtente nome="Franco" email="franco@libero.it" imgUrl="https://placehold.co/250x600" />
          </>
        )
        case "MenuRistorante":
        return (
          <MenuRistorante />
        )

      case "Termostato":
        return (
          <Termostato />
        )

      case "CampoRicerca":
        return (
          <CampoRicerca />
        )

      case "MessaggioSegreto":
        return (
          <MessaggioSegreto />
        )

      case "AggiornaTitolo":
        return (
          <AggiornaTitolo />
        )

      case "GalleriaFoto":
        return (
          <GalleriaFoto />
        )

      case "ModuloContatti":
        return (
          <ModuloContatti />
        )

      case "BlogApp":
        return (
          <BlogApp />
        )

      case "ToDoApp":

      return(<TodoApp/>)
  }  }
  return (
  <>
    <nav className="navbar navbar-expand-lg bg-body-tertiary">
      <div className="container-fluid">
        <a className="navbar-brand" href="#">Esercizi React Agosto</a>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon" />
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav">
           
            
           {NavbarTitles.map((indice,chiave)=>{
            return(
              <li className="nav-item"key={chiave}>
              <a className="nav-link" href="#"onClick={()=>setValore(indice)}>{indice}</a>
            </li>

            )
           })}
        

          </ul>
        </div>
      </div>
    </nav>
    <div>{impostaValore()}</div>
 
  </>
  
  
)
}


 export default App;