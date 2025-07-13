import React, { useState, useRef } from "react";

const UserForm = () => {

  const idRef = useRef(null);
  const nomeRef = useRef(null);
  const cognomeRef = useRef(null);
  const emailRef = useRef(null);
  const numeroRef = useRef(null);
  const [persone, setPersone] = useState([]);


  const gestioneDati = (e) => {
    e.preventDefault();

    const id = idRef.current.value;
    const nome = nomeRef.current.value;
    const cognome = cognomeRef.current.value;
    const email = emailRef.current.value;
    const numero = numeroRef.current.value;

    if (id && nome && cognome && email && numero) {
      setPersone([
        ...persone,
        {
          id,
          nome,
          cognome,
          email,
          numero
        }
      ]);

      // Successivo ad invio continuo nell'azzerare i campi inseriti precedentemente
      idRef.current.value = "";
      nomeRef.current.value = "";
      cognomeRef.current.value = "";
      emailRef.current.value = "";
      numeroRef.current.value = "";
    } else {
      //Nel caso in cui uno o più campi non sono compilati correttamente
      alert("Compila tutti i campi");
    }
  };

  return (
    <div className="container border py-3">
      <form className="row g-3" onSubmit={gestioneDati}>
        <div className="col-md-6">
          <label htmlFor="inputId" className="form-label">
            ID
          </label>
          <input
            type="text"
            ref={idRef}
            className="form-control"
            id="inputId"
            name="id"
          />
        </div>

        <div className="col-md-6">
          <label htmlFor="inputNome" className="form-label">
            Nome
          </label>
          <input
            type="text"
            ref={nomeRef}
            className="form-control"
            id="inputNome"
            name="nome"
          />
        </div>

        <div className="col-md-6">
          <label htmlFor="inputCognome" className="form-label">
            Cognome
          </label>
          <input
            type="text"
            ref={cognomeRef}
            className="form-control"
            id="inputCognome"
            name="cognome"
          />
        </div>

        <div className="col-md-6">
          <label htmlFor="inputEmail" className="form-label">
            Email
          </label>
          <input
            type="text"
            ref={emailRef}
            className="form-control"
            id="inputEmail"
            name="email"
          />
        </div>

        <div className="col-md-6">
          <label htmlFor="inputNumero" className="form-label">
            Numero
          </label>
          <input
            type="text"
            ref={numeroRef}
            className="form-control"
            id="inputNumero"
            name="numero"
          />
        </div>

        <div className="col-12">
          <button type="submit" className="btn btn-primary">
            Invia
          </button>
        </div>
      </form>

      <div className="mt-4">
        {persone.map((p, index) => (
          <h3 key={index}>
            {p.id} {p.nome} {p.cognome} {p.email} {p.numero}
          </h3>
        ))}
      </div>
    </div>
  );
};

export default UserForm;
