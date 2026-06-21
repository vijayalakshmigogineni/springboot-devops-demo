# Spring Boot DevOps Demo

## Overview

This project demonstrates a complete CI/CD pipeline for a Spring Boot REST API using Jenkins, Docker, PostgreSQL, and GitHub.

The application exposes REST endpoints for managing student data and is automatically built and deployed through a Jenkins pipeline whenever changes are pushed to the repository.

---

## Tech Stack

### Backend

* Java 21
* Spring Boot
* Spring Data JPA
* Maven

### Database

* PostgreSQL 16

### DevOps Tools

* Docker
* Jenkins
* GitHub

---

## Project Architecture

```text
Developer
    |
    v
 GitHub Repository
    |
    v
 Jenkins Pipeline
    |
    v
 Maven Build
    |
    v
 Docker Image Build
    |
    v
 Docker Container Deployment
    |
    v
 PostgreSQL Database
```

---

## Features

* Create Student
* Get Student By ID
* Get All Students
* Update Student
* Delete Student
* PostgreSQL Integration
* Dockerized Application
* Jenkins CI/CD Pipeline

---

## REST Endpoints

| Method | Endpoint           | Description       |
| ------ | ------------------ | ----------------- |
| GET    | /api/student       | Sample Student    |
| GET    | /api/AllStudents   | Get All Students  |
| GET    | /api/students/{id} | Get Student By ID |
| POST   | /api/students      | Create Student    |
| PUT    | /api/{id}          | Update Student    |
| PATCH  | /api/{id}          | Partial Update    |
| DELETE | /api/{id}          | Delete Student    |

---

## Docker Configuration

### Build Docker Image

```bash
docker build -t student-api .
```

### Run Container

```bash
docker run -d --name student-api-container -p 8082:8080 student-api
```

---

## Jenkins Pipeline

The Jenkins pipeline performs the following steps:

### Stage 1 - Build Jar

```bash
./mvnw clean package -DskipTests
```

### Stage 2 - Build Docker Image

```bash
docker build -t student-api:latest .
```

### Stage 3 - List Images

```bash
docker images
```

### Stage 4 - Deploy Container

```bash
docker rm -f student-api-container || true
docker run -d --name student-api-container -p 8082:8080 student-api:latest
```

---

## Database Configuration

```properties
spring.datasource.url=jdbc:postgresql://postgres:5432/studentdb
spring.datasource.username=postgres
spring.datasource.password=postgres
```

---

## CI/CD Workflow

```text
Code Change
     ↓
Git Push
     ↓
GitHub Repository
     ↓
Jenkins Pipeline
     ↓
Build JAR
     ↓
Build Docker Image
     ↓
Deploy Docker Container
     ↓
Application Running
```

---

## Successful Deployment

The application was successfully:

* Built using Maven
* Containerized using Docker
* Connected to PostgreSQL
* Deployed through Jenkins Pipeline
* Accessed via REST API endpoint

Example:

```text
http://localhost:8082/api/student
```

Response:

```json
{
  "id": 4,
  "name": "alice",
  "email": "alice@gmail.com"
}
```

---

## Future Improvements

* Add Unit Tests
* Add Jenkins Test Stage
* Configure GitHub Webhooks
* Docker Compose Setup
* Deploy to AWS EC2
* Push Docker Images to Docker Hub
* Implement Monitoring and Logging

---

Webhook Test

## Author

Vijayalakshmi Gogineni

B.Tech Computer Science and Engineering
Spring Boot | Java | Docker | Jenkins | PostgreSQL
