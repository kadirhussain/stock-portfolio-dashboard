# 📈 Stock Portfolio Dashboard

A **Spring Boot–based backend application** for managing and tracking a stock investment portfolio. The system allows users to record BUY/SELL transactions, handle multi-currency investments, and calculate portfolio metrics in a clean, scalable, and production-ready architecture.

## Features

* Record stock transactions (BUY / SELL)
* Track holdings per stock (quantity & average price)
* Multi-currency support with currency conversion
* Trade date handling using `LocalDate`
* Clean separation of Entity, DTO, Service, and Controller layers
* Robust validation and exception handling
* Ready for authentication & authorization extension

---

## High-Level Architecture

Controller  →  Service  →  Repository  →  Database
     ↓            ↓
    DTOs        Domain Models (Entities)

* **Controller Layer**: Exposes REST APIs
* **Service Layer**: Business logic (portfolio calculation, validation)
* **Repository Layer**: JPA/Hibernate persistence
* **Domain Model**: Clean entity design using enums and value objects

---

## Tech Stack

| Layer         | Technology                  |
| ------------- | --------------------------- |
| Language      | Java 17                     |
| Framework     | Spring Boot 3.2                |
| Persistence   | Spring Data JPA / Hibernate |
| Database      | MySQL / H2                  |
| Build Tool    | Maven                       |
| API Style     | RESTful APIs                |
| Date Handling | `java.time.LocalDate`       |

---

## Domain Model Overview

### Transaction

* `ticker` (String)
* `transactionType` (BUY / SELL)
* `quantity` (int)
* `localPrice` (BigDecimal)
* `currency` (Enum)
* `tradeDate` (LocalDate)

### Enums

* `TransactionType` → BUY, SELL
* `Currency` → INR, USD, EUR etc.

---

## Sample API Request

### Create Transaction

```http
POST /api/transactions
```

```json
{
  "ticker": "AAPL",
  "transactionType": "BUY",
  "quantity": 10,
  "localPrice": 150.25,
  "currency": "USD",
  "tradeDate": "2025-01-20"
}
```

---

## Design Decisions

* **LocalDate over Timestamp**
  Trade date represents a business date, not a moment in time, avoiding timezone issues.

* **Enums for TransactionType & Currency**
  Ensures data integrity and prevents invalid values.

* **DTO Layer**
  Decouples API contracts from persistence models.

* **BigDecimal for prices**
  Prevents floating-point precision errors (critical for financial systems).

---

## Validation & Error Handling

* Bean validation using `@NotNull`, `@Positive'
* Centralized exception handling with `@ControllerAdvice`
* Meaningful error responses for invalid inputs

---

## Future Enhancements

* Portfolio valuation in base currency
* Real-time market price integration
* User authentication & role-based access
* Reports: P&L, realized vs unrealized gains
* Caching exchange rates
* Docker & Kubernetes deployment

---

## Author

**Kadir Hussain**
Java Backend Developer | Spring Boot | Microservices

* GitHub: [https://github.com/kadirhussain](https://github.com/kadirhussain)
* LinkedIn: [https://www.linkedin.com/in/contact-kadirhussain](https://www.linkedin.com/in/contact-kadirhussain)

---

## Why This Project Matters

This project demonstrates:

* Real-world backend design
* Financial domain understanding
* Clean Java & Spring Boot practices
* Readiness for banking / fintech roles

If you’re a recruiter or engineer reviewing this project — feedback is welcome!
