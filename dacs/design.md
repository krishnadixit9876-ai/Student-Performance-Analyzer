# System Design Documentation

# Student Performance Analyzer

## 1. Introduction

Student Performance Analyzer is a Java-based console application developed to manage and analyze student academic information.

The system manages student details, subject-wise marks, attendance records and generates individual performance reports and class-level statistics.

The application uses Java for the main implementation and MySQL for persistent data storage through JDBC.

---

# 2. System Architecture

The system follows a modular layered architecture.

The major layers are:

1. Presentation Layer
2. Application Layer
3. Data Access Layer
4. Database Layer

### Architecture Flow

```text
User / Teacher / Faculty
          |
          v
Console Interface
       (Main)
          |
          v
Input Validation
   (InputValidator)
          |
          v
Application Logic
     /      |       \
    /       |        \
Student   Marks    Attendance
Manager   Manager   Manager
    \       |        /
     \      |       /
          |
          v
Database Connection
       (JDBC)
          |
          v
        MySQL
          |
          v
Students / Marks / Attendance
          |
          v
Reports and Statistics
          |
          v
          User
3. Major Components
3.1 Main

Main.java is the entry point of the application.

It provides the console menu and accepts user input.

Main responsibilities:

Display the main menu
Accept user choices
Collect input
Call appropriate manager classes
Handle application flow
Exit the application
3.2 Student

Student.java represents a student in the system.

Attributes
Roll Number
Name
Course
Responsibilities
Store student information
Provide getter methods
Display student details
3.3 StudentManager

StudentManager.java handles student-related database operations.

Functions
Add student
View students
Search student
Update student
Delete student

This class uses JDBC and SQL queries to communicate with the database.

3.4 Marks

Marks.java represents the marks of a student.

The current system stores marks for:

Java
Operating Systems
Mathematics
Calculations

The class calculates:

Total marks
Percentage
Grade
Grade Criteria
Percentage	Grade
90–100	A+
80–89.99	A
70–79.99	B
60–69.99	C
50–59.99	D
Below 50	F
3.5 MarksManager

MarksManager.java manages marks-related database operations.

Functions
Add marks
View marks
Update marks
Delete marks
Search marks
3.6 Attendance

Attendance.java represents the attendance record of a student.

Stored Information
Roll number
Total classes
Attended classes
Calculation
Attendance Percentage =
(Attended Classes / Total Classes) × 100

The system considers attendance of 75% or above as:

Eligible

Attendance below 75% is:

Not Eligible
3.7 AttendanceManager

AttendanceManager.java handles attendance database operations.

Functions
Add attendance
View attendance
Update attendance
Delete attendance
Search attendance
3.8 ReportGenerator

ReportGenerator.java generates an individual student performance report.

The report contains:

Student details
Course
Subject-wise marks
Total marks
Percentage
Grade
Attendance percentage
Attendance status
Final result
3.9 StatisticsManager

StatisticsManager.java performs class-level analysis.

Functions
Calculate class average
Find highest percentage
Find lowest percentage
Find class topper
Display pass/fail statistics
Display grade statistics
3.10 DatabaseConnection

DatabaseConnection.java establishes the connection between Java and MySQL.

It uses:

JDBC

to connect with the MySQL database.

The connection is created using:

DriverManager
3.11 InputValidator

InputValidator.java performs input validation.

The current validation includes:

Marks between 0 and 100
Attendance values within valid limits
Non-empty student name

Invalid input is rejected and an appropriate message is displayed.

4. Use Case Diagram

The major actor of the system is:

Teacher / Faculty

The actor interacts with the following major functionalities:

                  +---------------------------+
                  | Student Performance       |
                  | Analyzer                  |
                  +---------------------------+
                    /       |       |       \
                   /        |       |        \
                  v         v       v         v
          Student       Marks   Attendance   Reports
          Management    Management Management  |
                                                |
                                                v
                                          Class Statistics
Student Management
Teacher / Faculty
       |
       +-- Add Student
       +-- View Students
       +-- Search Student
       +-- Update Student
       +-- Delete Student
Marks Management
Teacher / Faculty
       |
       +-- Add Marks
       +-- View Marks
       +-- Update Marks
       +-- Delete Marks
Attendance Management
Teacher / Faculty
       |
       +-- Add Attendance
       +-- View Attendance
       +-- Update Attendance
       +-- Delete Attendance
Reporting and Statistics
Teacher / Faculty
       |
       +-- Generate Performance Report
       |
       +-- Class Average
       +-- Highest Percentage
       +-- Lowest Percentage
       +-- Find Class Topper
       +-- Result Statistics
       +-- Grade Statistics
5. Class Diagram

The project is divided into multiple Java classes according to their responsibilities.

+----------------------+
|       Student        |
+----------------------+
| - rollNo             |
| - name               |
| - course             |
+----------------------+
| + getRollNo()        |
| + getName()          |
| + getCourse()        |
| + display()          |
+----------------------+
          ^
          |
          |
+----------------------+
|   StudentManager     |
+----------------------+
| + addStudent()       |
| + findStudent()      |
| + viewStudents()     |
| + searchStudent()    |
| + updateStudent()    |
| + deleteStudent()    |
+----------------------+


+----------------------+
|        Marks         |
+----------------------+
| - rollNo             |
| - java               |
| - os                 |
| - maths              |
+----------------------+
| + getTotal()         |
| + getPercentage()    |
| + getGrade()         |
| + displayMarks()     |
+----------------------+
          ^
          |
          |
+----------------------+
|    MarksManager      |
+----------------------+
| + addMarks()         |
| + findMarks()        |
| + viewMarks()        |
| + updateMarks()      |
| + deleteMarks()      |
+----------------------+


+----------------------+
|      Attendance      |
+----------------------+
| - rollNo             |
| - totalClasses       |
| - attendedClasses    |
+----------------------+
| + getPercentage()    |
| + getStatus()        |
| + displayAttendance()|
+----------------------+
          ^
          |
          |
+----------------------+
| AttendanceManager    |
+----------------------+
| + addAttendance()    |
| + findAttendance()   |
| + viewAttendance()   |
| + updateAttendance() |
| + deleteAttendance() |
+----------------------+


+------------------------+
|   ReportGenerator      |
+------------------------+
| + generateReport()     |
+------------------------+
           |
           +---- StudentManager
           |
           +---- MarksManager
           |
           +---- AttendanceManager


+------------------------+
|   StatisticsManager    |
+------------------------+
| + showClassStatistics()|
| + showTopper()         |
| + showResultStatistics()|
| + showGradeStatistics()|
+------------------------+


+------------------------+
|  DatabaseConnection    |
+------------------------+
| + getConnection()      |
+------------------------+


+------------------------+
|    InputValidator      |
+------------------------+
| + isValidMarks()       |
| + isValidAttendance()  |
| + isValidName()        |
+------------------------+


+------------------------+
|         Main           |
+------------------------+
| + main()               |
+------------------------+
6. System Workflow

The system follows this workflow:

             START
               |
               v
       Display Main Menu
               |
               v
      User Selects Option
               |
               v
         Enter Input
               |
               v
      Validate Input
          /       \
        No         Yes
        |           |
        v           v
  Error Message   Process Request
        |           |
        |           v
        |     Database Operation
        |           |
        |           v
        |     Generate Result
        |           |
        |           v
        +------> Main Menu
                    |
                    v
              Continue?
               /     \
             Yes      No
              |        |
              v        v
         Main Menu    EXIT
7. Detailed Workflow
Step 1: Start

The user starts the Java application.

Step 2: Display Menu

The system displays the main menu containing options for:

Student management
Marks management
Attendance management
Performance report
Class statistics
Exit
Step 3: Input

The user selects an option and enters the required information.

Step 4: Validation

The input is checked using InputValidator.

Examples:

Roll number must be numeric.
Marks must be between 0 and 100.
Attendance values must be valid.
Student name cannot be empty.
Step 5: Application Processing

After successful validation, the appropriate manager class processes the request.

Student operation    → StudentManager
Marks operation      → MarksManager
Attendance operation → AttendanceManager
Statistics operation → StatisticsManager
Step 6: Database Operation

The manager class uses DatabaseConnection to establish a JDBC connection with MySQL.

SQL queries are then executed.

Step 7: Result

The system displays:

Updated information
Search results
Performance reports
Statistics
Error messages where required
Step 8: Continue or Exit

The user can return to the main menu or exit the application.

8. Database Design
Database Name
student_performance

The database contains three main tables:

students
marks
attendance
8.1 Students Table
Field	Data Type	Constraint	Description
roll_no	INT	Primary Key	Student roll number
name	VARCHAR(100)	NOT NULL	Student name
course	VARCHAR(100)	NOT NULL	Student course
8.2 Marks Table
Field	Data Type	Constraint	Description
roll_no	INT	Primary Key, Foreign Key	Student roll number
java	DOUBLE	NOT NULL	Java marks
os	DOUBLE	NOT NULL	Operating Systems marks
maths	DOUBLE	NOT NULL	Mathematics marks
8.3 Attendance Table
Field	Data Type	Constraint	Description
roll_no	INT	Primary Key, Foreign Key	Student roll number
total_classes	INT	NOT NULL	Total classes
attended_classes	INT	NOT NULL	Classes attended
9. Database Relationships

The database uses roll_no to connect student-related information.

                 +-------------+
                 |  students   |
                 +-------------+
                       |
                 roll_no
                  /         \
                 /           \
                v             v
       +-------------+   +-------------+
       |    marks    |   | attendance  |
       +-------------+   +-------------+

The marks and attendance tables reference the students table through foreign keys.

The foreign keys are configured with cascading deletion so that related marks and attendance records are removed when a student is deleted.

10. CRUD Operations

The application supports CRUD operations.

Create

Records can be created using:

Add Student
Add Marks
Add Attendance
Read

Records can be viewed using:

View Students
Search Student
View Marks
View Attendance
Update

Existing records can be modified using:

Update Student
Update Marks
Update Attendance
Delete

Records can be removed using:

Delete Student
Delete Marks
Delete Attendance
11. Performance Calculations
Total Marks
Total = Java + OS + Mathematics
Percentage
Percentage = Total / 3
Attendance Percentage
Attendance Percentage =
(Attended Classes / Total Classes) × 100
12. Result Logic

The final result is determined using marks and attendance.

Fail

If percentage is below 50:

Result = FAIL
Not Eligible

If marks are passing but attendance is below 75%:

Result = NOT ELIGIBLE
Pass

If percentage is 50% or above and attendance is at least 75%:

Result = PASS
13. Non-Functional Requirements
13.1 Performance

The system performs database operations according to the selected user operation and avoids unnecessary processing.

13.2 Usability

The console interface provides simple numbered options for easy navigation.

13.3 Reliability

The system validates input and handles database errors without unexpectedly terminating the application.

13.4 Maintainability

The application is divided into separate classes based on functionality.

13.5 Data Integrity

Primary keys and foreign keys maintain relationships between student, marks and attendance data.

13.6 Error Handling

The application handles invalid input and database-related exceptions and displays appropriate messages.

14. Security Considerations

The project uses PreparedStatement for database operations involving user-provided values.

This helps avoid directly concatenating user input into SQL queries.

Database credentials are stored in the local configuration of DatabaseConnection.java and should not be publicly shared.

15. Design Decisions

The following design decisions were made during implementation:

Modular Classes

Different functionalities are implemented using separate Java classes.

Encapsulation

Class attributes are kept private and accessed through methods.

JDBC

JDBC is used to connect the Java application with MySQL.

PreparedStatement

Parameterized SQL queries are used for database operations.

MySQL

MySQL provides persistent storage for student academic information.

Validation

Input validation prevents invalid marks, attendance values and empty names.

Exception Handling

SQL exceptions are handled using Java exception handling.

16. Testing Summary

The application was tested for the following operations:

Test Area	Test Case
Student Management	Add student
Student Management	View students
Student Management	Search student
Student Management	Update student
Student Management	Delete student
Marks Management	Add marks
Marks Management	View marks
Marks Management	Update marks
Marks Management	Delete marks
Attendance Management	Add attendance
Attendance Management	View attendance
Attendance Management	Update attendance
Attendance Management	Delete attendance
Reporting	Generate performance report
Statistics	Class statistics
Statistics	Find class topper
Statistics	Result statistics
Statistics	Grade statistics
Validation	Invalid marks
Validation	Invalid menu input
Database	JDBC connection
Database	Foreign-key deletion

All major functional operations were tested successfully.

17. Project Structure
StudentPerformanceAnalyzer
│
├── database
│
├── lib
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
18. Future Enhancements

The project can be extended with the following features:

Graphical User Interface (GUI)
Login and authentication
Role-based access
Additional subjects
Semester-wise performance
PDF report generation
Performance charts
Advanced analytics
Student ranking
Exporting reports
Cloud database support
19. Conclusion

The Student Performance Analyzer provides a structured solution for managing student academic information.

The project demonstrates the use of Java programming, object-oriented design, JDBC, MySQL, SQL, input validation, exception handling and modular application development.

The system provides student management, marks management, attendance management, performance reporting and class-level statistics through a console-based interface.
