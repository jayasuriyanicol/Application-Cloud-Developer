-- DB 2 - CREAZIONE DEL DB MyPrecious


CREATE DATABASE MyPrecious;

BEGIN TRANSACTION;
SET ALL DEFERRED;


--Creazione dei tipi di dato


CREATE DOMAIN RealGEZ AS REAL 
    CHECK (VALUE >=0);



CREATE DOMAIN IntGEZ AS INTEGER
    CHECK (VALUE >=0);


--Creaiamo la tipologia str, anche se potrbbe tranquillamente essere VARCHAR, ma per completezza l'aggiungiamo 
CREATE DOMAIN str AS VARCHAR;
    


--Creazione delle tabelle
CREATE TABLE Nazione (

    nome str PRIMARY KEY NOT NULL;
);



CREATE TABLE Regione (

    nome str PRIMARY KEY NOT NULL;
);


CREATE TABLE Citta (

    nome str PRIMARY KEY,
    regione str PRIMARY KEY NOT NULL,
    nazione str PRIMARY KEY NOT NULL,

    FOREIGN KEY (regione,nazione) REFERENCES Regione(nome,nazione);

);

CREATE TABLE Artista (

    idArtista SERIAL PRIMARY KEY,

    nome_arte str NOT NULL,
    data_nascita DATE NOT NULL,
    data_morte DATE,

    
    --Verifichiamo che la data di morte sia maggiore o maggiore uguale a quella di nascita

    CHECK(data_morte >= data_nascita)
);

CREATE TABLE Tecnica (

    nome  str PRIMARY KEY NOT NULL
);

CREATE TABLE Categoria (

    nome str PRIMARY KEY NOT NULL

);

CREATE TABLE CorrenteArtistica(

    nome str PRIMARY KEY NOT NULL
);

CREATE TABLE Opera (
    
    idOpera SERIAL PRIMARY KEY,

    nome str NOT NULL,
    anno_realizzazione IntGEZ NOT NULL,


    --Tutti i valori associati ad Opera:

    artista INTEGER,
    FOREIGN key (Artista) REFERENCES Artista(idArtista),

    tecnica str,
    FOREIGN KEY (Tecnica) REFERENCES Tecnica(nome),

    correnteArtistica str,
    FOREIGN KEY (CorrenteArtistica) REFERENCES CorrenteArtistica(nome),

    categoria str,
    FOREIGN KEY (Categoria) REFERENCES Categoria(nome)
    


);


CREATE TABLE Esposizione(

    idEsposizione SERIAL PRIMARY KEY NOT NULL,

    nome str NOT NULL,
    inizio DATE NOT NULL,


    --Valori associati dalla ristrutturazione:
    
    is_permanente BOOLEAN NOT NULL,
    is_temporanea BOOLEAN NOT NULL,

    --Valori ereditati a temporanea:

    fine DATE,
    prezzo_accesso RealGEZ,
    tema str

    --Verifichiamo come fatto in fase di ristrutturazione i vari campi
    CHECK (fine IS NULL) OR (fine >= inizo),

    CHECK ((is_temporanea = true AND fine IS NOT NULL AND tema IS NOT NULL AND prezzo_accesso IS NOT NULL)
            OR
           (is_temporanea = false AND fine IS NULL AND tema IS NULL AND prezzo_accesso IS NULL))
  
);


CREATE TABLE Tariffa (

    idTariffa SERIAL PRIMARY KEY,

    nome str NOT NULL,
    prezzo_base RealGEZ NOT NULL

);




CREATE TABLE Biglietto (

    idBiglietto SERIAL PRIMARY KEY,


    istante_vendita TIMESTAMP NOT NULL,
    validità DATE NOT NULL,
    is_standard BOOLEAN
    is_extended_access BOOLEAN


    CHECK (validita >= istante_vendita), 


    tariffa INTEGER NOT NULL,
    FOREIGN KEY (tariffa) REFERENCES Tariffa(idTariffa)

);

CREATE TABLE Standard(

    biglietto INTEGER PRIMARY KEY,
    FOREIGN KEY(biglietto) REFERENCES Biglietto(idBiglietto)


);

CREATE TABLE ExtendedAccess(

    biglietto INTEGER PRIMARY KEY,
    FOREIGN KEY(biglietto) REFERENCES Biglietto(idBiglietto)

);




--Creiamo il link ext_temp, ma senza l'ausilio del CHECK dato che non abbiamo svolto il TRIGGER

CREATE TABLE ext_temp(

    --Vincolo 0..* - 0..*  fra Biglietto ed Esposizione

    extended_access INTEGER PRIMARY KEY NOT NULL,
    FOREIGN KEY(extended_access) REFERENCES ExtendedAccess(biglietto)
    
    espozione_temporanea INTEGER PRIMARY KEY NOT NULL,
    FOREIGN KEY(espozione_temporanea) REFERENCES Esposizione,
);





--Association class fra Opera ed Esposizione

CREATE TABLE espone(

    --Vincolo 0..* - 0..*  fra Esposizione ed Opera

    inizio DATE NOT NULL,
    fine DATE,

    CHECK((fine IS NULL) 
          OR (fine >= inizio)),
    
    opera INTEGER PRIMARY KEY NOT NULL,
    FOREIGN KEY(opera) REFERENCES Opera(idOpera)

    esposizione INTEGER PRIMARY KEY NOT NULL,
    FOREIGN KEY(esposizione) REFERENCES Esposizione(idEsposizione) 
);




CREATE TABLE op_corr(

     --Vincolo 0..* - 1..*  fra Opera ed CorrenteArtistica


     opera INTEGER PRIMARY KEY NOT NULL,

     FOREIGN KEY (opera) REFERENCES Opera(idOpera),

     correnteArtistica str PRIMARY KEY NOT NULL,
     FOREIGN KEY (correnteArtistica) REFERENCES correnteArtistica(nome)


);



COMMIT;