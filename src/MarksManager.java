import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MarksManager {

    public void addMarks(Marks marks) {

        String sql = "INSERT INTO marks (roll_no, java, os, maths) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, marks.getRollNo());
            statement.setDouble(2, marks.getJava());
            statement.setDouble(3, marks.getOs());
            statement.setDouble(4, marks.getMaths());

            statement.executeUpdate();

            System.out.println("Marks added successfully!");

        } catch (SQLException e) {

            System.out.println("Unable to add marks.");
            System.out.println(e.getMessage());
        }
    }

    public Marks findMarks(int rollNo) {

        String sql = "SELECT * FROM marks WHERE roll_no = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, rollNo);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return new Marks(
                        result.getInt("roll_no"),
                        result.getDouble("java"),
                        result.getDouble("os"),
                        result.getDouble("maths")
                );
            }

        } catch (SQLException e) {

            System.out.println("Error while searching marks.");
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void viewMarks() {

        String sql = "SELECT * FROM marks ORDER BY roll_no";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            boolean found = false;

            System.out.println("\n----- STUDENT MARKS -----");

            while (result.next()) {

                found = true;

                Marks marks = new Marks(
                        result.getInt("roll_no"),
                        result.getDouble("java"),
                        result.getDouble("os"),
                        result.getDouble("maths")
                );

                marks.displayMarks();

                System.out.println("-------------------------");
            }

            if (!found) {
                System.out.println("No marks found.");
            }

        } catch (SQLException e) {

            System.out.println("Error while viewing marks.");
            System.out.println(e.getMessage());
        }
    }

    public void updateMarks(
            int rollNo,
            double java,
            double os,
            double maths) {

        String sql = "UPDATE marks SET java = ?, os = ?, maths = ? WHERE roll_no = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, java);
            statement.setDouble(2, os);
            statement.setDouble(3, maths);
            statement.setInt(4, rollNo);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("Marks updated successfully!");

            } else {

                System.out.println("Marks not found.");
            }

        } catch (SQLException e) {

            System.out.println("Unable to update marks.");
            System.out.println(e.getMessage());
        }
    }

    public void deleteMarks(int rollNo) {

        String sql = "DELETE FROM marks WHERE roll_no = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, rollNo);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("Marks deleted successfully!");

            } else {

                System.out.println("Marks not found.");
            }

        } catch (SQLException e) {

            System.out.println("Unable to delete marks.");
            System.out.println(e.getMessage());
        }
    }
}