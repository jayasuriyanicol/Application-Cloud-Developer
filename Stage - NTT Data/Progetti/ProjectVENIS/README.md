<h1 align="center">VENIS: GESTIONE SUPPLENTI - PROJECT OVERVIEW</h1>

<p align="center">
  <img src="https://mc-8afc6902-e56c-432c-8c3f-3991-cdn-endpoint.azureedge.net/-/media/project/emea/shared/global-logo/globallogo_nttdata_white.png?hash=" alt="NTT DATA Logo" width="300" style="vertical-align: middle;"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <span style="font-size: 22px; font-weight: bold; color: #888; vertical-align: middle;">✕</span>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/Logo%20-%20Venis.png?raw=true" alt="Venis Logo" width="200" style="vertical-align: middle; padding-top: 15px;"/>
</p>

---

## ⚠️ Corporate Disclaimer & Privacy Policy

> **PROPERTY OF NTT DATA Italia - Gov&Tech**
> This repository and its documentation are strictly **private** and intended exclusively for internal knowledge sharing, technical tracking, and personal educational purposes.
> All code snippets, architectural flows, and examples have been **anonymized and de-contextualized** to protect proprietary business logic and sensitive client data.

---

## About the Project: Venis - Gestione Supplenti

The **"Gestione Supplenti"** (Substitute Teachers Management) application is a comprehensive web-based platform developed for **Venis** (Venezia Informatica e Sistemi). 

The primary objective of this system is to digitize, streamline, and manage the complex administrative processes related to the recruitment, availability, and scheduling of substitute teachers for municipal schools and educational facilities. 

<p align="center">
  <br>
  <img src="https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/Logo%20-%20Gestione%20Supplenti.png?raw=true" alt="Gestione Supplenti Logo" width="350"/>
  <br><br>
</p>

The application serves as a centralized hub that connects administrative operators (Back-Office) with the educational staff, ensuring a reliable, transparent, and efficient workflow for academic calendar management, contract assignments, and rule-based generation of school periods.

### Core Modules Developed
* **School Calendar Management:** Full CRUD operations, weekly pattern configurations, and automated generation of academic days.
* **Rules & Exceptions Engine:** A dedicated system to manage holidays, custom constraints, and specific academic rules.
* **Lifecycle & State Management:** Secure transition of entities (e.g., from `DRAFT` to `PUBLISHED`), enforcing strict read-only behaviors and domain guards to prevent data corruption.

---

##  Tech Stack & Architecture

The project follows a modern, decoupled full-stack architecture:

* **Frontend (Client Shell):** Built with **Angular**, utilizing TypeScript and Bootstrap for a responsive, component-driven UI. The frontend interacts strictly via REST APIs, managing complex state changes, dynamic forms, and RxJS-based asynchronous data streams.
* **Backend (REST APIs):** Powered by **Java and Spring Boot**. The backend enforces strict Domain Guards, handles database persistence (via Spring Data JPA/Hibernate), and exposes protected Back-Office (`/api/supplenti-bo/`) endpoints.
* **Database & Infrastructure:** Relational data structures managed via PostgreSQL.

---

## Our Workflow: From Inception to Implementation

Since the beginning of the project, our development lifecycle has been highly structured, iterative, and focused on bridging the gap between design and functional logic:

### 1. UX/IX to Code Translation
Every major feature begins with static **UX/IX wireframes and mockups**. Our initial tasks involved scaffolding the Angular shell and components to match the visual requirements, temporarily using frontend mock data to validate the user flow.

### 2. Milestone-Based Development
To manage complexity, the development was broken down into distinct **Milestones** (e.g., *SCHCAL-1, SCHCAL-2, SCHCAL-3*). Each milestone represented a specific vertical slice of functionality, moving from basic UI shells to complex business rules and API integration.

### 3. Backend Integration & Refactoring
Once the backend services were ready, we shifted from UX/IX mocks to real BE-driven data binding. This required refactoring Angular services, mapping DTOs, and implementing strict UI guards based on backend states (e.g., disabling forms when a calendar is `PUBLISHED`).

### 4. Version Control & Code Quality
We maintained a strict Git workflow via GitLab. A significant part of our process involved **Merge Request (MR) optimization**—surgically cleaning up git histories, squashing intermediate commits, and ensuring that only clean, linear, and production-ready code was merged into the `sviluppo` (development) branch.

---