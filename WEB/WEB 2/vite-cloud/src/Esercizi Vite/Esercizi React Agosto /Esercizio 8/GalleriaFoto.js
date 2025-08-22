import { useEffect, useState } from "react";

const GalleriaFoto = () => {
  const [foto, setFoto] = useState([]);
  const [staCaricando, setStaCaricando] = useState(true);
  const [errore, setErrore] = useState(null);

  useEffect(() => {
    const prelievoFoto = async () => {
      try {
        const rispostaProgramma = await fetch("https://jsonplaceholder.typicode.com/photos?_limit=10");
        const dati = await rispostaProgramma.json();

        setFoto(dati);              
        setStaCaricando(false);
      } catch (erroreProgramma) {
        setErrore(erroreProgramma.messaggio);  
        setStaCaricando(false);
      }
    };

    prelievoFoto();
  }, []);

  if (staCaricando) {
    return <p>CARICAMENTO IN CORSO, per favore attendere...</p>;
  }

  if (errore) {
    return <p>Errore: {errore}</p>;
  }

  return (
    <div>
      <h2>FOTO DELLA GALLERIA</h2>
      {foto.map((fotoIndice) => (
        <div key={fotoIndice.id}>
          <img src={fotoIndice.thumbnailUrl} alt={fotoIndice.title} />
          <p>{fotoIndice.title}</p>
        </div>
      ))}
    </div>
  );
};

export default GalleriaFoto;
