# Java Spring Boot & Angular – School Calendar List Creation & Validation 

---

<p align="center">
  <img src="https://mc-8afc6902-e56c-432c-8c3f-3991-cdn-endpoint.azureedge.net/-/media/project/emea/shared/global-logo/globallogo_nttdata_white.png?hash=" alt="NTT DATA Logo" width="300"/>
</p>

---

## ⚠️ Corporate Disclaimer & Privacy Policy

> **PROPERTY OF NTT DATA Italia - Gov&Tech**
> This repository/documentation is strictly **private** and intended exclusively for internal knowledge sharing, technical documentation, and personal educational tracking.

> All code snippets, architecture flows, and examples contained herein have been deliberately **anonymized, de-contextualized, and sanitized** to remove any proprietary business logic, sensitive package structures, client references, or credentials.

---

## Feature Description (Creation List Calendar)

The goal of this feature is to create an endpoint with backoffice to have the list of calendars **School Calendar** as lists.

Here now we go to define the service so the logic, but after in FE we will be a dedicated page, called via ENDPOINT. 

```text
DB (DATA) ──> MapStruct (Entity) ──> BE (LOGIC) ──> Validation (TEST MOCKIJTO & JUnit) ──> ENDPOINT Controller ──>  ... Future FE page 
```

### Business Rules & Constraints

* **Initial State:** Any type of consult of existing calendars

* **Temporal Coherence:** Have a logic to not permit any type of duplicate calendars.

* **Strict Validation:** All incoming payload fields must undergo strict syntactic and structural validation at the REST entrypoint.

---

## Initial Architectural Gaps (Why the Draft Feature Failed)

The initial system do not had this type of page or consult in the backend:

1. **Lack of Mutator Endpoint:** No endpoint given, to consult the SchoolCalendars.

2. **Missing Validation Layer:** Duplication system was there but not impl to list of calendars


---

## Structural Root Cause Analysis

An inspection of the structural layers showed that the write-path needed a complete alignment:

- **DTO Separation:** The read-path was using a generic output DTO. A dedicated creation payload (`SchoolCalendarListResponseDTO`) was required to isolate client-supplied properties from database-generated fields (like `id`, `createdAt`, and `publishedAt`).

---

## Testing and Verification Strategy

To guarantee zero-regression, a complete testing suite has been implemented:

* **Service Unit Tests:** Verifies that a valid payload is successfully stored  and that any date inversion throws a `ResponseStatusException` (Bad Request) prior to database execution.

* **REST Integration Tests (`MockMvc`):** Assures that missing properties trigger a `400 Bad Request` status with validation alert payloads, while correct structures yield `200 OK` (wrapped in the `ServiceResponse` wrapper).

---

## Technologies Used

* Java 17 / Spring Boot 3
* Spring Data JPA / Hibernate
* MapStruct (Component Model Spring)
* Jakarta Validation API (JSR-380)
* PostgreSQL
* Lombok

---

## Conclusion

This implementation completes the design pattern used in our enterprise architecture. By separating the read models from the write models, introducing explicit MapStruct mapping exclusions, and enforcing transactional service-level validations, the calendar generation path is now stable, safe, and perfectly aligned with our team's coding standard.