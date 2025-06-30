import React, { useEffect, useState } from 'react'

const CleanUp = () => {
    const [size,setSize] = useState(window.innerWidth) /* => tramite "window.innerWidth" lo andiamo ad adattare alle dimensioni della finestra */
    const dimensioneFinestra=() => (
        setSize(window.innerWidth)
    )

    useEffect(()=>{
        window.addEventListener("resize", dimensioneFinestra);
        return()=>{
            window.removeEventListener("resize",dimensioneFinestra)
        };
    })
    
    return (
    <div><h1><b>CleanUp - Using useEffect</b></h1>

        <h3>Questa è la dimensione della finestra :{size}</h3>
    </div>
  )
}

export default CleanUp;