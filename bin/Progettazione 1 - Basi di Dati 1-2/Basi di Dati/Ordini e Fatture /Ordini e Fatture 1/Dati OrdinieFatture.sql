BEGIN TRANSACTION;
SET CONSTRAINTS ALL DEFERRED;

-- Insert della NAZIONE

INSERT INTO Nazione (nome) VALUES
('Italia');

-- Insert delle REGIONI

INSERT INTO Regione (nome, nazione) VALUES
('Lombardia', 'Italia'),
('Lazio', 'Italia');

-- Insert CITTÀ ITALIANE

INSERT INTO Citta (nome, regione, nazione) VALUES
('Milano', 'Lombardia', 'Italia'),
('Bergamo', 'Lombardia', 'Italia'),
('Brescia', 'Lombardia', 'Italia'),
('Roma', 'Lazio', 'Italia'),
('Fiumicino', 'Lazio', 'Italia');

COMMIT;


BEGIN TRANSACTION;
SET CONSTRAINTS ALL DEFERRED;


INSERT INTO Direttore (nome, cognome, cf, data_nascita, anni_servizio, citta_nasc, regione_nasc, nazione_nasc) VALUES
('Luca', 'Bianchi', 'BNCLCU85A01H501U', '1985-01-01', 10, 'Milano', 'Lombardia', 'Italia'),
('Anna', 'Rossi', 'RSSNNA80B05H501D', '1980-02-05', 15, 'Roma', 'Lazio', 'Italia'),
('Marco', 'Verdi', 'VRDMRC75C12H501B', '1975-03-12', 20, 'Bergamo', 'Lombardia', 'Italia'),
('Elisa', 'Ferrari', 'FRRELS90D30H501C', '1990-04-30', 5, 'Brescia', 'Lombardia', 'Italia'),
('Giovanni', 'Fontana', 'FNTGNN88E25H501E', '1988-05-25', 12, 'Milano', 'Lombardia', 'Italia'),
('Chiara', 'Costa', 'CTSCHR92F10H501F', '1992-06-10', 7, 'Roma', 'Lazio', 'Italia'),
('Alessandro', 'Galli', 'GLLALD84G15H501G', '1984-07-15', 11, 'Fiumicino', 'Lazio', 'Italia'),
('Francesca', 'Lombardi', 'LMBFRN83H22H501H', '1983-08-22', 14, 'Fiumicino', 'Lazio', 'Italia'),
('Matteo', 'Conti', 'CNTMTT81I01H501I', '1981-09-01', 18, 'Fiumicino', 'Lazio', 'Italia'),
('Sara', 'De Luca', 'DLSRAA79L12H501J', '1979-10-12', 22, 'Brescia', 'Lombardia', 'Italia');

COMMIT;


BEGIN TRANSACTION;
SET CONSTRAINTS ALL DEFERRED;


INSERT INTO Dipartimento (nome, indirizzo, direttore) VALUES
('Ingegneria', ('Via Roma', '10', '20121'), 'BNCLCU85A01H501U'),
('Marketing', ('Via Milano', '22', '20122'), 'RSSNNA80B05H501D'),
('Risorse Umane', ('Via Torino', '5', '20123'), 'VRDMRC75C12H501B'),
('Finanza', ('Via Firenze', '12', '20124'), 'FRRELS90D30H501C'),
('Ricerca', ('Via Napoli', '3', '20125'), 'FNTGNN88E25H501E'),
('Produzione', ('Via Genova', '8', '20126'), 'CTSCHR92F10H501F'),
('Logistica', ('Via Venezia', '15', '20127'), 'GLLALD84G15H501G'),
('Qualità', ('Via Bologna', '20', '20128'), 'LMBFRN83H22H501H'),
('Assistenza Clienti', ('Via Torino', '7', '20129'), 'FRRELS90D30H501C'),
('Sviluppo Prodotto', ('Via Modena', '14', '20130'), 'GLLALD84G15H501G'),
('Controllo Qualità', ('Via Padova', '9', '20131'), 'BNCLCU85A01H501U');

COMMIT;



BEGIN TRANSACTION;
SET CONSTRAINTS ALL DEFERRED;


