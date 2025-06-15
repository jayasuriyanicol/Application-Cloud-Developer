import React from "react"

 /*2- Scrivere un componente Tabellina che stampi la tabellina di un numero, compreso tra 1 e 10 a vostro piacimento.*/
 


 function Tabellina ({numeroTabellina = 5}){

    const risultatoTabellina = []; 
    

    for (let i=1 ; i<=10; i++) {


        risultatoTabellina.push(

            <li key={i} className="list-group-item">
               
             {/*In questa maniera andaimo a creare una tabella con la sintassi: numero x numeroIterazione = numeroTabellina */}
               {numeroTabellina} x {i} = {numeroTabellina * i}
            </li>
        );
 }


return (

    <div className="container mt-4">
        <div className="card shadow-sm">
            <div className="card-body">

                <h5 className="card-title">Tabellina del numero {numeroTabellina}</h5>
                <ul className="list-group">{risultatoTabellina}</ul>
            </div>
        </div>
    </div>



);
}

export default Tabellina;