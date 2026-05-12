package Lezione_06;

//? Procediamo con la creazione dei nostri tipi enum e gli associamo in questo caso anche una descrizione
	
	 NUOVO ("Prodotto completamente nuovo, come da fabbrica"),
	 OTTIMO ("Prodotto in ottime condizioni, quasi come nuovo"),
	 RICONDIZIONATO("Prodotto rigenerato con FIX dei problemi, rimesso in commercio"),
	 USATO("Prodotto utilizzato, ma funzionante");
	
    private final String descrizione;
    
    
    CategoriaProdotto(String descrizione) {
        this.descrizione = descrizione;
    }
    
    
    public String descrizione() {
        return descrizione;
    }
}


