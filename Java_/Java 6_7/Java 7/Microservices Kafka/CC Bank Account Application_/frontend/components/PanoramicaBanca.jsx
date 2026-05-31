import React, { useState } from 'react';

// * This component serves as the main dashboard for displaying bank accounts (conti correnti) and their details. It fetches the list of accounts from the backend and allows users to click on an account to view its movements and details in a structured format using the ReportBanca component. The dashboard also includes instructions for users on how to register and open new accounts, ensuring a user-friendly experience.
const PanoramicaBanca = ({ conti }) => {

    // ? State to manage the visibility of the detailed client information section in the admin dashboard
    const [mostraDettagli, setMostraDettagli] = useState(false);

    // ? Calculate total liquidity, total inflows (incassi), total outflows (spese), and the number of active vs. overdrawn accounts for the bank overview. This data is used to provide insights into the bank's overall financial health and to display a visual representation of account distribution.
    const totaleLiquidita = conti.reduce((acc, c) => acc + c.saldo, 0);
    
    let totalIncassi = 0;
    let totalSpese = 0;

    conti.forEach(c => {
        c.listaMovimenti.forEach(m => {
            if (m.operazione === 'versamento') totalIncassi += m.importo.value;
            if (m.operazione === 'prelievo') totalSpese += m.importo.value;
         
        });
    });

    const contiAttivi = conti.filter(c => c.saldo >= 0).length;
    const contiInRosso = conti.length - contiAttivi;

    // * Creation of a Pie Chart using CSS conic-gradient to visually represent the percentage of active vs. overdrawn accounts. The percentage is calculated based on the total number of accounts and the number of active accounts, providing a quick visual insight into the distribution of account statuses within the bank.
    const percAttivi = conti.length > 0 ? (contiAttivi / conti.length) * 100 : 0;

    return (
        <div style={{ padding: '20px', backgroundColor: '#fff', borderRadius: '10px' }}>
            <h2 style={{ color: '#2c3e50', borderBottom: '2px solid #eee', paddingBottom: '10px' }}>
                    Panoramica Globale Banca
            </h2>

            {/* Here the Statistics Boxes are displayed */}
            <div style={{ display: 'flex', gap: '20px', marginBottom: '30px' }}>
                <div style={statBoxStyle}>
                    <small>PATRIMONIO TOTALE</small>
                    <h2 style={{ color: '#27ae60' }}>{totaleLiquidita.toFixed(2)} €</h2>
                </div>
                <div style={statBoxStyle}>
                    <small>FLUSSI CASSA</small>
                    <p>Entrate: <b style={{color: 'green'}}>+{totalIncassi.toFixed(2)}€</b></p>
                    <p>Uscite: <b style={{color: 'red'}}>-{totalSpese.toFixed(2)}€</b></p>
                </div>
            </div>

            {/* Here the Pie Chart is displayed */}
            <div style={{ display: 'flex', alignItems: 'center', gap: '30px', marginBottom: '40px', padding: '20px', background: '#f8f9fa', borderRadius: '8px' }}>
                <div style={{
                    width: '120px',
                    height: '120px',
                    borderRadius: '50%',
                    background: `conic-gradient(#27ae60 0% ${percAttivi}%, #e74c3c ${percAttivi}% 100%)`,
                    border: '4px solid #fff',
                    boxShadow: '0 4px 8px rgba(0,0,0,0.1)'
                }}></div>
                <div>
                    <h4>Distribuzione Conti</h4>
                    <p><span style={{color: '#27ae60'}}>●</span> Attivi: {contiAttivi}</p>
                    <p><span style={{color: '#e74c3c'}}>●</span> In Rosso: {contiInRosso}</p>
                </div>
            </div>

            {/* Show all the client details, of opened accountsin the bank */}
            <button 
                onClick={() => setMostraDettagli(!mostraDettagli)}
                style={{ marginBottom: '20px', padding: '10px 15px', cursor: 'pointer', background: '#2c3e50', color: 'white', border: 'none', borderRadius: '4px' }}
            >
                {mostraDettagli ? "Nascondi Anagrafica" : "Mostra Anagrafica Clienti Root"}
            </button>

            {mostraDettagli && (
                <div style={{ overflowX: 'auto' }}>
                    <table width="100%" border="1" style={{ borderCollapse: 'collapse', borderColor: '#ddd' }}>
                        <thead style={{ background: '#eee' }}>
                            <tr>
                                <th style={{padding: '10px'}}>Cliente</th>
                                <th>Contatti</th>
                                <th>Residenza</th>
                                <th>Conto</th>
                            </tr>
                        </thead>
                        <tbody>
                            {conti.map(c => (
                                <tr key={c.numeroConto}>
                                    <td style={{padding: '10px'}}><b>{c.intestatario.nome} {c.intestatario.cognome}</b></td>
                                    <td>{c.intestatario.mail}<br/>{c.intestatario.telefono}</td>
                                    <td style={{fontSize: '13px'}}>
                                        {c.intestatario.indirizzo.via}, {c.intestatario.indirizzo.citta}
                                    </td>
                                    <td style={{textAlign: 'center'}}>N. {c.numeroConto}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            )}
        </div>
    );
};

// ? Style object for the statistic boxes in the bank overview section, providing a consistent design with padding, border, and shadow to enhance the visual appeal of the displayed financial metrics.
const statBoxStyle = {
    flex: 1,
    padding: '20px',
    border: '1px solid #eee',
    borderRadius: '8px',
    boxShadow: '0 2px 4px rgba(0,0,0,0.05)'
};

export default PanoramicaBanca;
