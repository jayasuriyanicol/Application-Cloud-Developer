insert into posizionemilitare(nome)
values
('Assolto'),
('Non assolto'),
('Non tenuto'),
('Obiettore di coscienza');


insert into persona(cf, nome, cognome, data_nascita, is_uomo, is_donna, pos_uomo)
values
('RSSMRA77F10H501L', 'Mario', 'Rossi', '1977-06-10', true, false, 'Assolto'),
('VRDGPP89A31H501X', 'Giuseppe', 'Verdi', '1989-01-31', true, false, 'Non tenuto');


insert into persona(cf, nome, cognome, data_nascita, is_uomo, is_donna, maternita)
values
('BNCMRA62R58F839Y', 'Maria', 'Bianchi', '1962-07-28', false, true, 4),
('DRCGNN01T48C678K', 'Giovanna', 'D''Arco', '2001-09-16', false, true, 0);


insert into studente(persona, matricola)
values
('VRDGPP89A31H501X', '1'),
('DRCGNN01T48C678K', '2');


insert into impiegato(persona, stipendio, ruolo)
values
('RSSMRA77F10H501L', 45000, 'Direttore'),
('BNCMRA62R58F839Y', 33000, 'Progettista');


insert into progetto(nome, resp_prog)
values
('Phoenix', 'BNCMRA62R58F839Y'),
('Pegaso', 'BNCMRA62R58F839Y'),
('Manhattan', 'BNCMRA62R58F839Y'),
('ITiEsse', 'BNCMRA62R58F839Y'),
('Gladio', 'BNCMRA62R58F839Y') 
returning id;