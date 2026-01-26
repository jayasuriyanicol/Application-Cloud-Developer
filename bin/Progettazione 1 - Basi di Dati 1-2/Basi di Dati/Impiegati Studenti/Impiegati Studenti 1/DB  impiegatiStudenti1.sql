CREATE DATABASE ImpiegatiStudenti1;

\c ImpiegatiStudenti1



BEGIN TRANSACTION
SET CONSTRAINTS ALL DEFERRED;

-- CREAZIONE DELLE TABELLE 

CREATE TABLE PosizioneMilitare(
    
    nome Stringa PRIMARY KEY

);

CREATE TABLE Persona(
    cf CodiceFiscale PRIMARY KEY,
    nome Stringa NOT NULL,
    cognome Stringa NOT NULL,
    data_nascita DATE NOT NULL,
    maternita IntGEZ,
    is_uomo BOOLEAN NOT NULL,
    is_donna BOOLEAN NOT NULL,
    pos_uomo Stringa,

    FOREIGN KEY(pos_uomo) REFERENCES PosizioneMilitare(nome)

    CHECK(
        
        (is_uomo= TRUE)
        =
        (pos_uomo is NOT NULL)
        
        -- Stessa cosa equivalente ma in maniera più lunga e poco intepretabile, ma con lo stesso ragionamento
           --(is_uomo = TRUE and pos_uomo si NOT NULL) OR (is_uomo = FALSE and pos_uomo is NULL)
    ),


    CHECK(
        
        (is_donna = TRUE)
        =
        (maternita is NOT NULL)

        
        
        -- Stessa cosa equivalente ma in maniera più lunga e poco intepretabile, ma con lo stesso ragionamento
           --(is_donna = TRUE and maternita si NOT NULL) OR (is_donna = FALSE and maternita is NULL)
    ),


    CHECK (is_uomo = TRUE or is_donna = TRUE)

);


CREATE TABLE Studente(
    Persona CodiceFiscale PRIMARY KEY,
    FOREIGN KEY (Persona) REFERENCES Persona(cf), 
    matricola INTGEZ NOT NULL, 
    UNIQUE(matricola)
);



CREATE TABLE Impiegato(
    Persona CodiceFiscale PRIMARY KEY,
    FOREIGN KEY (Persona) REFERENCES Persona(cf), 
    stipendio RealGEZ NOT NULL, 
    Ruolo ruolo NOT NULL
);


CREATE TABLE Progetto(
    id SERIAL PRIMARY KEY,
    nome Stringa NOT NULL,

    resp_prog CodiceFiscale NOT NULL,
    FOREIGN KEY (resp_prog) REFERENCES Impiegato

);


-- Vincoli non implementabili direttamente nello schema relazione:


   --[V.Impiegato.Progettista.responsabile] 

   --Per ogni i:Impiegato 
   --se i è coinvolto in un link resp_prof
   --allore i.ruolo=  'Progettista'


