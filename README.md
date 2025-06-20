# Assobio Production Test Application

This repository contains a starter project for running production tests on the Assobio device. It provides a backend written in Spring Boot, a simple React frontend and uses PostgreSQL as database.

## Backend

Located in `backend/`. The project uses a small service layer for clean separation of responsibilities. To run with Maven:

```bash
cd backend
mvn spring-boot:run
```

Database connection properties are in `backend/src/main/resources/application.properties`.

## Frontend

Located in `frontend/`. A minimal React project is provided. To start the development server:

```bash
cd frontend
npm install
npm start
```

## Database Schema

SQL for creating tables is in `backend/src/main/resources/schema.sql`. JPA will also generate tables automatically if the schema does not exist.

### Endpoints

- `POST /api/firmware/run` – run a firmware command on a device
- `POST /api/images/upload` – upload an assembly image for a device
- `GET /api/devices/{serial}/history` – list tests and images for a device
