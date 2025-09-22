-- Creazione del DB eBuy

BEGIN TRANSACTION
SET CONSTRAINTS ALL DEFERRED;


CREATE TABLE Categoria (

    nome Stringa PRIMARY KEY,
    super Stringa,

    CHECK (nome <> super )

);


ALTER TABLE Categoria 
ADD CONSTRAINT fk_categoria_super
FOREIGN KEY (super) REFERENCES categoria(nome);



CREATE TABLE Utente(

    username Stringa PRIMARY KEY,
    registrazione TIMESTAMP NOT NULL

    --Per utilizzare la funzione 'Disjoint & Complete' possiamo utilizzare questo CHECK
    --dato che in PostgreSQL non vi è un'opzione specifica ma ELEMENTARMENTE possiamo utilizzare
    --solo dei CHECK per ovviare a questa situazione.
    tipologiaUtente VARCHAR NOT NULL,
   
    CHECK(tipologiaUtente IN ('Privato', 'Venditore'))

);



CREATE TABLE VenditoreProfessionale(

    vetrina Url UNIQUE NOT NULL,

    vp_isa_ut Stringa PRIMARY KEY,

    FOREIGN KEY (vp_isa_ut) REFERENCES Utente(username)


);


CREATE TABLE Privato(

    pr_isa_ut Stringa PRIMARY KEY,

    FOREIGN KEY (pr_isa_ut) REFERENCES Utente(username)

);



CREATE TABLE MetodoPagamento(

    nome Stringa PRIMARY KEY NOT NULL

);




CREATE TABLE PostOggetto(
    
    id SERIAL PRIMARY KEY,
    descrizione Stringa NOT NULL,
    pubblicazione TIMESTAMP NOT NULL,
    ha_feedback BOOLEAN,
    voto Voto,
    commento Stringa,
    istante_feedback TIMESTAMP NOT NULL,

    Utente Stringa NOT NULL,
    Categoria Stringa NOT NULL,

    FOREIGN KEY (Utente) REFERENCES utente(username),
    FOREIGN KEY (Categoria) REFERENCES categoria(nome),

    CHECK((ha_feedback = True AND voto IS NOT NULL)
      OR  (ha_feedback = False AND voto IS NULL AND commento IS NULL) )
);


CREATE TABLE met_post (

    metodo Stringa NOT NULL,
    post   INTEGER NOT NULL

    PRIMARY KEY (metodo,post),
    FOREIGN KEY (metodo) REFERENCES MetodoPagamento(nome),
    FOREIGN KEY (post) REFERENCES PostOggetto(id)

);



CREATE TABLE PostOggettoNuovo(

    anni_garanzia IntG1 NOT NULL,

    pon_isa_po INTEGER PRIMARY KEY,
    pubblica_nuovo Stringa NOT NULL,

    FOREIGN KEY (pon_isa_po) REFERENCES PostOggetto(id),
    FOREIGN KEY(pubblica_nuovo) REFERENCES VenditoreProfessionale(vp_isa_ut)
);


CREATE TABLE PostOggettoUsato(

    condizione Condizione NOT NULL,
    anni_garanzia IntGEZ NOT NULL

    pou_isa_po INTEGER PRIMARY KEY,
    FOREIGN KEY (pou_isa_po) REFERENCES PostOggetto(id)

);





CREATE TABLE Asta(

    prezzo_base RealGEZ NOT NULL,
    prezzo_bid RealGZ NOT NULL,
    scadenza TIMESTAMP NOT NULL,

    asta_isa_po INTEGER PRIMARY KEY,
    FOREIGN KEY (asta_isa_po) REFERENCES PostOggetto(id)


);

CREATE TABLE Bid(

    codice SERIAL PRIMARY KEY,
    istante TIMESTAMP NOT NULL,


    
    asta_bid INTEGER NOT NULL,

    UNIQUE(istante,asta_bid),

    bid_ut Stringa NOT NULL,

    FOREIGN KEY(asta_bid) REFERENCES Asta(asta_isa_po),
    FOREIGN KEY(bid_ut) REFERENCES Privato(pr_isa_ut)

);



CREATE TABLE CompraloSubito(

    prezzo RealGZ NOT NULL,

    cs_isa_po INTEGER PRIMARY KEY,

    FOREIGN KEY(cs_isa_po) REFERENCES PostOggetto(id)
);



CREATE TABLE Acquirente(

    acqu_isa_ut Stringa PRIMARY KEY,
    istante TIMESTAMP NOT NULL,

    FOREIGN KEY(acqu_isa_ut) REFERENCES Utente(username)
);


COMMIT;