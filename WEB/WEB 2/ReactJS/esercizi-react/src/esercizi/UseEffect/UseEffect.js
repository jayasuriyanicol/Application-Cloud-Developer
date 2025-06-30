import React,{ useEffect, useState} from "react";


const EsempioUseEffect = () => {
    

    const[valore,setValore] =useState(0); 

    useEffect(() => {

        if(valore < 1){
             document.title = "Nessun valore"
        }else{
            document.title = "C'è qualcosa ..."
        }
         console.log("Chiamato useEffect");
    
    
   });
 

   return (
    <>
    <div>Esempio useEffect</div>
    <button className="btn btn-secondarynpm" onClick={()=>setValore(val>val+1)}>Aumenta</button> 
    </>
   )

}