INSERT INTO Fornitore (ragione_sociale, partita_iva, indirizzo, telefono, email) VALUES
('Tech Solutions S.r.l.', '12345678901', ('Via Roma', '45', '00100'), '+39 0612345678', 'info@techsolutions.it'),
('Green Energy Spa', '98765432109', ('Via Milano', '12', '20121'), '+39 0212345678', 'contact@greenenergy.it'),
('Food Supplies S.p.A.', '45678912345', ('Via Torino', '7', '10121'), '+39 0112345678', 'sales@foodsupplies.it'),
('BuildIt S.r.l.', '32165498765', ('Via Napoli', '23', '80100'), '+39 0812345678', 'support@buildit.it'),
('Office Equipments Spa', '78912345678', ('Via Firenze', '18', '50121'), '+39 0551234567', 'office@officeequipments.it'),
('HealthCare Services S.r.l.', '65498732100', ('Via Genova', '4', '16121'), '+39 0109876543', 'info@healthcare.it'),
('AutoParts S.p.A.', '14725836901', ('Via Venezia', '10', '30121'), '+39 0411234567', 'sales@autoparts.it'),
('Clean Solutions S.r.l.', '36985214700', ('Via Bologna', '5', '40121'), '+39 0517654321', 'contact@cleansolutions.it'),
('Tech Innovations Spa', '25836914702', ('Via Padova', '27', '35121'), '+39 0492345678', 'innovations@techinnovations.it'),
('Smart Logistics S.p.A.', '36914725803', ('Via Pisa', '30', '56121'), '+39 0501234567', 'logistics@smartlogistics.it');

COMMIT;


BEGIN TRANSACTION;
SET CONSTRAINTS ALL DEFERRED;


INSERT INTO Ordine (id, data_stipula, imponibile, aliquotaIVA, descrizione, stato, fornitore, dipartimento) VALUES
(1, '2025-01-10', 1000.00, 0.22, 'Acquisto computer', 'in preparazione', '12345678901', 'Ingegneria'),
(2, '2025-01-15', 1500.50, 0.22, 'Materiale ufficio', 'inviato', '98765432109', 'Marketing'),
(3, '2025-01-20', 750.75, 0.22, 'Servizi di consulenza', 'da saldare', '45678912345', 'Risorse Umane'),
(4, '2025-01-22', 2000.00, 0.22, 'Acquisto software', 'saldato', '32165498765', 'Finanza'),
(5, '2025-01-25', 500.00, 0.22, 'Manutenzione hardware', 'in preparazione', '78912345678', 'Ricerca'),
(6, '2025-02-01', 1200.00, 0.22, 'Servizi di trasporto', 'inviato', '65498732100', 'Produzione'),
(7, '2025-02-05', 1300.00, 0.22, 'Forniture elettriche', 'da saldare', '14725836901', 'Logistica'),
(8, '2025-02-10', 900.00, 0.22, 'Materiali per laboratorio', 'saldato', '36985214700', 'Qualità'),
(9, '2025-02-12', 850.00, 0.22, 'Formazione personale', 'in preparazione', '25836914702', 'Ingegneria'),
(10, '2025-02-15', 600.00, 0.22, 'Servizi IT', 'inviato', '36914725803', 'Marketing'),

(11, '2025-02-20', 1100.00, 0.22, 'Acquisto server', 'da saldare', '12345678901', 'Risorse Umane'),
(12, '2025-02-22', 1400.00, 0.22, 'Materiale cancelleria', 'saldato', '98765432109', 'Finanza'),
(13, '2025-02-25', 500.00, 0.22, 'Consulenza legale', 'in preparazione', '45678912345', 'Ricerca'),
(14, '2025-03-01', 1750.00, 0.22, 'Acquisto PC portatili', 'inviato', '32165498765', 'Produzione'),
(15, '2025-03-05', 950.00, 0.22, 'Servizi di pulizia', 'da saldare', '78912345678', 'Logistica'),
(16, '2025-03-10', 1250.00, 0.22, 'Materiale elettrico', 'saldato', '65498732100', 'Qualità'),
(17, '2025-03-15', 1350.00, 0.22, 'Software gestionale', 'in preparazione', '14725836901', 'Ingegneria'),
(18, '2025-03-20', 800.00, 0.22, 'Servizi di consulenza', 'inviato', '36985214700', 'Marketing'),
(19, '2025-03-25', 700.00, 0.22, 'Acquisto materiali', 'da saldare', '25836914702', 'Risorse Umane'),
(20, '2025-03-30', 650.00, 0.22, 'Manutenzione rete', 'saldato', '36914725803', 'Finanza'),

