package operations;

import java.sql.*;
import java.util.Scanner;

public class RetrieveInterviewSchedules {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Interviewer ID: ");
        int interviewerId = sc.nextInt();

        String url = "jdbc:mysql://localhost:3306/hiring_platform";
        String user = "root";
        String password = "eabs1234";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = """
                        SELECT
                            i.id AS interview_id,
                            u.name AS candidate_name,
                            j.title AS job_title,
                            i.scheduled_at,
                            i.status,
                            i.result
                        FROM interviews i
                        JOIN applications a ON i.application_id = a.application_id
                        JOIN candidate c ON a.candidate_id = c.candidate_id
                        JOIN user u ON c.user_id = u.user_id
                        JOIN job j ON a.job_id = j.job_id
                        WHERE i.interviewer_id = ?;
                    """;

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, interviewerId);

            ResultSet rs = pstmt.executeQuery();
            boolean found = false;

            System.out.println("\n----- Interview Schedules -----");
            while (rs.next()) {
                found = true;
                System.out.println("Interview ID : " + rs.getInt("interview_id"));
                System.out.println("Candidate     : " + rs.getString("candidate_name"));
                System.out.println("Job Title     : " + rs.getString("job_title"));
                System.out.println("Scheduled At  : " + rs.getTimestamp("scheduled_at"));
                System.out.println("Status        : " + rs.getString("status"));
                System.out.println("Result        : " + rs.getString("result"));
                System.out.println("--------------------------------------");
            }

            if (!found) {
                System.out.println("❌ No interviews found for interviewer ID: " + interviewerId);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
