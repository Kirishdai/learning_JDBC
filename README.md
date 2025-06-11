# JDBC Practice – learning_JDBC

This repository contains my hands-on practice with **JDBC (Java Database Connectivity)** using **MySQL** and the **Maven build tool** as part of my journey to become an 
enterprise-level Full-Stack Java Developer. It includes basic and DAO-style examples for connecting, inserting, retrieving, and interacting with relational databases.

---

##  Folder Overview

### `com.krish.jdbc`
- `JDBCDemo.java`: Demonstrates a simple JDBC example using `PreparedStatement` to insert a record into a MySQL table. Shows how to load the MySQL driver, establish a connection,
   and close resources properly.
- `JDBCDAODemo.java`: A more structured approach using the DAO (Data Access Object) pattern. It allows retrieving and inserting user data into a MySQL database using a `UserDAO`
  class and `User` POJO.

---

##  Database Schema

The SQL schema used in this project is provided in `schema.sql`.

- Creates a database named `aliens`
- Contains a table called `student` with two fields:
  - `userid` (int, primary key)
  - `username` (varchar)

```sql
CREATE DATABASE aliens;
USE aliens;

CREATE TABLE student (
  userid INT PRIMARY KEY,
  username VARCHAR(50)
);


INSERT INTO student VALUES (3, 'Mahesh');
```

##  Tools Used

- **Java 24**
- **JDBC API**
- **MySQL 8**
- **Maven**
- **IntelliJ IDEA Ultimate Edition**
- **Git + GitHub**

---

##  Why This Repo Exists

This repository is part of my structured, high-intensity 4-month sprint to become internship-ready with enterprise-level full-stack Java development skills.
JDBC is the backbone of traditional database interaction in Java and is still a core skill in backend systems. This repo is built to solidify my understanding of how 
Java communicates with databases using both procedural and object-oriented patterns.