(21, '2025-04-02', 1150.00, 0.22, 'Formazione dipendenti', 'in preparazione', '12345678901', 'Ricerca'),
(22, '2025-04-05', 1450.00, 0.22, 'Acquisto stampanti', 'inviato', '98765432109', 'Produzione'),
(23, '2025-04-10', 550.00, 0.22, 'Materiale ufficio', 'da saldare', '45678912345', 'Logistica'),
(24, '2025-04-15', 1850.00, 0.22, 'Servizi IT', 'saldato', '32165498765', 'Qualità'),
(25, '2025-04-20', 1000.00, 0.22, 'Acquisto software', 'in preparazione', '78912345678', 'Ingegneria'),
(26, '2025-04-25', 1300.00, 0.22, 'Servizi di consulenza', 'inviato', '65498732100', 'Marketing'),
(27, '2025-04-30', 900.00, 0.22, 'Materiale cancelleria', 'da saldare', '14725836901', 'Risorse Umane'),
(28, '2025-05-05', 600.00, 0.22, 'Manutenzione hardware', 'saldato', '36985214700', 'Finanza'),
(29, '2025-05-10', 1150.00, 0.22, 'Acquisto PC', 'in preparazione', '25836914702', 'Ricerca'),
(30, '2025-05-15', 1400.00, 0.22, 'Servizi di trasporto', 'inviato', '36914725803', 'Produzione'),

(31, '2025-05-20', 750.00, 0.22, 'Materiali elettrici', 'da saldare', '12345678901', 'Logistica'),
(32, '2025-05-25', 1700.00, 0.22, 'Formazione personale', 'saldato', '98765432109', 'Qualità'),
(33, '2025-06-01', 900.00, 0.22, 'Acquisto server', 'in preparazione', '45678912345', 'Ingegneria'),
(34, '2025-06-05', 1250.00, 0.22, 'Materiale cancelleria', 'inviato', '32165498765', 'Marketing'),
(35, '2025-06-10', 1100.00, 0.22, 'Consulenza legale', 'da saldare', '78912345678', 'Risorse Umane'),
(36, '2025-06-15', 1350.00, 0.22, 'Acquisto PC portatili', 'saldato', '65498732100', 'Finanza'),
(37, '2025-06-20', 850.00, 0.22, 'Servizi di pulizia', 'in preparazione', '14725836901', 'Ricerca'),
(38, '2025-06-25', 1600.00, 0.22, 'Acquisto software', 'inviato', '36985214700', 'Produzione'),
(39, '2025-06-30', 700.00, 0.22, 'Manutenzione rete', 'da saldare', '25836914702', 'Logistica'),
(40, '2025-07-05', 950.00, 0.22, 'Servizi IT', 'saldato', '36914725803', 'Qualità');

COMMIT;

BEGIN TRANSACTION;
SET CONSTRAINTS ALL DEFERRED;



INSERT INTO Ordine (id, data_stipula, imponibile, aliquotaIVA, descrizione, stato, fornitore, dipartimento) VALUES
(41, '2025-07-10', 1100.00, 0.22, 'Acquisto computer', 'in preparazione', '12345678901', 'Ingegneria'),
(42, '2025-07-12', 1600.50, 0.22, 'Materiale ufficio', 'inviato', '98765432109', 'Marketing'),
(43, '2025-07-15', 800.75, 0.22, 'Servizi di consulenza', 'da saldare', '45678912345', 'Risorse Umane'),
(44, '2025-07-18', 2100.00, 0.22, 'Acquisto software', 'saldato', '32165498765', 'Finanza'),
(45, '2025-07-20', 600.00, 0.22, 'Manutenzione hardware', 'in preparazione', '78912345678', 'Ricerca'),
(46, '2025-07-25', 1250.00, 0.22, 'Servizi di trasporto', 'inviato', '65498732100', 'Produzione'),
(47, '2025-07-28', 1350.00, 0.22, 'Forniture elettriche', 'da saldare', '14725836901', 'Logistica'),
(48, '2025-07-30', 950.00, 0.22, 'Materiali per laboratorio', 'saldato', '36985214700', 'Qualità'),
(49, '2025-08-02', 900.00, 0.22, 'Formazione personale', 'in preparazione', '25836914702', 'Ingegneria'),
(50, '2025-08-05', 650.00, 0.22, 'Servizi IT', 'inviato', '36914725803', 'Marketing'),

(51, '2025-08-08', 1150.00, 0.22, 'Acquisto server', 'da saldare', '12345678901', 'Risorse Umane'),
(52, '2025-08-10', 1450.00, 0.22, 'Materiale cancelleria', 'saldato', '98765432109', 'Finanza'),
(53, '2025-08-12', 600.00, 0.22, 'Consulenza legale', 'in preparazione', '45678912345', 'Ricerca'),
(54, '2025-08-15', 1800.00, 0.22, 'Acquisto PC portatili', 'inviato', '32165498765', 'Produzione'),
(55, '2025-08-18', 1000.00, 0.22, 'Servizi di pulizia', 'da saldare', '78912345678', 'Logistica'),
(56, '2025-08-22', 1300.00, 0.22, 'Materiale elettrico', 'saldato', '65498732100', 'Qualità'),
(57, '2025-08-25', 1400.00, 0.22, 'Software gestionale', 'in preparazione', '14725836901', 'Ingegneria'),
(58, '2025-08-28', 850.00, 0.22, 'Servizi di consulenza', 'inviato', '36985214700', 'Marketing'),
(59, '2025-08-30', 750.00, 0.22, 'Acquisto materiali', 'da saldare', '25836914702', 'Risorse Umane'),
(60, '2025-09-01', 700.00, 0.22, 'Manutenzione rete', 'saldato', '36914725803', 'Finanza'),

