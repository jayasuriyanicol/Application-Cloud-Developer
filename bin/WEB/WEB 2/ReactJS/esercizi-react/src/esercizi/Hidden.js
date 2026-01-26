import React, { useState } from 'react'

const Hidden = () => {

    const [show, setShow] = useState(true)
    return (

        <div>
            <h1>Hidden</h1>
            {show && <Elemento></Elemento>}
            <button onClick={() => setShow(!show)}>{show ? "Nascondi" : "Visualizza"} </button>
        </div>

    )
}


const Elemento = (show) => {

    return (<h2>Elemento</h2>)
}

export default Hidden