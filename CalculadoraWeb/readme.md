# CalculatorWEB API 

This repository contains a **Java Spring Boot web application** that implements a simple calculator.  
The project follows the **MVC pattern** using **Spring Boot** for the backend and **Thymeleaf** templates for the frontend.  

Users can input two numbers through a web form, choose an operation (add, subtract, multiply, divide), and view the result on a result page.

## Features

- Web form (`formulario.html`) to input numbers and select operation.
- Controller (`Calculadora.java`) to process the request.
- Result view (`resultado.html`) displaying the operation and result.
- Built with **Spring Boot** and **Thymeleaf**.

## Technologies Used

- **Java 17+**
- **Spring Boot 3+**
- **Thymeleaf** (for dynamic HTML rendering)
- **Maven**

---

## Endpoints

Base URL: `http://localhost:8080/api/calculator`

| Method | Endpoint       | Description                 | Example Request |
|--------|---------------|-----------------------------|-----------------|
| GET    | `/add`        | Adds two numbers            | `/add?a=5&b=3` |
| GET    | `/subtract`   | Subtracts two numbers       | `/subtract?a=10&b=4` |
| GET    | `/multiply`   | Multiplies two numbers      | `/multiply?a=6&b=7` |
| GET    | `/divide`     | Divides two numbers         | `/divide?a=20&b=5` |

## How It Works

1. User navigates to the form:  
http://localhost:8080/formulario

css
Copiar
Editar

2. Fills in two numbers and selects an operation.  
Example form submission:

Numero 1: 10
Numero 2: 5
Operación: División

markdown
Copiar
Editar

3. The controller (`Calculadora.java`) processes the input.

4. The result page (`resultado.html`) displays:  

#

