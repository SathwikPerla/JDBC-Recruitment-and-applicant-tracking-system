package operations;

import java.sql.*;
import java.util.Scanner;

public class ListInterviewCandidates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Job ID: ");
        int jobId = sc.nextInt();

        String url = "jdbc:mysql://localhost:3306/hiring_platform"; // adjust if needed
        String user = "root"; // use your DB username
        String password = "eabs1234"; // your DB password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = """
                        SELECT u.user_id, u.name, u.email, u.gender, u.phoneNo, u.dateOfBirth
                        FROM applications a
                        JOIN candidate c ON a.candidate_id = c.candidate_id
                        JOIN user u ON c.user_id = u.user_id
                        WHERE a.job_id = ? AND a.current_stage_id = 3
                    """;

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, jobId);

            ResultSet rs = pstmt.executeQuery();

            System.out.println("----- Candidates in Interview Stage -----");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("ID: " + rs.getInt("user_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Phone: " + rs.getString("phoneNo"));
                System.out.println("DOB: " + rs.getDate("dateOfBirth"));
                System.out.println("-----------------------------------------");
            }

            if (!found) {
                System.out.println("⚠️ No candidates found in interview stage for Job ID: " + jobId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
