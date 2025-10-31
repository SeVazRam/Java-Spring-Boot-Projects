# Client JSON Management API

A REST API built with **Spring Boot** to receive and process **JSON** client data, store it in memory, and **update account information**.  
Includes validation using `jakarta.validation`, centralized error handling, and endpoints for bulk registration, querying, and updating.

---

## Architecture (Layers)

- **Controller**: `ClienteController` (defines REST endpoints)
- **Service**: `ClienteService` (business logic, in-memory storage)
- **DTOs**: `ClienteRequest`, `ClienteResponse`
- **Model (request)**: `AccountUpdate`
- **Config**: `ApiExceptionHandler` (handles validation errors)

---

## Endpoints

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
[
  {
    "nombre": "Sebastián",
    "id": 105,
    "numeroCuenta": "123-456-789",
    "ingresos": 25000
  },
  {
    "nombre": "Cecilia",
    "id": 106,
    "numeroCuenta": "987-654-321",
    "ingresos": 1500
  }
]

### Update 
json in
[{
    "customerId": "105",
    "productCode": "0061",
    "productInstrument": "0001",
    "accountNumber": "0000010000543311"
  },
  {
    "customerId": "106",
    "productCode": "0062",
    "productInstrument": "0002",
    "accountNumber": "0000010000543322"
  }]
### Error Handles
{
  "mensaje": "JSON inválido",
  "errores": [
    {"campo": "customerId", "error": "customerId is required"}
  ]
}