(61, '2025-09-05', 1200.00, 0.22, 'Formazione dipendenti', 'in preparazione', '12345678901', 'Ricerca'),
(62, '2025-09-08', 1500.00, 0.22, 'Acquisto stampanti', 'inviato', '98765432109', 'Produzione'),
(63, '2025-09-10', 650.00, 0.22, 'Materiale ufficio', 'da saldare', '45678912345', 'Logistica'),
(64, '2025-09-12', 1900.00, 0.22, 'Servizi IT', 'saldato', '32165498765', 'Qualità'),
(65, '2025-09-15', 1050.00, 0.22, 'Acquisto software', 'in preparazione', '78912345678', 'Ingegneria'),
(66, '2025-09-18', 1350.00, 0.22, 'Servizi di consulenza', 'inviato', '65498732100', 'Marketing'),
(67, '2025-09-20', 950.00, 0.22, 'Materiale cancelleria', 'da saldare', '14725836901', 'Risorse Umane'),
(68, '2025-09-22', 650.00, 0.22, 'Manutenzione hardware', 'saldato', '36985214700', 'Finanza'),
(69, '2025-09-25', 1200.00, 0.22, 'Acquisto PC', 'in preparazione', '25836914702', 'Ricerca'),
(70, '2025-09-28', 1450.00, 0.22, 'Servizi di trasporto', 'inviato', '36914725803', 'Produzione'),

(71, '2025-10-01', 800.00, 0.22, 'Materiali elettrici', 'da saldare', '12345678901', 'Logistica'),
(72, '2025-10-05', 1750.00, 0.22, 'Formazione personale', 'saldato', '98765432109', 'Qualità'),
(73, '2025-10-08', 950.00, 0.22, 'Acquisto server', 'in preparazione', '45678912345', 'Ingegneria'),
(74, '2025-10-10', 1300.00, 0.22, 'Materiale cancelleria', 'inviato', '32165498765', 'Marketing'),
(75, '2025-10-12', 1150.00, 0.22, 'Consulenza legale', 'da saldare', '78912345678', 'Risorse Umane'),
(76, '2025-10-15', 1400.00, 0.22, 'Acquisto PC portatili', 'saldato', '65498732100', 'Finanza'),
(77, '2025-10-18', 900.00, 0.22, 'Servizi di pulizia', 'in preparazione', '14725836901', 'Ricerca'),
(78, '2025-10-20', 1650.00, 0.22, 'Acquisto software', 'inviato', '36985214700', 'Produzione'),
(79, '2025-10-22', 750.00, 0.22, 'Manutenzione rete', 'da saldare', '25836914702', 'Logistica'),
(80, '2025-10-25', 1000.00, 0.22, 'Servizi IT', 'saldato', '36914725803', 'Qualità');

COMMIT;

BEGIN TRANSACTION;
SET CONSTRAINTS ALL DEFERRED;


INSERT INTO Ordine (id, data_stipula, imponibile, aliquotaIVA, descrizione, stato, fornitore, dipartimento) VALUES
(81, '2025-11-01', 500.00, 0.10, 'Acquisto toner', 'in preparazione', '12345678901', 'Ingegneria'),
(82, '2025-11-01', 500.00, 0.10, 'Materiale cancelleria', 'inviato', '98765432109', 'Marketing'),
(83, '2025-11-01', 500.00, 0.10, 'Servizi di pulizia', 'da saldare', '45678912345', 'Risorse Umane'),
(84, '2025-11-05', 750.00, 0.10, 'Formazione personale', 'saldato', '32165498765', 'Finanza'),
(85, '2025-11-08', 750.00, 0.10, 'Manutenzione hardware', 'in preparazione', '78912345678', 'Ricerca'),
(86, '2025-11-10', 750.00, 0.10, 'Servizi IT', 'inviato', '65498732100', 'Produzione'),
(87, '2025-11-12', 750.00, 0.10, 'Acquisto software', 'da saldare', '14725836901', 'Logistica'),
(88, '2025-11-15', 400.00, 0.10, 'Materiale elettrico', 'saldato', '36985214700', 'Qualità'),
(89, '2025-11-18', 300.00, 0.10, 'Consulenza legale', 'in preparazione', '25836914702', 'Ingegneria'),
(90, '2025-11-20', 600.00, 0.10, 'Acquisto PC', 'inviato', '36914725803', 'Marketing');

COMMIT;