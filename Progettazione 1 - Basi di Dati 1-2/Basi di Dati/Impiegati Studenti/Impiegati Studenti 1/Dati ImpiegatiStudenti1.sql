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



insert into persona(cf, nome, cognome, data_nascita, is_uomo, is_donna, pos_uomo, maternita)
values
('GLNMRZ77L19H501D', 'Maurizio', 'Ugolini', '1984-09-19', true, false, 'Obiettore di coscienza', NULL),
('FSOSBL99P31H501V', 'Isabella', 'Fois', '1999-12-31', false, true, NULL, 0),
('MNCGNN76D16H501J', 'Giovanni', 'Mancini', '1976-04-16', true, false, 'Assolto', NULL),
('FBRFBR82B29R678A', 'Fabrizio', 'Fabrizi', '1984-02-29', true, false, 'Non tenuto', NULL),
('NVGCLD95U52H501T', 'Claudia', 'Navigli', '1995-09-21', false, true, NULL, 1);

insert into impiegato(persona, stipendio, ruolo)
values
('GLNMRZ77L19H501D', 35000, 'Segretario'),
('FSOSBL99P31H501V', 41000, 'Segretario'),
('NVGCLD95U52H501T', 16000, 'Progettista'),
('FBRFBR82B29R678A', 46000, 'Progettista'),
('MNCGNN76D16H501J', 28000, 'Progettista');


update  progetto 
set resp_prog = 'FBRFBR82B29R678A'
where nome = 'ITiEsse' or nome='Gladio';

