import React, { useState } from "react";


const Form = () => {
  
  /*const [nome,setNome] = useState ("Nicol") // Inserimento nelle parentesi già da la parte compilatra dei form
  const[cognome, setCognome]= useState ("Jayasuriya") */


  const[persona, setPersona] = useState({
      noem: "",
      cognome: ""
  }); 
  const gestioneDati=(eventoDato)=>{
    eventoDato.preventDefault();
    if (nome && cognome){
      setPersone(
        ...persona,
       {

        /*
        nome, // sarebbe come "nome": nome
        cognome*/
        ...persona
       }
      )
      setNome("");
      setCognome("");
    }else{
      alert("Compila tutti i campi !")

    
  }
};

const handler=(eventoDato)=>{
   const{name,value} = eventoDato.target
   setPersona({ ...persona,[name]:value})

}

  return (

<div className="container border py-3" onSubmit={gestioneDati}>
      <form className="row g-3">
        <div className="col-md-6">
          <label htmlFor="inputNome" className="form-label">Nome</label>
          <input type="text" value={nome} onChange={(eventoDato) =>{setNome(eventoDato.target.value)}}className="form-control" id="inputNome" />
        </div>
<div className="col-md-6">
          <label htmlFor="inputCognome" className="form-label">Cognome</label>
          <input type="text" value={cognome} onChange={(eventoDato) =>{setCognome(eventoDato.target.value)}} className="form-control" id="inputCognome" />
        </div>
        <div className="col-12">
          <button type="submit" className="btn btn-primary">Invia</button>
        </div>
      </form>
    </div>
   {
    persone.map((p,index) =>{
      return (<h3 key={index}>{p.nome}{p.cognome} </h3>)
    })


}

export default Form