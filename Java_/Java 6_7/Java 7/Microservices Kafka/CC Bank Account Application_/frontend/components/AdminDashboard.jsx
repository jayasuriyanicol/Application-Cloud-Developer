import React, { useState } from 'react';
import PanoramicaBanca from './PanoramicaBanca';

// * Access business to the admin dashboard to log into the reserved area and view the logic of the bank'operations

const AdminDashboard = () => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [password, setPassword] = useState("");

    const handleLogin = () => {
        // ? password simple per demo
        if (password === "admin123") { 
            setIsAuthenticated(true);
        } else {
            alert("Accesso negato!");
        }
    };

    // ! The case if the user is authenticated i will show the dashboard with all the operations.
    if (!isAuthenticated) {
        return (
            <div style={{ textAlign: 'center', marginTop: '50px' }}>
                <h2>Area Riservata Amministratore</h2>
                <input 
                    type="password" 
                    onChange={(e) => setPassword(e.target.value)} 
                />
                <button onClick={handleLogin}>Accedi</button>
            </div>
        );
    }

    // ? Show the need it data for the dashboard.
    return <PanoramicaBanca />; // Se loggato, mostra i dati
};

export default AdminDashboard;
