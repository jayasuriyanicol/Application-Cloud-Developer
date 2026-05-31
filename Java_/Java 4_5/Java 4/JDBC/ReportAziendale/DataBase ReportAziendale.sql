--Giving all data added on postgreSQL, linked to BeeKeeper Studio to manipulate and see correctly and manage the data. 


-- Create Mansioni table
CREATE TABLE Mansioni (
    mansione VARCHAR(50) PRIMARY KEY,
    stipendioMin INT,
    stipendioMax INT
);

-- Create Impiegati table (1 to 1 relationship with Mansioni)
CREATE TABLE Impiegati (
    matricola VARCHAR(10) PRIMARY KEY,
    nome VARCHAR(50),
    salarioMensile INT,
    bonusAnnuale INT,
    mansione VARCHAR(50),
    FOREIGN KEY (mansione) REFERENCES Mansioni(mansione)
);

-- Create ReportValori table (No primary key as requested)
CREATE TABLE ReportValori (
    descrizione VARCHAR(100),
    valore INT
);

-- Insert data into Mansioni

INSERT INTO Mansioni (mansione, stipendioMinimo, stipendioMassimo) VALUES 
('Segretaria', 1200, 1450),
('PrjMng', 1500, 1800);

-- Insert data into Impiegati

INSERT INTO Impiegati (matricola, nome, salarioMensile, bonusAnnuale, mansione) VALUES 
('012', 'Anna', 1000, 100, 'Segretaria'),
('023', 'Pippo', 1600, 0, 'PrjMng');

-- Insert initial values into ReportValori
INSERT INTO ReportValori (descrizione, valore) VALUES 
('numeroImpConBonus', 0),
('totaleStipendiMensili', 0);