# Client JSON Management API

A REST API built with **Spring Boot** to receive and process **JSON** client data, store it in memory, and **update account information**.  
Includes validation using `jakarta.validation`, centralized error handling, and endpoints for bulk registration, querying, and updating.

---

## 🏗️ Architecture (Layers)

- **Controller**: `ClienteController` (defines REST endpoints)
- **Service**: `ClienteService` (business logic, in-memory storage)
- **DTOs**: `ClienteRequest`, `ClienteResponse`
- **Model (request)**: `AccountUpdate`
- **Config**: `ApiExceptionHandler` (handles validation errors)

---

## 🚦 Endpoints

Base URL: `http://localhost:8080/api/clientes`

| Method | Endpoint                | Description                                                   | Body |
|--------|--------------------------|---------------------------------------------------------------|------|
|  GET   | `/todos`                | Lists all clients stored in memory                            | —    |
|  GET   | `/ultimaActualizacion`  | Returns the last performed account update                     | —    |
|  POST  | `/registrar`            | Bulk client registration (array of `ClienteRequest`)          | JSON |
|  POST  | `/account/update`       | Updates account details (array of `AccountUpdate`) and returns results | JSON |

---

## Input Schemas

### ClienteRequest
json in
[{
  "nombre": "Sebastian",
  "id": 105,
  "numeroCuenta": "001-122-3344",
  "ingresos": 9500.00
},{
""
}]

### Update 
json in
{
  "customerId": "123",
  "productCode": "12",
  "productInstrument": "34",
  "accountNumber": "001122334455"
}

### Error Handles



