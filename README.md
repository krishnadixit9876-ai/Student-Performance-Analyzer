# Student Performance Analyzer

## Project Overview

Student Performance Analyzer is a Java-based application designed to manage and analyze student academic information.

The system allows users to manage student details, marks, attendance and generate performance reports and class statistics.

The project uses Java for application development and MySQL for data storage through JDBC.

## Objectives

* Manage student information efficiently.
* Store and manage subject-wise marks.
* Record and calculate student attendance.
* Generate individual performance reports.
* Calculate class performance statistics.
* Identify the class topper.
* Provide result and grade statistics.
* Validate user input and handle errors.

## Features

### 1. Student Management

* Add student
* View students
* Search student
* Update student
* Delete student

### 2. Marks Management

* Add marks
* View marks
* Update marks
* Delete marks
* Calculate total marks
* Calculate percentage
* Calculate grade

### 3. Attendance Management

* Add attendance
* View attendance
* Update attendance
* Delete attendance
* Calculate attendance percentage
* Check attendance eligibility

### 4. Performance Reporting

* Generate individual student performance report
* Display student details
* Display marks and percentage
* Display grade
* Display attendance
* Display final result

### 5. Statistics

* Calculate class average
* Find highest and lowest percentage
* Find class topper
* Display pass/fail statistics
* Display grade-wise statistics

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* MySQL
* JDBC
* SQL
* Exception Handling
* Git and GitHub
* Visual Studio Code

## Project Structure

```text
StudentPerformanceAnalyzer
│
├── database
│
├── lib
│   └── mysql-connector-j-26.7.0.jar
│
├── bin
│
└── src
    ├── Main.java
    ├── Student.java
    ├── StudentManager.java
    ├── InputValidator.java
    ├── Marks.java
    ├── MarksManager.java
    ├── Attendance.java
    ├── AttendanceManager.java
    ├── ReportGenerator.java
    ├── DatabaseConnection.java
    └── StatisticsManager.java
```

## Database

The project uses a MySQL database named:

```text
student_performance
```

Main tables:

* `students`
* `marks`
* `attendance`

The application connects to MySQL using JDBC.

## How to Run

### 1. Create the Database

Create the `student_performance` database and required tables using MySQL Workbench.

### 2. Configure Database Connection

Open:

```text
src/DatabaseConnection.java
```

Update the MySQL password according to your local MySQL installation.

### 3. Compile the Project

Open the terminal in the project root directory and run:

```powershell
javac -cp "lib\mysql-connector-j-26.7.0.jar" -d bin src\*.java
```

### 4. Run the Application

```powershell
java -cp "bin;lib\mysql-connector-j-26.7.0.jar" Main
```

## Main Menu

The application provides options for:

1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Add Marks
7. View Marks
8. Update Marks
9. Delete Marks
10. Add Attendance
11. View Attendance
12. Update Attendance
13. Delete Attendance
14. Generate Performance Report
15. Class Statistics
16. Find Class Topper
17. Result Statistics
18. Grade Statistics
19. Exit

## Validation and Error Handling

The application includes validation for:

* Invalid menu choices
* Invalid roll numbers
* Marks outside the range of 0–100
* Invalid attendance values
* Non-existing students
* Missing marks
* Missing attendance records
* Database errors

The application handles invalid input without terminating unexpectedly.

## Testing

The application was tested for:

* Student CRUD operations
* Marks CRUD operations
* Attendance CRUD operations
* Performance report generation
* Class statistics
* Topper calculation
* Result statistics
* Grade statistics
* Invalid input handling
* Database connectivity
* Foreign-key related deletion

## Future Enhancements

Possible future improvements include:

* Graphical User Interface (GUI)
* Login and authentication system
* More subjects
* Export reports to PDF
* Graphical performance charts
* Semester-wise performance tracking
* Advanced analytics
* Role-based access for administrators and teachers

## Author

**Krishna Dixit**

## License

This project is developed for academic purposes.
