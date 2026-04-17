-- 1. Database Creation
-- Note: Execute this command separately if your environment requires it.

CREATE DATABASE reflection;
\c reflection;


-- CREATE TABLES 

-- 2. Category Table | Stores product or service categories. Contains idCategory as Primary Key and a description 

CREATE TABLE Category (

    idCategory INT PRIMARY KEY,
    description VARCHAR(255) NOT NULL

);

-- 3. City Table | Stores geographical informatio. Contains cityName as Primary Key and the related region 
CREATE TABLE City (

    cityName VARCHAR(100) PRIMARY KEY,
    region VARCHAR(100) NOT NULL
);

-- 4. ExportType Table This table is used by the Setting class to propose export options.  It facilitates the dynamic loading of exporters via Reflection [cite: 28]
CREATE TABLE ExportType (

    idExport SERIAL PRIMARY KEY, --
    exporterName VARCHAR(50) NOT NULL, -- Matches the Java class name 
    mimeType VARCHAR(50) NOT NULL      -- Associated MIME type 



);

-- INSERT INTO 

-- 5. Seed data for Category Table
INSERT INTO Category (idCategory, description) VALUES 
(1, 'Electronics'),
(2, 'Apparel'),
(3, 'Grocery');

-- 6. Seed data for City Table
INSERT INTO City (cityName, region) VALUES 
('Rome', 'Lazio'),
('Milan', 'Lombardy'),
('Naples', 'Campania');

-- 7. Seed data for ExportType Table | These values must match the concrete implementations of DataExport 
INSERT INTO ExportType (exporterName, mimeType) VALUES 
('CsvExporter', 'text/cvs'),
('JsonExporter', 'application/json');