public class Attendance {

    private int rollNo;
    private int totalClasses;
    private int attendedClasses;

    public Attendance(int rollNo, int totalClasses, int attendedClasses) {
        this.rollNo = rollNo;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int getTotalClasses() {
        return totalClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public double getPercentage() {

        if (totalClasses == 0) {
            return 0;
        }

        return (attendedClasses * 100.0) / totalClasses;
    }

    public String getStatus() {

        if (getPercentage() >= 75) {
            return "Eligible";
        } else {
            return "Not Eligible";
        }
    }

    public void displayAttendance() {

        System.out.println("Total Classes    : " + totalClasses);
        System.out.println("Attended Classes : " + attendedClasses);
        System.out.println("Attendance       : " + getPercentage() + "%");
        System.out.println("Status           : " + getStatus());
    }
}