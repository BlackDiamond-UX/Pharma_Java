--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

-- Started on 2021-02-17 10:05:51

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 24607)
-- Name: Article; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Article" (
    id integer NOT NULL,
    nom character varying(50) NOT NULL,
    company character varying(50) NOT NULL,
    price integer NOT NULL,
    qun integer NOT NULL,
    description character varying(200) NOT NULL
);


ALTER TABLE public."Article" OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 24612)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."Article" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2982 (class 0 OID 24607)
-- Dependencies: 200
-- Data for Name: Article; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Article" (id, nom, company, price, qun, description) OVERRIDING SYSTEM VALUE VALUES (8, 'rouiha ayoub', 'Youcode', 100, 100, 'its a good medicine');
INSERT INTO public."Article" (id, nom, company, price, qun, description) OVERRIDING SYSTEM VALUE VALUES (9, 'wed ferra', 'zamal', 300, 2000, 'L7WA');


--
-- TOC entry 2989 (class 0 OID 0)
-- Dependencies: 201
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 9, true);


--
-- TOC entry 2851 (class 2606 OID 24611)
-- Name: Article users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Article"
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


-- Completed on 2021-02-17 10:05:52

--
-- PostgreSQL database dump complete
--

