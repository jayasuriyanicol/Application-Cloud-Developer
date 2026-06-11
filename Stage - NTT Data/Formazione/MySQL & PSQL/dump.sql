
-- =========================================================
--  MINI DATABASE SCHEMA FOR EMPLOYEES MANAGEMENT: SQL DUMP
-- =========================================================



-- =========================================================
-- CREATE TABLE
-- =========================================================

CREATE TABLE departments (
    department_id   NUMBER(4)      CONSTRAINT pk_departments PRIMARY KEY,
    department_name VARCHAR2(50)   CONSTRAINT nn_departments_name NOT NULL,
    location        VARCHAR2(50)
);

CREATE TABLE jobs (
    job_id      VARCHAR2(10)   CONSTRAINT pk_jobs PRIMARY KEY,
    job_title   VARCHAR2(50)   CONSTRAINT nn_jobs_title NOT NULL,
    min_salary  NUMBER(8,2),
    max_salary  NUMBER(8,2)
);

CREATE TABLE employees (
    employee_id    NUMBER(6)      CONSTRAINT pk_employees PRIMARY KEY,
    first_name     VARCHAR2(30),
    last_name      VARCHAR2(30)   CONSTRAINT nn_employees_last_name NOT NULL,
    email          VARCHAR2(50)   CONSTRAINT nn_employees_email NOT NULL,
    hire_date      DATE           CONSTRAINT nn_employees_hire_date NOT NULL,
    job_id         VARCHAR2(10)   CONSTRAINT nn_employees_job_id NOT NULL,
    salary         NUMBER(8,2),
    department_id  NUMBER(4),
    commission_pct NUMBER(4,2),

    CONSTRAINT uk_employees_email UNIQUE (email),
    CONSTRAINT fk_employees_jobs
        FOREIGN KEY (job_id) REFERENCES jobs(job_id),
    CONSTRAINT fk_employees_departments
        FOREIGN KEY (department_id) REFERENCES departments(department_id)
);




-----------------------------------------------------------------------------------------



-- =========================================================
-- INSERT DATA - DEPARTMENTS
-- =========================================================

INSERT INTO departments VALUES (10, 'Administration', 'Roma');
INSERT INTO departments VALUES (20, 'Human Resources', 'Milano');
INSERT INTO departments VALUES (30, 'Finance', 'Torino');
INSERT INTO departments VALUES (40, 'Sales', 'Bologna');
INSERT INTO departments VALUES (50, 'IT', 'Roma');
INSERT INTO departments VALUES (60, 'Operations', 'Napoli');
INSERT INTO departments VALUES (80, 'Marketing', 'Milano');
INSERT INTO departments VALUES (90, 'Executive', 'Roma');

-- =========================================================
-- INSERT DATA - JOBS
-- =========================================================

INSERT INTO jobs VALUES ('AD_ASST', 'Administrative Assistant', 2000, 5000);
INSERT INTO jobs VALUES ('HR_SPEC', 'HR Specialist', 2500, 5000);
INSERT INTO jobs VALUES ('FI_ACCOUNT', 'Accountant', 3000, 7000);
INSERT INTO jobs VALUES ('SA_REP', 'Sales Representative', 2500, 9000);
INSERT INTO jobs VALUES ('IT_PROG', 'Programmer', 3500, 8000);
INSERT INTO jobs VALUES ('OP_SPEC', 'Operations Specialist', 2500, 6000);
INSERT INTO jobs VALUES ('MK_SPEC', 'Marketing Specialist', 2800, 6500);
INSERT INTO jobs VALUES ('AD_EXEC', 'Executive', 8000, 20000);

-- =========================================================
-- INSERT DATA - EMPLOYEES
-- =========================================================

INSERT INTO employees VALUES (101, 'Mario',   'Rossi',     'mrossi@company.it',   DATE '2019-03-15', 'IT_PROG',    3200, 50, NULL);
INSERT INTO employees VALUES (102, 'Laura',   'Bianchi',   'lbianchi@company.it', DATE '2018-07-10', 'HR_SPEC',    2900, 20, NULL);
INSERT INTO employees VALUES (103, 'Luca',    'Verdi',     'lverdi@company.it',   DATE '2020-01-20', 'IT_PROG',    3500, 50, NULL);
INSERT INTO employees VALUES (104, 'Anna',    'Neri',      'aneri@company.it',    DATE '2017-11-05', 'FI_ACCOUNT', 3100, 30, NULL);
INSERT INTO employees VALUES (105, 'Paolo',   'Seri',      'pseri@company.it',    DATE '2015-02-01', 'AD_ASST',    2600, 10, NULL);
INSERT INTO employees VALUES (106, 'Giulia',  'Marini',    'gmarini@company.it',  DATE '2021-06-14', 'SA_REP',     4200, 40, 0.10);
INSERT INTO employees VALUES (107, 'Stefano', 'Sala',      'ssala@company.it',    DATE '2016-09-09', 'SA_REP',     5200, 40, 0.15);
INSERT INTO employees VALUES (108, 'Elena',   'Conti',     'econti@company.it',   DATE '2014-04-18', 'AD_EXEC',   12000, 90, NULL);
INSERT INTO employees VALUES (109, 'Marco',   'Fontana',   'mfontana@company.it', DATE '2013-12-02', 'AD_EXEC',   15000, 90, NULL);
INSERT INTO employees VALUES (110, 'Sara',    'Greco',     'sgreco@company.it',   DATE '2022-03-21', 'MK_SPEC',    3300, 80, NULL);
INSERT INTO employees VALUES (111, 'Davide',  'Gallo',     'dgallo@company.it',   DATE '2019-10-30', 'OP_SPEC',    2800, 60, NULL);
INSERT INTO employees VALUES (112, 'Chiara',  'Ferri',     'cferri@company.it',   DATE '2011-05-12', 'FI_ACCOUNT', 6800, 30, NULL);
INSERT INTO employees VALUES (113, 'Alessio', 'Rinaldi',   'arinaldi@company.it', DATE '2009-08-17', 'IT_PROG',    7200, 50, NULL);
INSERT INTO employees VALUES (114, 'Silvia',  'Sanna',     'ssanna@company.it',   DATE '2010-01-25', 'HR_SPEC',    4100, 20, NULL);
INSERT INTO employees VALUES (115, 'Fabio',   'Amato',     'famato@company.it',   DATE '2007-06-01', 'SA_REP',     9800, 40, 0.20);
INSERT INTO employees VALUES (116, 'Irene',   'Romano',    'iromano@company.it',  DATE '2004-09-13', 'AD_EXEC',   18000, 90, NULL);
INSERT INTO employees VALUES (117, 'Matteo',  'Leone',     'mleone@company.it',   DATE '2001-02-19', 'OP_SPEC',    3900, 60, NULL);
INSERT INTO employees VALUES (118, 'Andrea',  'Sarti',     'asarti@company.it',   DATE '2003-07-07', 'IT_PROG',    5400, 50, NULL);
INSERT INTO employees VALUES (119, 'Valeria', 'Serra',     'vserra@company.it',   DATE '2005-10-22', 'MK_SPEC',    4600, 80, NULL);
INSERT INTO employees VALUES (120, 'Roberto', 'Casini',    'rcasini@company.it',  DATE '2000-12-11', 'FI_ACCOUNT', 5100, 30, NULL);

COMMIT;