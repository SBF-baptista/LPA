# Assobio Production Test Application

This repository contains a starter project for running production tests on the Assobio device. It provides a backend written in Spring Boot, a simple React frontend and uses PostgreSQL as database.

## Backend

Located in `backend/`. To run:

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
