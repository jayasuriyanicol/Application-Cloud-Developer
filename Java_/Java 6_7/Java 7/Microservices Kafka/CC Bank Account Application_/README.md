

# 🏦 SpringCCBankAccount - Bank Management System

This project is a full-stack web application designed to manage bank current accounts. It features automated penalty calculations (overdraft fees), transaction management, and a restricted Administrative Dashboard (Root) for global bank monitoring.

## 1.Project Architecture

The project follows a **Decoupled Client-Server** architecture:

- **Backend**: RESTful APIs developed with Spring Boot.

- **Frontend**: Single Page Application (SPA) built with React/Vite.

- **Database**: Relational (PostgreSQL) for data persistence.

---

## Technology Stack

### Backend (Spring Boot)

- **Java 17+ (using also > Java 17)**

- **Spring Data JPA**: For database interaction and ORM.

- **Lombok**: To reduce boilerplate code (Getters, Setters, Constructors).

- **Jackson**: For JSON serialization management (handling recursions via `@JsonManagedReference` / `@JsonBackReference`).

- **PostgreSQL Driver**: For database connectivi
### Database (PostgreSQL)

- Relational schema with `OneToMany` relationships (Account -> Transactions).

- Integrity constraints between Users and Bank Accounts.

### Frontend (React)

- **Vite**: Ultra-fast build tool for the frontend.

- **React Router Dom**: For navigation management (Dashboard, Registration, Root Area).

- **Axios**: For making HTTP requests to the backend.

- **CSS3 / Flexbox / Conic-Gradients**: For responsive dashboard design and dynamic pie charts.

---

## TEST | STEPS NEED IT 

### 1. Prerequisites

Ensure you have the following installed:
- [JDK 17 or higher] (https://www.oracle.com/java/technologies/downloads/)
- [Node.js & npm] (https://nodejs.org/)
- [PostgreSQL] (https://www.postgresql.org/download/)
- An IDE (IntelliJ IDEA, VS Code, or Eclipse)

---

### 2. Database Configuration, note: using exactly (**banca_db**)

1. Create a database named `banca_db` in PostgreSQL.

2. Configure your credentials in: `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/banca_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

### 3. Running the Backend (Spring Boot)

From the backend root directory:

```bash
# Using Maven Wrapper
./mvnw spring-boot:run

# Or run the compiled JAR
java -jar target/project-name.jar
```
*The API will be available at:* `http://localhost:8080`

---

### 4. Running the Frontend (Vite)
From the frontend directory:

```bash
# Install dependencies (first time only)
npm install

# Start the development server
npm run dev
```
*The interface will be available at:* `http://localhost:5173`

---

## Documented Features

### 👤 User Side
- **User Registration**: Create a customer profile with full address and contact details.
- **Account Opening**: Associate a unique account number with an existing user.
- **Transaction Dashboard**: Real-time balance updates and transaction history (Deposits/Withdrawals).

### ⚙️ Business Logic (Overdraft Fee/Mora)
- The system automatically applies a **5% penalty (overdraft fee)** on every withdrawal if the account balance is negative (below zero).

### 🔑 Administrator Area (Root)
- **Protected Access**: Secure login with "Show/Hide Password" functionality.
- **Global Overview**: View the total liquidity currently held by the bank.
- **Pie Chart Analysis**: Visual breakdown of healthy accounts vs. accounts in overdraft (negative balance).
- **Extended Records**: Access to sensitive customer data (email, phone, home address) for administrative purposes.

---

## 📂 Project Structure

```text
├── backend/
│   ├── src/main/java/com/banca/
│   │   ├── controller/      # REST Endpoints
│   │   ├── model/           # Entities (Account, Transaction, User)
│   │   ├── dto/             # Data Transfer Objects
│   │   └── service/         # Business logic and fee calculations
│   └── pom.xml
├── frontend/
│   ├── src/
│   │   ├── components/      # React Components (Dashboard, AdminPanoramica, etc.)
│   │   ├── services/        # Axios configuration (api.js)
│   │   └── App.jsx          # Main Routes and Layout
│   └── package.json
└── README.md
```

