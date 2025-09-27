-- Creazione dei Dati su eBuy

BEGIN TRANSACTION;
SET CONSTRAINTS ALL DEFERRED;

INSERT INTO Categoria(nome, super)
VALUES
('Elettronica', NULL),
('Informatica', 'Elettronica'),
('Laptop', 'Informatica'),
('Casa e giardino', NULL),
('Arredamento', 'Casa e giardino'),
('Giardinaggio', 'Casa e giardino');



INSERT INTO Utente(username, registrazione)
VALUES
('U99001', current_timestamp),
('U99002', current_timestamp),
('U99003', current_timestamp),
('U99004', current_timestamp);


INSERT INTO Privato(utente)
VALUES
('U99001'),
('U99002');


INSERT INTO VenditoreProfessionale(utente, vetrina)
VALUES
('U99003', 'http://www.example.u3.com'),
('U99004', 'http://www.example.u4.com');


COMMIT;