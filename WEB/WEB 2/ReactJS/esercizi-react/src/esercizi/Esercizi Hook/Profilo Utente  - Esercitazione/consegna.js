/* 

CONSEGNA ESERICZIO - PROFILO UTENTE:

Componente Profilo Utente con Bootstrap
Obiettivo

Creare un componente React ProfiloUtente che visualizzi le informazioni di un utente all'interno di una Bootstrap Card con un pulsante per mostrare i dettagli in un alert. Il layout finale dovrà mostrare le card organizzate in righe da 3 colonne ciascuna, utilizzando il sistema di griglia di Bootstrap
Passo 1: Preparazione dei Dati

Crea un array utenti con almeno 3 oggetti contenenti:

    id, nome, cognome, eta, professione, email

Passo 2: Componente ProfiloUtente
Cosa deve fare:

    Ricevere un oggetto utente tramite props
    Restituire SOLO una Bootstrap Card (senza classi di colonna!)
    Mostrare nome completo, età, professione, email
    Gestire il click per mostrare dettagli in alert

Struttura Bootstrap richiesta:
 
 

<div className="card h-100">
  <div className="card-header text-center">
    <!-- Titolo o icona -->
  </div>
  <div className="card-body text-center">
    <!-- Nome, età, professione, email -->
  </div>
  <div className="card-footer text-center">
    <!-- Messaggio click -->
  </div>
</div>

Suggerimenti:

    Classe badge per l'età
    Eventi onClick per mostrare alert con tutti i dati
    Usa h5 o h6 per il nome

Passo 3: Logica Layout in App
Cosa deve fare:

    Creare una funzione per dividere l'array in gruppi di 3
    Usare Bootstrap Grid System per organizzare il layout
    Gestire le classi di colonna QUI, non nel componente

Struttura Bootstrap richiesta:
 
 

<div className="container">
  <div className="row">
    <div className="col-md-4">
      <ProfiloUtente utente={utente1} />
    </div>
    <div className="col-md-4">
      <ProfiloUtente utente={utente2} />
    </div>
    <div className="col-md-4">
      <ProfiloUtente utente={utente3} />
    </div>
  </div>
  <!-- Ripeti per altre righe -->
</div>

Suggerimenti:

    Funzione helper: array.slice(i, i + 3) in un loop
    .map() per creare le righe e le colonne
    key obbligatorio per ogni elemento mappato

Checklist Finale
Bootstrap:

    container → row → col-md-4
    card → card-header → card-body → card-footer
    badge per l'età

React:

    Props passate correttamente
    Attributo key negli elementi mappati
    className invece di class
    Componente restituisce solo la card
    Layout gestito in App
*/

