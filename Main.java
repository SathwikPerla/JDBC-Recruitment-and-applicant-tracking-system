import java.util.Scanner;
import operations.FindHighApplicationJobs;

import operations.ListInterviewCandidates;
import operations.RetrieveInterviewSchedules;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n----------- MENU -----------");
        System.out.println("1. List Candidates in Interview Stage");
        System.out.println("2. Retrieve Interview Schedules");
        System.out.println("3. Find Jobs with >50 Applications");

        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {
            case 1:
                ListInterviewCandidates.main(null);
                break;
            case 2:
                RetrieveInterviewSchedules.main(null);
                break;
            case 3:
                FindHighApplicationJobs.main(null);
                break;

            case 4:
                System.out.println("✅ Exiting...");
                break;
            default:
                System.out.println("❌ Invalid choice. Exiting.");
        }

        sc.close();
    }
}
