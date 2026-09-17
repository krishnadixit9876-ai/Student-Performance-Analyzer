import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManager studentManager = new StudentManager();
        MarksManager marksManager = new MarksManager();
        AttendanceManager attendanceManager = new AttendanceManager();
        ReportGenerator reportGenerator = new ReportGenerator();
        StatisticsManager statisticsManager = new StatisticsManager();

        while (true) {

            System.out.println("\n========================================");
            System.out.println("      STUDENT PERFORMANCE ANALYZER");
            System.out.println("========================================");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Add Marks");
            System.out.println("7. View Marks");
            System.out.println("8. Update Marks");
            System.out.println("9. Delete Marks");
            System.out.println("10. Add Attendance");
            System.out.println("11. View Attendance");
            System.out.println("12. Update Attendance");
            System.out.println("13. Delete Attendance");
            System.out.println("14. Generate Performance Report");
            System.out.println("15. Class Statistics");
            System.out.println("16. Find Class Topper");
            System.out.println("17. Result Statistics");
            System.out.println("18. Grade Statistics");
            System.out.println("19. Exit");

            System.out.print("\nEnter your choice: ");

            String choiceInput = sc.nextLine();

            int choice;

            try {

                choice = Integer.parseInt(choiceInput.trim());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a number from 1 to 19."
                );

                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter Roll No: ");

                    int rollNo;

                    try {
                        rollNo = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Roll No!");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    if (!InputValidator.isValidName(name)) {
                        System.out.println("Invalid name!");
                        break;
                    }

                    Student student =
                            new Student(rollNo, name, course);

                    studentManager.addStudent(student);

                    break;

                case 2:

                    studentManager.viewStudents();

                    break;

                case 3:

                    System.out.print("Enter Roll No: ");

                    int searchRoll;

                    try {
                        searchRoll =
                                Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Roll No!");
                        break;
                    }

                    studentManager.searchStudent(searchRoll);

                    break;

                case 4:

                    System.out.print("Enter Roll No to update: ");

                    int updateRoll;

                    try {
                        updateRoll =
                                Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Roll No!");
                        break;
                    }

                    if (studentManager.findStudent(updateRoll) == null) {
                        System.out.println("Student not found!");
                        break;
                    }

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    if (!InputValidator.isValidName(newName)) {
                        System.out.println("Invalid name!");
                        break;
                    }

                    studentManager.updateStudent(
                            updateRoll,
                            newName,
                            newCourse
                    );

                    break;

                case 5:

                    System.out.print("Enter Roll No: ");

                    int deleteRoll;

                    try {
                        deleteRoll =
                                Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Roll No!");
                        break;
                    }

                    studentManager.deleteStudent(deleteRoll);

                    break;

                case 6:

                    System.out.print("Enter Roll No: ");

                    int marksRoll;

                    try {
                        marksRoll =
                                Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Roll No!");
                        break;
                    }

                    if (studentManager.findStudent(marksRoll) == null) {
                        System.out.println("Student does not exist!");
                        break;
                    }

                    System.out.print("Enter Java Marks: ");

                    double java;

                    try {
                        java =
                                Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid marks!");
                        break;
                    }

                    System.out.print("Enter OS Marks: ");

                    double os;

                    try {
                        os =
                                Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid marks!");
                        break;
                    }

                    System.out.print("Enter Mathematics Marks: ");

                    double maths;

                    try {
                        maths =
                                Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid marks!");
                        break;
                    }

                    if (!InputValidator.isValidMarks(java)
                            || !InputValidator.isValidMarks(os)
                            || !InputValidator.isValidMarks(maths)) {

                        System.out.println(
                                "Marks must be between 0 and 100!"
                        );

                        break;
                    }

                    Marks marks =
                            new Marks(
                                    marksRoll,
                                    java,
                                    os,
                                    maths
                            );

                    marksManager.addMarks(marks);

                    break;

                case 7:

                    marksManager.viewMarks();

                    break;

                case 8:

                    System.out.print(
                            "Enter Roll No to update marks: "
                    );

                    int updateMarksRoll;

                    try {
                        updateMarksRoll =
                                Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Roll No!");
                        break;
                    }

                    if (marksManager.findMarks(updateMarksRoll) == null) {
                        System.out.println("Marks not found!");
                        break;
                    }

                    System.out.print("Enter New Java Marks: ");

                    double newJava;

                    try {
                        newJava =
                                Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid marks!");
                        break;
                    }

                    System.out.print("Enter New OS Marks: ");

                    double newOs;

                    try {
                        newOs =
                                Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid marks!");
                        break;
                    }

                    System.out.print(
                            "Enter New Mathematics Marks: "
                    );

                    double newMaths;

                    try {
                        newMaths =
                                Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid marks!");
                        break;
                    }

                    if (!InputValidator.isValidMarks(newJava)
                            || !InputValidator.isValidMarks(newOs)
                            || !InputValidator.isValidMarks(newMaths)) {

                        System.out.println(
                                "Marks must be between 0 and 100!"
                        );

                        break;
                    }

                    marksManager.updateMarks(
                            updateMarksRoll,
                            newJava,
                            newOs,
                            newMaths
                    );

                    break;

                case 9:

                    System.out.print(
                            "Enter Roll No to delete marks: "
                    );

                    int deleteMarksRoll;

                    try {
                        deleteMarksRoll =
                                Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Roll No!");
                        break;
                    }

                    marksManager.deleteMarks(deleteMarksRoll);

                    break;

                case 10:

                    System.out.print("Enter Roll No: ");

                    int attendanceRoll;

                    try {
                        attendanceRoll =
                                Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Roll No!");
                        break;
                    }

                    if (studentManager.findStudent(attendanceRoll) == null) {
                        System.out.println(
                                "Student does not exist!"
                        );
                        break;
                    }

                    System.out.print("Enter Total Classes: ");

                    int totalClasses;

                    try {
                        totalClasses =
                                Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number!");
                        break;
                    }

                    System.out.print(
                            "Enter Attended Classes: "
                    );

                    int attendedClasses;

                    try {
                        attendedClasses =
                                Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number!");
                        break;
                    }

                    if (totalClasses <= 0
                            || attendedClasses < 0
                            || attendedClasses > totalClasses) {

                        System.out.println(
                                "Invalid attendance!"
                        );

                        break;
                    }

                    Attendance attendance =
                            new Attendance(
                                    attendanceRoll,
                                    totalClasses,
                                    attendedClasses
                            );

                    attendanceManager.addAttendance(
                            attendance
                    );

                    break;

                case 11:

                    attendanceManager.viewAttendance();

                    break;

                case 12:

                    System.out.print(
                            "Enter Roll No to update attendance: "
                    );

                    int updateAttendanceRoll;

                    try {
                        updateAttendanceRoll =
                                Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Roll No!");
                        break;
                    }

                    if (attendanceManager.findAttendance(
                            updateAttendanceRoll) == null) {

                        System.out.println(
                                "Attendance not found!"
                        );

                        break;
                    }

                    System.out.print(
                            "Enter New Total Classes: "
                    );

                    int newTotalClasses;

                    try {
                        newTotalClasses =
                                Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number!");
                        break;
                    }

                    System.out.print(
                            "Enter New Attended Classes: "
                    );

                    int newAttendedClasses;

                    try {
                        newAttendedClasses =
                                Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number!");
                        break;
                    }

                    if (newTotalClasses <= 0
                            || newAttendedClasses < 0
                            || newAttendedClasses > newTotalClasses) {

                        System.out.println(
                                "Invalid attendance!"
                        );

                        break;
                    }

                    attendanceManager.updateAttendance(
                            updateAttendanceRoll,
                            newTotalClasses,
                            newAttendedClasses
                    );

                    break;

                case 13:

                    System.out.print(
                            "Enter Roll No to delete attendance: "
                    );

                    int deleteAttendanceRoll;

                    try {
                        deleteAttendanceRoll =
                                Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Roll No!");
                        break;
                    }

                    attendanceManager.deleteAttendance(
                            deleteAttendanceRoll
                    );

                    break;

                case 14:

                    System.out.print("Enter Roll No: ");

                    int reportRoll;

                    try {
                        reportRoll =
                                Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Roll No!");
                        break;
                    }

                    reportGenerator.generateReport(
                            reportRoll,
                            studentManager,
                            marksManager,
                            attendanceManager
                    );

                    break;

                case 15:

                    statisticsManager.showClassStatistics();

                    break;

                case 16:

                    statisticsManager.showTopper();

                    break;

                case 17:

                    statisticsManager.showResultStatistics();

                    break;

                case 18:

                    statisticsManager.showGradeStatistics();

                    break;

                case 19:

                    System.out.println(
                            "\nThank you for using the system!"
                    );

                    sc.close();

                    return;

                default:

                    System.out.println(
                            "Invalid choice! Please enter 1 to 19."
                    );
            }
        }
    }
}