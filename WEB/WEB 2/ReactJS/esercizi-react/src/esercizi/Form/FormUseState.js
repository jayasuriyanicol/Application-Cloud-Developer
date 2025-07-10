import React, { useState } from "react";

const Form = () => {
    //const [nome, setNome] = useState("");
    //const [cognome, setCognome] = useState("");
    const [persona, setPersona] = useState({
        nome: "",
        cognome: ""
    });
    const [persone, setPersone] = useState([])
    const gestioneDati = (e) => {
        e.preventDefault();
        if (persona.nome && persona.cognome) {
            setPersone([
                ...persone,
                {
                    ...persona
                }
            ])

        } else {
            alert("Compila tutti i campi");
        }
    };
    const handler = (e) => {
        const { name, value } = e.target
        setPersona({ ...persona, [name]: value })

    }

    return (
        <div className="container border py-3" onSubmit={gestioneDati}>
            <form className="row g-3">
                <div className="col-md-6">
                    <label htmlFor="inputNome" className="form-label">
                        Nome
                    </label>
                    <input
                        type="text"
                        value={persona.nome}
                        onChange={handler}
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
                        value={persona.cognome}
                        onChange={handler}
                        className="form-control"
                        id="inputCognome"
                        name="cognome"
                    />
                </div>
                <div className="col-12">
                    <button type="submit" className="btn btn-primary">
                        Invia
                    </button>
                </div>
            </form>
            <div>
                {
                    persone.map((p, index) => {
                        return (<h3 key={index}>{p.nome} {p.cognome}</h3>)
                    })
                }
            </div>
        </div>
    );
};

export default Form;