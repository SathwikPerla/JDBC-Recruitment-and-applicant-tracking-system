package operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class FindHighApplicationJobs {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hiring_platform";
        String user = "root";
        String password = "eabs1234"; // replace if different

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();) {
            String query = "SELECT j.job_id, j.title, COUNT(a.application_id) AS total_applications " +
                    "FROM job j " +
                    "JOIN applications a ON j.job_id = a.job_id " +
                    "GROUP BY j.job_id, j.title " +
                    "HAVING total_applications > 50";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("------ Jobs with more than 50 Applications ------");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("Job ID: " + rs.getInt("job_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Applications: " + rs.getInt("total_applications"));
                System.out.println("-----------------------------------");
            }

            if (!found) {
                System.out.println("❌ No jobs found with more than 50 applications.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
