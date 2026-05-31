// * This component is responsible for displaying the bank account statement (report) of a specific account. It shows the account number, the account holder's name, the current balance, the total penalties paid (mora), and a list of all transactions (movimenti) associated with the account. The transactions are displayed in a table format, showing the date, type of operation (deposit or withdrawal), and the amount for each transaction. The component also calculates the total penalties paid by summing up all withdrawal transactions that correspond to a specific penalty amount (e.g., 3.0€). This allows users to have a clear overview of their account activities and any penalties incurred.

import React from 'react';

const ReportBanca = ({ conto }) => { 
  if (!conto) return null;

  // ? Calculate the total penalties paid (mora) by filtering the transactions for withdrawals that match the penalty amount and summing their values. This provides insight into how much the account holder has paid in penalties over time, which can be useful for understanding account management and financial behavior.
  const totaleMora = conto.listaMovimenti
    ? conto.listaMovimenti
        .filter(m => m.operazione === 'prelievo' && m.importo.value === 3.0) 
        .reduce((acc, m) => acc + m.importo.value, 0)
    : 0;
  

   // ! All the data is displayed in a structured format, with the account details at the top and a table listing all transactions below. The balance is color-coded to indicate whether it is positive (green) or negative (red), providing a quick visual cue about the account's financial status. The penalties paid are also highlighted in orange to draw attention to this specific aspect of the account's history.
  return (
    <div className="report-container" style={{ padding: '20px', border: '1px solid #ccc', marginTop: '20px', borderRadius: '8px', backgroundColor: '#fff' }}>
      <h2 style={{ color: '#333' }}>Estratto Conto n. {conto.numeroConto}</h2>
      <p><strong>Intestatario:</strong> {conto.intestatario.nome} {conto.intestatario.cognome}</p>
      
      <div style={{ display: 'flex', gap: '20px', marginBottom: '20px' }}>
        <div style={{ flex: 1, padding: '15px', background: '#f9f9f9', borderRadius: '5px' }}>
          <h4>Saldo Attuale</h4>
          <p style={{ color: conto.saldo < 0 ? 'red' : 'green', fontSize: '24px', fontWeight: 'bold' }}>
            {conto.saldo.toFixed(2)} €
          </p>
        </div>
        <div style={{ flex: 1, padding: '15px', background: '#f9f9f9', borderRadius: '5px' }}>
          <h4>Penali Pagate (Mora)</h4>
          <p style={{ color: 'orange', fontSize: '24px', fontWeight: 'bold' }}>
            {totaleMora.toFixed(2)} €
          </p>
        </div>
        <div style={{ flex: 1, padding: '15px', background: '#f9f9f9', borderRadius: '5px' }}>
          <h4>Movimenti Totali</h4>
          <p style={{ fontSize: '24px', fontWeight: 'bold' }}>{conto.listaMovimenti.length}</p>
        </div>
      </div>

      <table width="100%" border="1" style={{ borderCollapse: 'collapse', borderColor: '#eee' }}>
        <thead>
          <tr style={{ backgroundColor: '#f4f4f4', textAlign: 'left' }}>
            <th style={{ padding: '10px' }}>Data</th>
            <th style={{ padding: '10px' }}>Operazione</th>
            <th style={{ padding: '10px' }}>Importo</th>
          </tr>
        </thead>
        <tbody>
          {conto.listaMovimenti.map((mov) => (
            <tr key={mov.idMovimento}>
              <td style={{ padding: '10px' }}>{new Date(mov.dataOperazione).toLocaleString()}</td>
              <td style={{ padding: '10px', textTransform: 'capitalize' }}>{mov.operazione}</td>
              <td style={{ padding: '10px', color: mov.operazione === 'prelievo' ? 'red' : 'green', fontWeight: '500' }}>
                {mov.operazione === 'prelievo' ? '-' : '+'}{mov.importo.value.toFixed(2)} €
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ReportBanca;
