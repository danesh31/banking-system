<a id="readme-top"></a>

<div align="center">

# 🏦 Online Banking System

### Secure Backend Application using Spring Boot & JWT

<br/>

<a href="https://github.com/Vishnu-C-10/online-banking-system">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge"/>
</a>
<a href="#">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge"/>
</a>
<a href="#">
  <img src="https://img.shields.io/badge/JWT-Security-blue?style=for-the-badge"/>
</a>
<a href="#">
  <img src="https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge"/>
</a>
<a href="#">
  <img src="https://img.shields.io/badge/Status-Completed-success?style=for-the-badge"/>
</a>

<br/><br/>

A **production-style backend banking system**  
focused on **security, clean architecture, and real-world backend design**.

</div>

---

## 📑 Table of Contents
- [About The Project](#about-the-project)
- [Built With](#built-with)
- [Modules](#modules)
- [Authentication Flow](#authentication-flow)
- [Architecture](#architecture)
- [API Endpoints](#api-endpoints)
- [Getting Started](#getting-started)
- [What I Learned](#what-i-learned)
- [Contact](#contact)

---

## 📌 About The Project

This project is a **backend-only Online Banking System** built using **Spring Boot**.

It demonstrates how real banking systems handle:
- User authentication
- Account operations
- Transactions
- Secure API access using JWT

> Frontend is intentionally excluded to focus purely on backend engineering.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## 🛠️ Built With

- Java  
- Spring Boot  
- Spring Security  
- JWT (JSON Web Token)  
- Spring Data JPA  
- MySQL  
- Maven  

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## 🧩 Modules

### 👤 User Module
- User registration
- User login

### 🏦 Account Module
- Account creation
- Deposit
- Withdraw
- Transfer

### 📜 Transaction Module
- Transaction history
- Audit trail

### 🔐 Security Module
- JWT token generation
- JWT token validation

### ⚠️ Exception Module
- Global exception handling

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## 🔐 Authentication Flow

Login request  
→ JWT token generated  
→ Client stores token  
→ Token sent in Authorization header  
→ JWT filter validates token  
→ Access granted or denied  

✔ Stateless  
✔ Secure  
✔ Industry standard  

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## 🏗️ Architecture

Controller  
→ Service  
→ Repository  
→ Database  

Clean separation of responsibilities with layered architecture.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## 🔌 API Endpoints

### Authentication
- POST `/users`
- POST `/login`

### Accounts
- POST `/accounts/{userId}`
- PUT `/accounts/deposit/{accountId}`
- PUT `/accounts/withdraw/{accountId}`
- PUT `/accounts/transfer`

### Transactions
- GET `/accounts/{accountId}/transactions` (secured)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## ▶️ Getting Started

### Prerequisites
- Java 21
- MySQL
- Maven
- Postman

### Installation

1. Clone the repository  
   `git clone https://github.com/Vishnu-C-10/online-banking-system.git`

2. Import as Maven project in Eclipse / IntelliJ

3. Create database  
   `online_banking_db`

4. Configure database locally in `application.properties`  
   (credentials not committed)

5. Run `OnlineBankingSystemApplication.java`

6. Test APIs using Postman

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## 📚 What I Learned

- Spring Boot REST API development
- JWT authentication & authorization
- Secure backend design
- Layered architecture
- MySQL with JPA
- Real-world backend practices

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## 📞 Contact

**Vishnu C**  
vishnuc234567@gmail.com  

Project Link:  
https://github.com/Vishnu-C-10/online-banking-system

<p align="right">(<a href="#readme-top">back to top</a>)</p>
