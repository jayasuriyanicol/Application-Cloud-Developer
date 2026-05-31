import React from "react";


    /*3- Scrivere un componente Stampanumeri che stampa i numeri da 0 a 10 ; */

function Stampanumeri ({numeroAttuale=0}){

    const listaNumeri= [] ;


    for (let i=0 ; i<=10 ; i++){

        listaNumeri.push(

            <li key={i} className="list-group-item">

              {i} Numero  = {numeroAttuale + i}
            </li>
        );

}


return (


    <div className="container mt-4">
        <div className="card shadow-sm">
            <div className="card-body">

                <h5 className="card-title"> Numeri da 0 a 10 </h5>
                <ul className="list-group">{listaNumeri}</ul>
            </div>
        </div>
    </div>
);

}
export default Stampanumeri;