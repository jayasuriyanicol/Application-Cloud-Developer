import React, { useEffect, useState } from "react";

const EsempioUseEffect = () => {
    const [valore, setValore] = useState(0);

    const funzio = () => {
        console.log("Funziona");
    };

    useEffect(funzio, []);

    useEffect(() => {
        if (valore < 1) {
            document.title = "Nessun valore";
        } else {
            document.title = "C'è qualcosa ...";
        }
        console.log("Chiamato useEffect");

        return () => {
            console.log("Chiamata funzione CleanUp !");
        };
    }, [valore]);

    console.log("Fuori dallo useEffect");

    return (
        <>
            <div>Esempio useEffect</div>
            <button className="btn btn-secondary" onClick={() => setValore(valore + 1)}>
                Aumenta
            </button>
        </>
    );
};

export default EsempioUseEffect;
