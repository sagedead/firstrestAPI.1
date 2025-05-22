# FirstRestAPI — Spring Boot Project
## About
This project was created for Spring Framework tasks.  goal is to build a simple REST API to manage products using Spring Boot and follow a clean project structure with subpackages.

## What it does
we can:
- Add new products
- Get product info by ID
- See a list of all products
- Update product details
- Delete a product

Everything works through API endpoints and is handled by the controller and service classes.

## Project Structure
The project is organized into subpackages under the `product` package:

- `api` → controller + request/response classes
- `model` → the Product class (our entity)
- `repository` → interface for DB access
- `service` → handles the logic between controller and repo
- `support` → where exceptions are handled (like when a product isn't found)

## Tools used 
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok
- H2 Database (so it works in-memory, no setup needed)

## Run
Open in IntelliJ → run `FirstRestApiApplication`,  Test endpoints with Postman or browser

---