import React, { useState } from "react";


const Form = () => {
  
  const [nome,setNome] = useState ("Nicol");
  const[cognome, setCognome]= useState ("Jayasuriya") 
  const gestioneDati=(eventoDato)=>{
    eventoDato.preventDefault();
    if (nome && cognome){
      setNome("");
      setCognome("");
    }else{
      alert("Compila tutti i campi !")

    
  }
};


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
  )

}

export default Form