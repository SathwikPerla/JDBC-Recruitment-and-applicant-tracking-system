# JDBC Recruitment and Applicant Tracking System

This project is a simple Java-based command-line application for managing recruitment data using JDBC and MySQL. It allows recruiters to interact with the database to fetch useful insights like listing candidates in the interview stage, retrieving interview schedules, and more.

## ✅ Features Implemented So Far

### 1. List Candidates in Interview Stage for a Given Job
- **Input**: Job ID
- **Output**: All candidates currently in the “interview” stage for that job.
- **Tables used**: `applications`, `application_stage`, `candidate`, `user`, `job`

### 2. Retrieve Interview Schedules
- **Output**: Lists all scheduled interviews with candidate and interviewer details.
- **Tables used**: `interviews`, `candidate`, `interviewer`, `user`, `applications`

### 3. Find Jobs With More Than 50 Applications
- **Output**: Displays job postings that have received more than 50 applications.
- **Tables used**: `job`, `applications`

## 🔧 Technologies Used
- Java
- MySQL
- JDBC
- MySQL Connector/J

## 🗂️ Project Structure






## 🚀 How to Run

**Compile Java files**:
bash
javac -cp .:lib/mysql-connector-j-9.4.0.jar -d . Main.java operations/*.java DBConnection.java
jar cfe jdbc_project.jar Main Main.class operations/*.class DBConnection.class

java -cp .:lib/mysql-connector-j-9.4.0.jar -jar jdbc_project.jar
