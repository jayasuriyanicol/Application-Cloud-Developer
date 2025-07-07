-- CREAZIONE DEL DataBase ACCADEMIA 3+

--CREAZIONE DELL'INSIEME DEI Domini:

CREATE TYPE Strutturato as ENUM ("Ricercatore","Professore Associato","Professore Ordinario");

CREATE TYPE LavoroProgetto as ENUM ('Ricerca e Sviluppo', 'Dimostrazione', 'Management', 'Altro');

CREATE TYPE LavoroNonProgettuale as ENUM ('Didattica','Ricerca','Missione','Incontro Dipartimentale', 'Incontro Accademico')

CREATE TYPE CausaAssenza as ENUM ('Chiusura Universitaria', 'Maternita', 'Malattia');

CREATE DOMAIN PosInteger as INTEGER:
   CHECK (value > 0);
