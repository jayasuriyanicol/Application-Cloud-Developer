// * This component provides a form for registering a new user in the banking system. It collects personal information such as name, surname, email, phone number, and address details. Upon submission, it sends the data to the backend API to create a new user account. The form includes validation to ensure that required fields are filled out correctly, and it provides feedback to the user about the success or failure of the registration process.

import React, { useState } from 'react';
import api from '../services/api';


// ? All the info about the user that we need to register, with the form to insert all the data and send it to the backend.
const RegistrazioneUtente = () => {

    // * All the data need as created in the DTO for the registration of the user, with the useState to manage the form data and handleSubmit to send the data to the backend.
    const [formData, setFormData] = useState({
        nome: '', cognome: '', mail: '', telefono: '',
        indirizzo: { via: '', cap: '', citta: '', provincia: '' }
    });


    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await api.post('/gestioneUtenti/utenti', formData);
            alert("SUCCESSO ! L'utente  è statoregistrato presso la nostra banca!");
        } catch (error) {
            alert("ATTENZIONE ! Errore durante la registrazione: " + error.response?.data);
        }
    };
   
    // * The form for registering a new user, with fields for personal information and address details, and a submit button. It also includes some instructions and warnings for the user.
    return (
      
        <div style={{ color: 'white', padding: '20px', alignContent: 'center', backgroundColor: '#2c3e50', borderRadius: '10px' }}>
            
            <h2>Registrazione Nuovo Utente</h2>

             <br></br>
             <br></br>
            
            <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '10px', maxWidth: '400px', alignContent: 'center', margin: '0 auto' }}>
                <input type="text" placeholder="Nome" onChange={e => setFormData({...formData, nome: e.target.value})} required />
                <input type="text" placeholder="Cognome" onChange={e => setFormData({...formData, cognome: e.target.value})} required />
                <input type="email" placeholder="Email" onChange={e => setFormData({...formData, mail: e.target.value})} required />
                <input type="text" placeholder="Telefono (Facoltativo)" onChange={e => setFormData({...formData, telefono: e.target.value})} />
                
                <h3>Indirizzo</h3>
                <input type="text" placeholder="Via" onChange={e => setFormData({...formData, indirizzo: {...formData.indirizzo, via: e.target.value}})} required />
                <input type="text" placeholder="CAP" onChange={e => setFormData({...formData, indirizzo: {...formData.indirizzo, cap: e.target.value}})} required />
                <input type="text" placeholder="Città" onChange={e => setFormData({...formData, indirizzo: {...formData.indirizzo, citta: e.target.value}})} required />
                <input type="text" placeholder="Provincia" onChange={e => setFormData({...formData, indirizzo: {...formData.indirizzo, provincia: e.target.value}})} required />
                
                <br></br>
                <br></br>

                <button type="submit" style={{ padding: '10px', cursor: 'pointer' }}>Registra</button>
            </form>
        </div>
    );
};

export default RegistrazioneUtente;
