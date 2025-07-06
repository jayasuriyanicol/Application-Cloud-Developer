--
-- PostgreSQL database dump
--

-- Dumped from database version 17.3
-- Dumped by pg_dump version 17.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: posint; Type: DOMAIN; Schema: public; Owner: postgres
--

CREATE DOMAIN public.posint AS integer
	CONSTRAINT posint_check CHECK ((VALUE > 0));


ALTER DOMAIN public.posint OWNER TO postgres;

--
-- Name: posint_not_null; Type: DOMAIN; Schema: public; Owner: postgres
--

CREATE DOMAIN public.posint_not_null AS public.posint
	CONSTRAINT posint_not_null_check CHECK ((VALUE IS NOT NULL));


ALTER DOMAIN public.posint_not_null OWNER TO postgres;

--
-- Name: string_not_null; Type: DOMAIN; Schema: public; Owner: postgres
--

CREATE DOMAIN public.string_not_null AS character varying(255)
	CONSTRAINT string_not_null_check CHECK ((VALUE IS NOT NULL));


ALTER DOMAIN public.string_not_null OWNER TO postgres;

--
-- Name: indirizzo; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.indirizzo AS (
	via public.string_not_null,
	cap character(5),
	civico public.posint_not_null
);


ALTER TYPE public.indirizzo OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: corso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.corso (
    codice integer NOT NULL,
    nome character varying NOT NULL,
    aula character varying(2) NOT NULL
);


ALTER TABLE public.corso OWNER TO postgres;

--
-- Name: docente_mat_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.docente_mat_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.docente_mat_seq OWNER TO postgres;

--
-- Name: docente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.docente (
    mat integer DEFAULT nextval('public.docente_mat_seq'::regclass) NOT NULL,
    nome character varying(100) NOT NULL,
    cognome character varying(100) NOT NULL,
    email character varying(100) NOT NULL
);


ALTER TABLE public.docente OWNER TO postgres;

--
-- Name: incarico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.incarico (
    docente integer NOT NULL,
    corso integer NOT NULL
);


ALTER TABLE public.incarico OWNER TO postgres;

--
-- Data for Name: corso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.corso (codice, nome, aula) FROM stdin;
\.


--
-- Data for Name: docente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.docente (mat, nome, cognome, email) FROM stdin;
1	Mario	Rossi	mariorossi@yahoo.com
3	Luigi	Verdi	lverdi@me.com
\.


--
-- Data for Name: incarico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.incarico (docente, corso) FROM stdin;
\.


--
-- Name: docente_mat_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.docente_mat_seq', 3, true);


--
-- Name: corso corso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.corso
    ADD CONSTRAINT corso_pkey PRIMARY KEY (codice);


--
-- Name: docente docente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.docente
    ADD CONSTRAINT docente_pkey PRIMARY KEY (mat);


--
-- Name: incarico incarico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.incarico
    ADD CONSTRAINT incarico_pkey PRIMARY KEY (docente, corso);


--
-- Name: incarico incarico_corso_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.incarico
    ADD CONSTRAINT incarico_corso_fkey FOREIGN KEY (corso) REFERENCES public.corso(codice);


--
-- Name: incarico incarico_docente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.incarico
    ADD CONSTRAINT incarico_docente_fkey FOREIGN KEY (docente) REFERENCES public.docente(mat);


--
-- PostgreSQL database dump complete
--