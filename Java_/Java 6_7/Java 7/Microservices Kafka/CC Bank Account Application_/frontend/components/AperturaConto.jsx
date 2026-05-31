import React, { useState } from 'react';

// * Component for opening a new bank account, with a form to input the initial balance and the user ID of the account holder. It sends a POST request to the backend to create the account.    

const AperturaConto = () => {
    
    // ? State to manage form data for opening a new account
    const [formData, setFormData] = useState({
        idIntestatario: '',
        saldoIniziale: 0

    });


    const handleSubmit = async (e) => {
        e.preventDefault();

        // * Here we prepare the payload to send to the backend as required in CCRichiestaAperturaContoDTO.
        
        const payload = {
            saldoIniziale: parseFloat(formData.saldoIniziale),
            idIntestatario: parseInt(formData.idIntestatario),

            // ! Setted as null as default 
            idCointestatario: null
        };

        try {

            const response = await fetch('http://localhost:8080/gestioneCC/conti',
                {

                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },

                // * Here we send the payload as JSON string in the body of the request
                body: JSON.stringify(formData),
            });

            if (response.ok) {
                alert(" SUCCESSO ! Il CC è stato aperto con successo!");
                setFormData({ idIntestatario: '', saldoIniziale: 0 });
            } else {
                const errorMessage = await response.text();
                alert("ATTENZIONE ! Errore:\n " + errorMessage);
            }
        } catch (error) {
            console.error("ATTENZIONE ! Errore durante l'invio dei dati\n:", error);
            alert("ATTENZIONE ! Errore di connessione al server");
        }
    };
    
    // * The form for opening a new account, with fields for user ID and initial balance, and a submit button. It also includes some instructions and warnings for the user.
    return (
        <div className="container mt-5">
            <h2>Benvenuto nell'Area per l'apertura dei Conti Correnti !</h2>
            <br></br>
            <p>Compila il form per aprire un nuovo conto corrente, mi raccomando di verificare i dati inseriti.</p>
            <br></br>
            <p style={{ color: 'red' }}>ATTENZIONE ! Prima di aprire un conto corrente, bisogna essere registrati presso la banca.</p>
            <br></br>
            <b>Quindi andare su : Barra Navigazione / Registra Utente </b>

        <br></br>
        <br></br>
        <br></br>
    
   
            <form onSubmit={handleSubmit} className="card p-4 shadow">
                <div className="mb-3">

                    <p>Inserisci di seguito i dati richiesti inserendoli <b>correttamente</b>:</p>
                    <br></br>
                    <label className="form-label">ID Utente Intestatario:</label>
                    <input 
                        type="number" 
                        className="form-control"
                        value={formData.idIntestatario}
                        onChange={(e) => setFormData({...formData, idIntestatario: e.target.value})}
                        required 
                    />
                </div>
                <br></br>
                <div className="mb-3">
                    <label className="form-label">Saldo Iniziale (€):</label>
                    <input 
                        type="number" 
                        className="form-control"
                        value={formData.saldoIniziale}
                        onChange={(e) => setFormData({...formData, saldoIniziale: e.target.value})}
                        required 
                    />
                <br></br>
                <br></br>
                </div>
                <button type="submit" className="btn btn-primary">Apri Conto</button>
            </form>
            <br></br>
            <br></br>
            <p style={{ color: '#666', fontStyle: 'italic' }}>
                       NOTA: Saldo Iniziale, indica l'importo con cui si desidera aprire il conto corrente.Può essere un valore positivo.
                    </p>
        </div>
    );
};

export default AperturaConto;
