CREATE DATABASE esami;
\c esami

CREATE DOMAIN posint as INTEGER
   CHECK ( value > 0);


CREATE DOMAIN posintNotNull as posint
  CHECK (value is NOT NULL)


CREATE DOMAIN stingNotNull as posint
  CHECK (value is NOT NULL)


CREATE TYPE Indirizzo as (


    via stingNotNull
    cap CHAR (5),
    civico posintNotNull
);

CREATE SEQUENCE docenteMatSeq;


CREATE TABLE Docente (
    mat INTEGER PRIMARY KEY,
    cognome VARCHAR (100) NOT NULL,
    nome VARCHAR (100) NOT NULL,  
    email VARCHAR (50) NOT NULL
    indirizzo Indirizzo NOT NULL
);


CREATE TABLE Corso (

    codice INTEGER PRIMARY KEY, -- Possiamo inserirlo accanto ad ogni variabile per indicare se un determinato attributo è PRIMARY KEY 
    nome  VARCHAR(100) NOT NULL,
    aula CHAR (2) NOT NULL,
    crediti posint NOT NULL

);

CREATE TABLE Incarico (

    docente INTEGER  NOT NULL,
    corso INTEGER NOT NULL,

    PRIMARY KEY(docente,corso),
    FOREIGN KEY (docente) REFERENCES docente(mat), -- Oppure possimao optare per scriverlo alla fine di ogni parte
    FOREIGN KEY (corso) REFERENCES corso(codice)
);

