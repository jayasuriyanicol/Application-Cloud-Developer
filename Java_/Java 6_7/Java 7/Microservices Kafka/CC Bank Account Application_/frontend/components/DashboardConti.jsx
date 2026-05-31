import React, { useEffect, useState } from 'react';
import api from '../services/api';
import ReportBanca from './ReportBanca'; 


// * This component serves as the main dashboard for displaying bank accounts (conti correnti) and their details. It fetches the list of accounts from the backend and allows users to click on an account to view its movements and details in a structured format using the ReportBanca component. The dashboard also includes instructions for users on how to register and open new accounts, ensuring a user-friendly experience.
const DashboardConti = () => {

    // ? State to hold the list of bank accounts and the currently selected account for detailed view
    const [conti, setConti] = useState([]);
    const [contoSelezionato, setContoSelezionato] = useState(null);



    useEffect(() => {
        api.get('gestioneCC/conti') 
            .then(res => setConti(res.data))
            .catch(err => console.error("ATTENZIONE ! Errore caricamento dei CC", err));
    }, []);

    return (
        <div style={{ padding: '20px' }}>
            <h2>Benvenuto nella DASHBOARD dei Conti Correnti !</h2>
            <br></br>
            <p>Di seguito trovi la lista dei conti correnti:</p>
            <br></br>
            <p style={{ color: 'red' }}>ATTENZIONE ! Prima di aprire un conto corrente, bisogna essere registrati presso la banca.</p>
            <br></br>
            <b>Quindi andare su : Barra Navigazione / Registra Utente </b>
            <br></br>
            <br></br>
            <table border="1" style={{ width: '100%', textAlign: 'left', borderCollapse: 'collapse' }}>
                <thead>
                    <tr style={{ backgroundColor: '#eee' }}>
                        <th>Numero Conto</th>
                        <th>Saldo</th>
                        <th>Proprietario</th>
                        <th>N° Movimenti</th>
                    </tr>
                </thead>
                <tbody>
                    {conti.length > 0 ? conti.map(c => (
                        <tr 
                            key={c.numeroConto} 
                            
                            // ? Using a useEffect to select the account when clicked, in this case the variable c, that show us the details of movements. 

                            onClick={() => setContoSelezionato(c)} 
                            style={{ 
                                cursor: 'pointer', 
                                backgroundColor: contoSelezionato?.numeroConto === c.numeroConto ? '#f0f8ff' : 'transparent' 
                            }}
                        >
                            <td>{c.numeroConto}</td>
                            <td style={{ color: c.saldo < 0 ? 'red' : 'green', fontWeight: 'bold' }}>
                                {c.saldo.toFixed(2)} €
                            </td>
                            <td>{c.intestatario.nome} {c.intestatario.cognome}</td>
                            <td>{c.listaMovimenti.length}</td>
                        </tr>
                    )) : (
                        <tr><td colSpan="4" align='center'>ATTENZIONE ! Non riusciamo a caricare i CC oppure nessun CC presente. Riprovare più tardi.</td></tr>
                    )}
                </tbody>
            </table>

           { /* The section below shows the details of the selected account, including the current balance, total penalties (mora), and a list of all movements. It uses the ReportBanca component to display this information in a structured format. If no account is selected, it shows a message prompting the user to click on an account to see the details. */ }
           
            <div style={{ marginTop: '30px' }}>
                {contoSelezionato ? (
                    <ReportBanca conto={contoSelezionato} />
                ) : (
                    <p style={{ color: '#666', fontStyle: 'italic' }}>
                        Clicca su una riga della tabella per vedere il dettaglio dei movimenti.
                    </p>
                )}
            </div>
        </div>
    );
};

export default DashboardConti;
