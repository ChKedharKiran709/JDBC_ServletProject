# Employee Management System

## Overview

This is an Employee Management System with basic CRUD (Create, Read, Update, Delete) operations. The system allows users to:
- Login to access the employee management features.
- Add, display, update, and delete employee records.
- Ensure no duplicate records (based on employee ID) are entered into the database.

The frontend is built with HTML, CSS, and JavaScript, while the backend is powered by Servlets running on a Tomcat server, with MySQL as the database.

---

## Features

### 1. **Login Page**
   - Users must log in with their credentials.
   - The page validates user input and triggers the backend login process using a Servlet.
   - If authentication is successful, the user is redirected to the homepage.

### 2. **Home Page**
   - After a successful login, users are directed to the home page where they can choose to add, display, update, or delete employee records.
   
### 3. **Add Employee**
   - Users can enter the details of a new employee including their name, ID, position, department, etc.
   - The form ensures that no duplicate employee IDs are added to the database.
   - Upon submission, the data is sent to a Servlet, which handles the addition of the employee to the database.

### 4. **Display Employee**
   - The employee records stored in the database are displayed in a tabular format on the page.
   - Users can view details of all employees and their information.
   
### 5. **Update Employee**
   - Users can update the details of an existing employee by selecting the employee ID.
   - After modifying the details, the updated information is sent to the backend via a Servlet, which updates the corresponding record in the database.

### 6. **Delete Employee**
   - Users can delete an employee's record by selecting the employee ID.
   - The record is removed from the database once the deletion request is triggered.

---

## Technologies Used

### Frontend
- **HTML**
- **CSS**
- **JavaScript**

### Backend
- **Java Servlets**: The backend is built using Java Servlets to handle form submissions and perform CRUD operations on the database.
- **Tomcat Server**: Used as the web server to run the Java Servlets and handle HTTP requests.
- **MySQL**: The database is used to store employee records. The system ensures no duplicate employee IDs are entered.

---

## How it Works

1. **Frontend Form Submission**:
   - When a user enters employee data or modifies existing data, the frontend sends a request to the appropriate Servlet.
   
2. **Servlet Processing**:
   - The Servlets handle the requests (such as adding, updating, or deleting employee records) and communicate with the MySQL database.
   
3. **Database Interaction**:
   - The employee details are stored in the MySQL database after validation (e.g., ensuring the employee ID is unique).
   
4. **Duplicate Check**:
   - Before adding an employee record, the system checks if the employee ID already exists in the database. If a duplicate ID is found, the entry is rejected and an appropriate message is displayed.

---

## Setup Instructions

### 1. **Clone the Repository**
   Clone the project repository to your local machine:
   ```bash
   git clone https://github.com/ChKedharKiran709/JDBC_ServletProject.git
 ```
### 2. **Setup MySQL Database**
   - Create a database in MySQL named `employee_management` (or use the existing name in the project).
   - Run the following SQL script to create the table to store employee data:
     ```bash
     CREATE TABLE employees (
         id INT PRIMARY KEY,
         name VARCHAR(100),
         position VARCHAR(100),
         department VARCHAR(100),
         email VARCHAR(100)
     );
     
   - Update the database connection details in the backend (Servlets) to match your MySQL configuration, such as the database URL, username, and password. You can find these details in the `DBConnection` class or wherever the connection is configured.

### 3. **Setup Apache Tomcat Server**
   - If you don’t have Apache Tomcat installed, download it from [here](https://tomcat.apache.org/).
   - After downloading, extract the Tomcat zip file and place it in a folder on your local machine.
   - Configure Tomcat:
     - Set `JAVA_HOME` and `CATALINA_HOME` environment variables to point to your Java JDK and Tomcat directories, respectively.
     - Optionally, add Tomcat’s `bin` directory to your system’s PATH for easy access.
   - Deploy the web application by placing the project folder inside the `webapps` directory of your Tomcat installation.

### 4. **Configure the Project in Tomcat**
   - Open Tomcat and navigate to the `webapps` directory.
   - Place the `JDBC_ServletProject` folder (the cloned project) in the `webapps` folder.
   - Make sure the `WEB-INF` directory and the necessary `web.xml` configuration file are in place.

### 5. **Start Tomcat Server**
   - Start the Tomcat server:
     - Navigate to the `bin` folder of your Tomcat installation and run the appropriate script based on your OS:
       - On Windows: `startup.bat`
       - On macOS/Linux: `startup.sh`
   - After starting Tomcat, the server should be accessible on `http://localhost:8080`.

### 6. **Access the Application**
   - Open your web browser and navigate to:
     ```bash
     http://localhost:8080/JDBC_ServletProject/login.html
     ```
   - You will be redirected to the login page.
   - Enter your credentials to access the homepage and manage employee records.
   - By default Username: - kedhar, password - kedhar




