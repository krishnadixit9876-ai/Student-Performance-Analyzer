public class InputValidator {

    public static boolean isValidMarks(double marks) {
        return marks >= 0 && marks <= 100;
    }

    public static boolean isValidAttendance(double attendance) {
        return attendance >= 0 && attendance <= 100;
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }
}