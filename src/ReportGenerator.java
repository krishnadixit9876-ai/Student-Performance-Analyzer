public class ReportGenerator {

    public void generateReport(
            int rollNo,
            StudentManager studentManager,
            MarksManager marksManager,
            AttendanceManager attendanceManager) {

        System.out.println("\n========================================");
        System.out.println("       STUDENT PERFORMANCE REPORT");
        System.out.println("========================================");

        Student student = studentManager.findStudent(rollNo);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        Marks marks = marksManager.findMarks(rollNo);

        if (marks == null) {
            System.out.println("Marks not found for this student!");
            return;
        }

        Attendance attendance =
                attendanceManager.findAttendance(rollNo);

        if (attendance == null) {
            System.out.println("Attendance not found for this student!");
            return;
        }

        System.out.println("\n----- STUDENT DETAILS -----");
        System.out.println("Roll No : " + student.getRollNo());
        System.out.println("Name    : " + student.getName());
        System.out.println("Course  : " + student.getCourse());

        System.out.println("\n----- MARKS -----");
        marks.displayMarks();

        System.out.println("\n----- ATTENDANCE -----");
        attendance.displayAttendance();

        System.out.println("\n----- FINAL RESULT -----");

        System.out.println("Percentage : "
                + marks.getPercentage() + "%");

        System.out.println("Grade      : "
                + marks.getGrade());

        if (marks.getGrade().equals("F")) {

            System.out.println("Result     : FAIL");

        } else if (attendance.getPercentage() < 75) {

            System.out.println("Result     : NOT ELIGIBLE");

        } else {

            System.out.println("Result     : PASS");
        }

        System.out.println("========================================");
    }
}