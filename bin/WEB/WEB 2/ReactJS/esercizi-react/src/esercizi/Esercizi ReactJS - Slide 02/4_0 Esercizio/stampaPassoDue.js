import React from "react";

// 4 - Scrivere un programma che conta da 0 a 20 con passo 2

function StampaPassoDue() {
  const listaNumeriPassoDue = [];
  let contatore = 1;

  for (let i = 0; i <= 20; i += 2) {

    listaNumeriPassoDue.push(

      <li key={i} className="list-group-item">

        {contatore++} Numero = {i}

      </li>
    );
  }

  return (
    <div className="container mt-4">
      <div className="card shadow-sm">
        <div className="card-body">
          <h5 className="card-title">Numeri da 0 a 20 con passo 2</h5>
          <ul className="list-group">{listaNumeriPassoDue}</ul>
        </div>
      </div>
    </div>
  );
}

export default StampaPassoDue;
