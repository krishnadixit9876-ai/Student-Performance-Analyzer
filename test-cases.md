# Test Cases

## 1. Introduction

Testing was performed to verify that the Student Performance Analyzer
works correctly and handles valid as well as invalid user inputs.

The major modules tested are:

- Student Management
- Marks Management
- Attendance Management
- Performance Report
- Statistics
- Database Connectivity


## 2. Test Case Table

| Test ID | Module | Test Condition | Expected Result |
|--------|--------|----------------|-----------------|
| TC01 | Database | Start application with correct database configuration | Database connection should work |
| TC02 | Student Management | Add a new student with valid details | Student should be added successfully |
| TC03 | Student Management | Search an existing student | Student details should be displayed |
| TC04 | Student Management | Search a non-existing student | "Student not found" message should be displayed |
| TC05 | Student Management | Update existing student | Student details should be updated |
| TC06 | Student Management | Delete existing student | Student should be deleted successfully |
| TC07 | Marks Management | Add marks between 0 and 100 | Marks should be stored successfully |
| TC08 | Marks Management | Enter marks below 0 or above 100 | Invalid marks message should be displayed |
| TC09 | Marks Management | View student marks | Marks, total, percentage and grade should be displayed |
| TC10 | Marks Management | Update existing marks | Marks should be updated successfully |
| TC11 | Attendance Management | Add valid attendance | Attendance should be stored successfully |
| TC12 | Attendance Management | Enter attended classes greater than total classes | Invalid attendance message should be displayed |
| TC13 | Attendance Management | Calculate attendance percentage | Correct percentage should be displayed |
| TC14 | Attendance Management | Attendance below 75% | Student should be marked Not Eligible |
| TC15 | Performance Report | Generate report for complete student data | Complete performance report should be displayed |
| TC16 | Performance Report | Generate report for missing student | Student not found message should be displayed |
| TC17 | Statistics | Calculate class statistics | Average, highest and lowest percentage should be displayed |
| TC18 | Statistics | Find class topper | Student with highest percentage should be displayed |
| TC19 | Statistics | Calculate pass/fail statistics | Pass and fail counts should be displayed |
| TC20 | Statistics | Calculate grade statistics | Grade-wise student counts should be displayed |
| TC21 | Input Validation | Enter invalid menu choice | Invalid input message should be displayed |
| TC22 | Input Validation | Enter non-numeric value where number is required | Error message should be displayed |
| TC23 | Database | Delete a student having marks/attendance | Related records should be removed using CASCADE |
| TC24 | Application | Select Exit option | Application should terminate correctly |


## 3. Validation Testing

The application validates important user inputs.

### Marks Validation

Marks must be within:

```text
0 <= Marks <= 100

Invalid marks are rejected.

Attendance Validation

The following conditions are checked:

Total Classes > 0
Attended Classes >= 0
Attended Classes <= Total Classes

Invalid attendance values are rejected.

Name Validation

Student name cannot be empty.

Menu Validation

The application accepts menu choices from:

1 to 19

Invalid choices generate an error message.

4. Functional Testing

The following major functions were tested:

Adding students
Viewing students
Searching students
Updating students
Deleting students
Adding marks
Viewing marks
Updating marks
Deleting marks
Adding attendance
Viewing attendance
Updating attendance
Deleting attendance
Generating performance reports
Generating class statistics
Finding class topper
Generating pass/fail statistics
Generating grade statistics
5. Database Testing

Database connectivity was tested using MySQL Connector/J.

The application successfully connects to:

Database: student_performance
Host: localhost
Port: 3306

The database contains the following tables:

students
marks
attendance

Foreign key relationships are used between the tables.

The ON DELETE CASCADE option ensures that when a student is
deleted, the related marks and attendance records are also deleted.

6. Error Handling Testing

The application handles common errors such as:

Invalid menu choice
Invalid roll number
Invalid marks
Invalid attendance
Non-existing student
Missing marks
Missing attendance
Database errors
Invalid numeric input
7. Testing Conclusion

Testing confirms that the major functional modules of the
Student Performance Analyzer work according to the defined
requirements.

Input validation and exception handling are implemented to
improve application reliability and prevent invalid data from
being stored.


