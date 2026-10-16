# Student Management System

A complete student record and performance management application built with **Java, Spring Boot, MySQL, Spring Data JPA/Hibernate and Thymeleaf**.

## Features

- Student CRUD operations
- Add, edit and delete student records
- Marks entry for multiple subjects
- Automatic total and percentage calculation
- Automatic grade generation
- Student performance report
- Search students by name, roll number or course
- Server-side validation
- Thymeleaf web interface
- MySQL database persistence

## Technology Stack

- Java 17
- Spring Boot 3.5
- Spring MVC
- Spring Data JPA / Hibernate
- MySQL
- Thymeleaf
- Maven
- HTML/CSS

## Database Setup

Create the database:

```sql
CREATE DATABASE student_management_db;
```

Then update:

`src/main/resources/application.properties`

with your MySQL username and password.

## Run

```bash
mvn spring-boot:run
```

Open:

`http://localhost:8080/students`

## Main Pages

- `/students` - Student list
- `/students/new` - Add student
- `/students/edit/{id}` - Edit student
- `/students/{id}/marks` - Enter marks
- `/students/{id}/report` - Student report
- `/students/delete/{id}` - Delete student

## Marks

The application supports marks for:

- Java
- Database Management System
- Data Structures
- Computer Networks
- Operating Systems

Total marks = 500.

Percentage and grade are calculated automatically.

## Grade Logic

- A+ : 90% and above
- A  : 80% - 89.99%
- B  : 70% - 79.99%
- C  : 60% - 69.99%
- D  : 50% - 59.99%
- F  : below 50%
