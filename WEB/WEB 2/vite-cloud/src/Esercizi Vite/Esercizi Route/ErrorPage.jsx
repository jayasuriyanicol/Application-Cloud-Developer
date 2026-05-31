import React from 'react'
import {useNavigate} from 'react-router-dom'

const ErrorPage = () => {
    const navigate= useNavigate();
  return (
    <div>
        <p>ATTENZIONE ! Questa pagina non esiste ! </p>
        <button className='btn-btn-success' onClick={()=> navigate('/')}>Torna alla home</button>
    </div>
  );
};

export default ErrorPage;