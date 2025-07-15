import React, {useState} from "react"
import { posts } from "./dati"


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

  const cambiaTemaSfondo = () => setModalitaScura

  const cambiaTemaCard = () =>
    setColoreCard(prev =>
      prev === "bg-white text-black"
        ? "bg-gray-800 text-white"
        : "bg-white text-black"
    );

  const cambiaVisibilita = () => setMostraNews





  return(
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
  

