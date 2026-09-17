import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManager {

    public void addStudent(Student student) {

        String sql = "INSERT INTO students (roll_no, name, course) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, student.getRollNo());
            statement.setString(2, student.getName());
            statement.setString(3, student.getCourse());

            statement.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (SQLException e) {

            System.out.println("Unable to add student.");
            System.out.println(e.getMessage());
        }
    }

    public Student findStudent(int rollNo) {

        String sql = "SELECT * FROM students WHERE roll_no = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, rollNo);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return new Student(
                        result.getInt("roll_no"),
                        result.getString("name"),
                        result.getString("course")
                );
            }

        } catch (SQLException e) {

            System.out.println("Error while searching student.");
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void viewStudents() {

        String sql = "SELECT * FROM students ORDER BY roll_no";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            boolean found = false;

            System.out.println("\n----- STUDENT LIST -----");

            while (result.next()) {

                found = true;

                System.out.println(
                        "Roll No: " + result.getInt("roll_no")
                        + " | Name: " + result.getString("name")
                        + " | Course: " + result.getString("course")
                );
            }

            if (!found) {
                System.out.println("No students found.");
            }

        } catch (SQLException e) {

            System.out.println("Error while viewing students.");
            System.out.println(e.getMessage());
        }
    }

    public void searchStudent(int rollNo) {

        Student student = findStudent(rollNo);

        if (student != null) {

            System.out.println("\nStudent found:");
            student.display();

        } else {

            System.out.println("Student not found.");
        }
    }

    public void updateStudent(int rollNo, String name, String course) {

        String sql = "UPDATE students SET name = ?, course = ? WHERE roll_no = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, course);
            statement.setInt(3, rollNo);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("Student updated successfully!");

            } else {

                System.out.println("Student not found.");
            }

        } catch (SQLException e) {

            System.out.println("Unable to update student.");
            System.out.println(e.getMessage());
        }
    }

    public void deleteStudent(int rollNo) {

        String sql = "DELETE FROM students WHERE roll_no = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, rollNo);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("Student deleted successfully!");

            } else {

                System.out.println("Student not found.");
            }

        } catch (SQLException e) {

            System.out.println("Unable to delete student.");
            System.out.println(e.getMessage());
        }
    }
}