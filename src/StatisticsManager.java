import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticsManager {

    public void showClassStatistics() {

        String sql = "SELECT COUNT(*) AS total_students, " +
                     "AVG((java + os + maths) / 3) AS average_percentage, " +
                     "MAX((java + os + maths) / 3) AS highest_percentage, " +
                     "MIN((java + os + maths) / 3) AS lowest_percentage " +
                     "FROM marks";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            if (result.next()) {

                int totalStudents =
                        result.getInt("total_students");

                double average =
                        result.getDouble("average_percentage");

                double highest =
                        result.getDouble("highest_percentage");

                double lowest =
                        result.getDouble("lowest_percentage");

                System.out.println("\n========================================");
                System.out.println("          CLASS STATISTICS");
                System.out.println("========================================");

                System.out.println("Total Students : " + totalStudents);
                System.out.printf("Class Average  : %.2f%%\n", average);
                System.out.printf("Highest Marks  : %.2f%%\n", highest);
                System.out.printf("Lowest Marks   : %.2f%%\n", lowest);

                System.out.println("========================================");
            }

        } catch (SQLException e) {

            System.out.println("Unable to generate class statistics.");
            System.out.println(e.getMessage());
        }
    }

    public void showTopper() {

        String sql = "SELECT s.roll_no, s.name, s.course, " +
                     "((m.java + m.os + m.maths) / 3) AS percentage " +
                     "FROM students s " +
                     "INNER JOIN marks m ON s.roll_no = m.roll_no " +
                     "ORDER BY percentage DESC " +
                     "LIMIT 1";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            System.out.println("\n========================================");
            System.out.println("              CLASS TOPPER");
            System.out.println("========================================");

            if (result.next()) {

                System.out.println("Roll No     : "
                        + result.getInt("roll_no"));

                System.out.println("Name        : "
                        + result.getString("name"));

                System.out.println("Course      : "
                        + result.getString("course"));

                System.out.printf("Percentage  : %.2f%%\n",
                        result.getDouble("percentage"));

            } else {

                System.out.println("No marks available.");
            }

            System.out.println("========================================");

        } catch (SQLException e) {

            System.out.println("Unable to find topper.");
            System.out.println(e.getMessage());
        }
    }

    public void showResultStatistics() {

        String sql = "SELECT " +
                     "SUM(CASE WHEN ((java + os + maths) / 3) >= 50 THEN 1 ELSE 0 END) AS pass_count, " +
                     "SUM(CASE WHEN ((java + os + maths) / 3) < 50 THEN 1 ELSE 0 END) AS fail_count " +
                     "FROM marks";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            if (result.next()) {

                int passCount =
                        result.getInt("pass_count");

                int failCount =
                        result.getInt("fail_count");

                System.out.println("\n========================================");
                System.out.println("          RESULT STATISTICS");
                System.out.println("========================================");

                System.out.println("Passed Students : " + passCount);
                System.out.println("Failed Students : " + failCount);

                System.out.println("========================================");
            }

        } catch (SQLException e) {

            System.out.println("Unable to generate result statistics.");
            System.out.println(e.getMessage());
        }
    }

    public void showGradeStatistics() {

        String sql = "SELECT " +
                     "SUM(CASE WHEN ((java + os + maths) / 3) >= 90 THEN 1 ELSE 0 END) AS a_plus, " +
                     "SUM(CASE WHEN ((java + os + maths) / 3) >= 80 AND ((java + os + maths) / 3) < 90 THEN 1 ELSE 0 END) AS a_grade, " +
                     "SUM(CASE WHEN ((java + os + maths) / 3) >= 70 AND ((java + os + maths) / 3) < 80 THEN 1 ELSE 0 END) AS b_grade, " +
                     "SUM(CASE WHEN ((java + os + maths) / 3) >= 60 AND ((java + os + maths) / 3) < 70 THEN 1 ELSE 0 END) AS c_grade, " +
                     "SUM(CASE WHEN ((java + os + maths) / 3) >= 50 AND ((java + os + maths) / 3) < 60 THEN 1 ELSE 0 END) AS d_grade, " +
                     "SUM(CASE WHEN ((java + os + maths) / 3) < 50 THEN 1 ELSE 0 END) AS f_grade " +
                     "FROM marks";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            if (result.next()) {

                System.out.println("\n========================================");
                System.out.println("           GRADE STATISTICS");
                System.out.println("========================================");

                System.out.println("A+ Grade : "
                        + result.getInt("a_plus"));

                System.out.println("A Grade  : "
                        + result.getInt("a_grade"));

                System.out.println("B Grade  : "
                        + result.getInt("b_grade"));

                System.out.println("C Grade  : "
                        + result.getInt("c_grade"));

                System.out.println("D Grade  : "
                        + result.getInt("d_grade"));

                System.out.println("F Grade  : "
                        + result.getInt("f_grade"));

                System.out.println("========================================");
            }

        } catch (SQLException e) {

            System.out.println("Unable to generate grade statistics.");
            System.out.println(e.getMessage());
        }
    }
}