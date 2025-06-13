import React from 'react';


const Componente1 = (props) => {
 
  console.log(props);

const persona1={

  nome:"Nicol",
  cognome: "Jayasuriya",
  eta: 21
}

const persona2={

  nome:"Nathan",
  cognome: "Mbuyamba",
  eta: 21
}

const persona3={

  nome:"Michael",
  cognome: "Baciarello",
  eta: 21
}


const full_name = ()=> {
  return props.nome+" " + props.cognome;

}
  return (

     //Visualizzerò il mesaggio con i vari nomi che ho inserito nella variabile "Componente"
     //Posso utilizzare la fragment in due tipologie => 1. <> </> oppure 2. <React.Fragment> </React.Fragment>  

    <React.Fragment>

  
     <div>Componente di {full_name()} di eta {props.eta} </div>
   {/*Inseriamo per ogni componente l'anagrafica relativa*/ }
    <Anagrafica> </Anagrafica>
    <Messaggio></Messaggio>
    </React.Fragment> 
  
  );
};
{/*Creiamo una componente Anagrafica per ogni componente "Persona" */}
const Anagrafica=()=>{
  return (<div>Anagrafica</div>)
}
const Messaggio=()=>{
  return (<div>Anagrafica</div>)
}
export default Componente1