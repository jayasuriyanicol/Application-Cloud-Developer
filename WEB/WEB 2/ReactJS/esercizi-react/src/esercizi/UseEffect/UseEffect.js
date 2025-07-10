import React,{ useEffect, useState} from "react";


const EsempioUseEffect = () => {
    

    const[valore,setValore] =useState(0); 
    
    const funzio=()=>{
        console.log("Funziona")
    };
    useEffect(() => {

        if(valore < 1){
             document.title = "Nessun valore"
        }else{
            document.title = "C'è qualcosa ..."
        }
         console.log("Chiamato useEffect");

         return (() => (console.log("Chiamata funzione CleanUp !")))
    

   },[valore]);
}
   /*
   Lo useEffect viene vincolato,ovvero con :
   1.[] eseuguo una sola volta
   2. Senza paramtro eseguo sempre
   3. Con parametri eseguo vincolato al cambio di stato dei parametri passati 1-n 
   */

   useEffect(funzio,[]);

    console.log("Fuori dallo useEffect");

   return (
    <>
    <div>Esempio useEffect</div>
    <button className="btn btn-secondarynpm" onClick={()=>setValore(valore>valore+1)}>Aumenta</button> 
    </>
   );

export default EsempioUseEffect;