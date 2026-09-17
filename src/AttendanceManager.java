import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceManager {

    public void addAttendance(Attendance attendance) {

        String sql = "INSERT INTO attendance (roll_no, total_classes, attended_classes) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, attendance.getRollNo());
            statement.setInt(2, attendance.getTotalClasses());
            statement.setInt(3, attendance.getAttendedClasses());

            statement.executeUpdate();

            System.out.println("Attendance added successfully!");

        } catch (SQLException e) {

            System.out.println("Unable to add attendance.");
            System.out.println(e.getMessage());
        }
    }

    public Attendance findAttendance(int rollNo) {

        String sql = "SELECT * FROM attendance WHERE roll_no = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, rollNo);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return new Attendance(
                        result.getInt("roll_no"),
                        result.getInt("total_classes"),
                        result.getInt("attended_classes")
                );
            }

        } catch (SQLException e) {

            System.out.println("Error while searching attendance.");
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void viewAttendance() {

        String sql = "SELECT * FROM attendance ORDER BY roll_no";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            boolean found = false;

            System.out.println("\n----- ATTENDANCE -----");

            while (result.next()) {

                found = true;

                int rollNo = result.getInt("roll_no");
                int totalClasses = result.getInt("total_classes");
                int attendedClasses = result.getInt("attended_classes");

                Attendance attendance = new Attendance(
                        rollNo,
                        totalClasses,
                        attendedClasses
                );

                System.out.println("Roll No: " + rollNo);
                attendance.displayAttendance();

                System.out.println("----------------------");
            }

            if (!found) {
                System.out.println("No attendance found.");
            }

        } catch (SQLException e) {

            System.out.println("Error while viewing attendance.");
            System.out.println(e.getMessage());
        }
    }

    public void updateAttendance(
            int rollNo,
            int totalClasses,
            int attendedClasses) {

        String sql = "UPDATE attendance SET total_classes = ?, attended_classes = ? WHERE roll_no = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, totalClasses);
            statement.setInt(2, attendedClasses);
            statement.setInt(3, rollNo);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("Attendance updated successfully!");

            } else {

                System.out.println("Attendance not found.");
            }

        } catch (SQLException e) {

            System.out.println("Unable to update attendance.");
            System.out.println(e.getMessage());
        }
    }

    public void deleteAttendance(int rollNo) {

        String sql = "DELETE FROM attendance WHERE roll_no = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, rollNo);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("Attendance deleted successfully!");

            } else {

                System.out.println("Attendance not found.");
            }

        } catch (SQLException e) {

            System.out.println("Unable to delete attendance.");
            System.out.println(e.getMessage());
        }
    }
}