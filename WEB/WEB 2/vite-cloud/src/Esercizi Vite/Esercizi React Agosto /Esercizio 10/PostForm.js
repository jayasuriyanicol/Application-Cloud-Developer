import { useState } from "react";


const PostForm = ({aggiungiPost}) => {

    const [titolo, setTitolo] = useState ('');
    const [contenuto, setContenuto] = useState ('');



    function refreshPagina(evento) {
        
        evento.preventDefault();

        if (!titolo || !contenuto) return 'ATTENZIONE ! Contenuto già presente';

        // Vado a richiamare i dati del nuovo post su aggiungiPost e resetto successivamente i campi
        const nuovoPost = {titolo, contenuto};
        aggiungiPost(nuovoPost);

        setTitolo("");
        setContenuto("")


    }
    


        return (
            
            <form onSubmit={refreshPagina}>

                <input type="text" value={titolo} onChange={(evento) => setTitolo(evento.target.value)}></input>
                <textarea type="text" value={contenuto} onChange={(evento) => setContenuto(evento.target.value)} ></textarea>
 
                <button type="submit"> Salva </button>
            </form>
            
        );
 
};

export default PostForm;