import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';


function App(){

  return (
    <div className='container text-center mt-5'> 
        <h1 className='display-5 text-primary'> Benvenuti ! Mi presento sono Nicol Jayasuriya</h1>


       {/*Utilizziamo "<hr>" per dividere correttamente il testo dal benvenuto*/}
        <hr></hr>
    <p className="lead">Benvenuto nel mio sito React, questo è il mio primo sito personalizzato su <b>React</b></p>

      <p>Studio React e sto imparando a usare Bootstrap!</p>


    </div>

  );

}

export default App;



