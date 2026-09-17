public class Marks {

    private int rollNo;
    private double java;
    private double os;
    private double maths;

    public Marks(int rollNo, double java, double os, double maths) {
        this.rollNo = rollNo;
        this.java = java;
        this.os = os;
        this.maths = maths;
    }

    public int getRollNo() {
        return rollNo;
    }

    public double getJava() {
        return java;
    }

    public double getOs() {
        return os;
    }

    public double getMaths() {
        return maths;
    }

    public double getTotal() {
        return java + os + maths;
    }

    public double getPercentage() {
        return getTotal() / 3;
    }

    public String getGrade() {

        double percentage = getPercentage();

        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public void displayMarks() {

        System.out.println("Roll No    : " + rollNo);
        System.out.println("Java       : " + java);
        System.out.println("OS         : " + os);
        System.out.println("Mathematics: " + maths);
        System.out.println("Total      : " + getTotal());
        System.out.println("Percentage : " + getPercentage() + "%");
        System.out.println("Grade      : " + getGrade());
    }
}