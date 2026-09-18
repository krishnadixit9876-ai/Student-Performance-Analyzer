-- ============================================
-- Student Performance Analyzer
-- Database Setup Script
-- ============================================

-- Create Database
CREATE DATABASE IF NOT EXISTS student_performance;

-- Select Database
USE student_performance;


-- ============================================
-- STUDENTS TABLE
-- ============================================

CREATE TABLE IF NOT EXISTS students (
    roll_no INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    course VARCHAR(100) NOT NULL
);


-- ============================================
-- MARKS TABLE
-- ============================================

CREATE TABLE IF NOT EXISTS marks (
    roll_no INT PRIMARY KEY,
    java DOUBLE NOT NULL,
    os DOUBLE NOT NULL,
    maths DOUBLE NOT NULL,

    FOREIGN KEY (roll_no)
    REFERENCES students(roll_no)
    ON DELETE CASCADE
);


-- ============================================
-- ATTENDANCE TABLE
-- ============================================

CREATE TABLE IF NOT EXISTS attendance (
    roll_no INT PRIMARY KEY,
    total_classes INT NOT NULL,
    attended_classes INT NOT NULL,

    FOREIGN KEY (roll_no)
    REFERENCES students(roll_no)
    ON DELETE CASCADE
);


-- ============================================
-- DATABASE STRUCTURE
-- ============================================

-- students
--     |
--     +---- marks
--     |
--     +---- attendance
--
-- roll_no is the Primary Key in students.
-- roll_no is also the Primary Key and Foreign Key
-- in marks and attendance.
