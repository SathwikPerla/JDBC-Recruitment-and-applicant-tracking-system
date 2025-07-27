# JDBC User Management System

This project is a simple **Java-based User Management System** using **JDBC** and **MySQL**.

### 🔧 Features
- Insert New User
- Fetch All Users
- Update User
- Delete User
- Fetch User by ID

### 💡 Technologies Used
- Java
- MySQL
- JDBC
- MySQL Connector/J
- Git

## 📁 Project Structure

JDBC/
├── lib/
│ └── mysql-connector-j-9.4.0.jar
├── operations/
│ ├── InsertUser.java
│ ├── FetchUsers.java
│ ├── FetchUserById.java
│ ├── UpdateUser.java
│ ├── DeleteUser.java
│ └── Operations.java
├── DBConnection.java
├── Main.java
└── jdbc_project.jar


## ⚙️ Prerequisites

- Java 11 or higher
- MySQL Server running locally
- MySQL Connector JAR (`lib/mysql-connector-j-9.4.0.jar`)
- MySQL database named `hiring_platform` with a `user` table

## 🧱 MySQL Table Structure

Make sure your `user` table is created as follows:

sql
CREATE TABLE user (
  user_id INT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100),
  gender ENUM('MALE', 'FEMALE', 'OTHERS'),
  phoneNo VARCHAR(15),
  dateOfBirth DATE,
  password VARCHAR(100)
);


## 🚀 How to Compile
# On Mac
javac -cp .:lib/mysql-connector-j-9.4.0.jar operations/*.java Main.java

# On Windows
javac -cp .:lib/mysql-connector-j-9.4.0.jar operations/*.java Main.java

## ▶️ How to Run

java -cp .:lib/mysql-connector-j-9.4.0.jar:. Main

On Windows:
java -cp .;lib/mysql-connector-j-9.4.0.jar;. Main


## 📦 How to Create a JAR

jar cvfe jdbc_project.jar Main *.class operations/*.class

Then run it like this:

java -cp .:lib/mysql-connector-j-9.4.0.jar:jdbc_project.jar Main

## ✅ Features
Add new users with details like name, email, gender, phone, DOB, and password.

View all users stored in the database.

Fetch details of a specific user by ID.

Update name, phone, and password of an existing user.

Delete a user by ID.

