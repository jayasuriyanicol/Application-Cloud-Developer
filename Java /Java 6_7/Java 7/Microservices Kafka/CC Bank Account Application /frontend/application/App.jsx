
// * The APPLICATION REACT/VITE : Implement main routing and restricted access logic" -m "- Add React Router navigation for Dashboard, Registration, and Account Opening.
import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import DashboardConti from './components/DashboardConti';
import RegistrazioneUtente from './components/RegistrazioneUtente';
import AperturaConto from './components/AperturaConto';
import PanoramicaBanca from './components/PanoramicaBanca'; 
import api from './services/api';

function App() {
  const [conti, setConti] = useState([]);
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [password, setPassword] = useState("");
  const [showPassword, setShowPassword] = useState(false);

  useEffect(() => {
    api.get('gestioneCC/conti')
      .then(res => setConti(res.data))
      .catch(err => console.error("Errore caricamento dati", err));
  }, []);

  const handleLogin = () => {
    if (password === "admin123") {
      setIsAuthenticated(true);
    } else {
      alert("Password Errata!");
    }
  };

  /* 
     ! What the code does doing:
     ? Implement basic password protection for the '/admin' route.
     ? Integrate PanoramicaBanca component within the protected area.
     ? - Add toggle visibility for the admin password field.
  */

  return (
    <Router>
      <nav style={{ padding: '20px', backgroundColor: '#f4f4f4', marginBottom: '20px', display: 'flex', gap: '15px' }}>
        <Link to="/">Dashboard Conti</Link>
        <Link to="/registra">Registra Utente</Link>
        <Link to="/AperturaConto">Apri CC</Link>
        <Link to="/admin" style={{ marginLeft: 'auto', fontWeight: 'bold', color: 'red' }}>🔒 Area Root</Link>
      </nav>

      <div className="container" style={{ padding: '0 20px' }}>
        <Routes>
          <Route path="/" element={<DashboardConti />} />
          <Route path="/registra" element={<RegistrazioneUtente />} />
          <Route path="/AperturaConto" element={<AperturaConto />} />
          
          <Route path="/admin" element={
            !isAuthenticated ? (
              <div style={{ textAlign: 'center', marginTop: '50px', padding: '30px', border: '1px solid #ccc', borderRadius: '10px' }}>
                <h2>Accesso Riservato Root</h2>
                <div style={{ position: 'relative', display: 'inline-block' }}>
                  <input 
                    type={showPassword ? "text" : "password"} 
                    placeholder="Inserisci Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)} 
                    onKeyDown={(e) => e.key === 'Enter' && handleLogin()}
                    style={{ padding: '10px', paddingRight: '45px', fontSize: '16px' }}
                  />
                  <button 
                    type="button"
                    onClick={() => setShowPassword(!showPassword)}
                    style={{ position: 'absolute', right: '10px', top: '50%', transform: 'translateY(-50%)', background: 'none', border: 'none', cursor: 'pointer', fontSize: '20px' }}
                  >
                    {showPassword ? "👁️" : "🙈"} 
                  </button>
                </div>
                <br /><br />
                <button onClick={handleLogin} style={{ padding: '10px 30px', cursor: 'pointer', backgroundColor: '#d9534f', color: 'white', border: 'none', borderRadius: '5px' }}>
                  Accedi
                </button>
              </div>
            ) : (
              <PanoramicaBanca conti={conti} />
            )
          } />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
