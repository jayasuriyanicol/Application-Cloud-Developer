CREATE TABLE Docente (
    mat INTEGER PRIMARY KEY,
    cognome VARCHAR (100) NOT NULL,
    nome VARCHAR (100) NOT NULL,  
    email VARCHAR (50) NOT NULL
);


CREATE TABLE Corso (

    codice INTEGER PRIMARY KEY, -- Possiamo inseirlo accanto ad ogni variabile per indicare se un determinato attributo è PRIMARY KEY 
    nome  VARCHAR(100) NOT NULL,
    aula VARCHAR (2) NOT NULL

);

CREATE TABLE Incarico (

    docente INTEGER  NOT NULL,
    corso INTEGER NOT NULL,

    PRIMARY KEY(docente,corso),
    FOREIGN KEY (docente) REFERENCES docente(mat), -- Oppure possimao optare per scriverlo alla fine di ogni parte
    FOREIGN KEY (corso) REFERENCES corso(codice)
);

