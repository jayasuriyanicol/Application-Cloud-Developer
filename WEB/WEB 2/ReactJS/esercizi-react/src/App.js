import React, { useState } from "react";
import { posts } from "./esercizi/dati";


const Card = ({ titolo, descrizione, coloreCard }) => {
  return (
    <div className={"p-4 rounded-xl shadow-md mb-4 " + coloreCard}>
      <h2 className="text-xl font-bold">{titolo}</h2>
      <p>{descrizione}</p>
    </div>
  );
};

const NewsComponente = () => {
  
  const [modalitaScura, setModalitaScura] = useState(false);
  const [coloreCard, setColoreCard] = useState("bg-white text-black");
  const [mostraNews, setMostraNews] = useState(true);

  const cambiaTemaSfondo = () => setModalitaScura(modalitaNormale => !modalitaNormale);

  const cambiaTemaCard = () =>
    setColoreCard(modalitaNormale =>
      modalitaNormale === "bg-white text-black"
        ? "bg-gray-800 text-white"
        : "bg-white text-black"
    );

  const cambiaVisibilita = () => setMostraNews(modalitaNormale => !modalitaNormale);
 
  return (
    <div
      className={
        (modalitaScura ? "bg-black text-white" : "bg-white text-black") +
        " min-h-screen p-6"
      }
    >
      <h1 className="text-3xl font-bold mb-6">Elenco News</h1>

      <div className="space-x-4 mb-6">
        <button
          onClick={cambiaTemaSfondo}
          className="px-4 py-2 bg-blue-600 text-white rounded"
        >
          {modalitaScura ? "Tema Chiaro" : "Tema Scuro"}
        </button>
        <button
          onClick={cambiaTemaCard}
          className="px-4 py-2 bg-green-600 text-white rounded"
        >
          Cambia Colore Card
        </button>
        <button
          onClick={cambiaVisibilita}
          className="button bng"
        >
          {mostraNews ? "Nascondi News" : "Visualizza News"}
        </button>
      </div>

      {mostraNews &&
        posts.map(({ id, titolo, descrizione }) => (
          <Card
            key={id}
            titolo={titolo}
            descrizione={descrizione}
            coloreCard={coloreCard}
          />
        ))}
    </div>
  );
};

export default NewsComponente;
