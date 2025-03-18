import java.util.Scanner;

public class CarbonApp {
    private static CarbonManager carbonManager = new CarbonManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🌱 Welcome to Personal Carbon Footprint Tracker 🌱");

        while (true) {
            System.out.println("\n1. Log Daily Activity");
            System.out.println("2. View Carbon Footprint Report");
            System.out.println("3. Get AI Eco-Friendly Suggestion");
            System.out.println("4. Compare Footprint with Global Average");
            System.out.println("5. Delete Activity Log");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    carbonManager.logActivity();
                    break;
                case 2:
                    carbonManager.viewCarbonReport();
                    break;
                case 3:
                    carbonManager.getEcoSuggestion();
                    break;
                case 4:
                    carbonManager.compareWithGlobal();
                    break;
                case 5:
                    carbonManager.deleteLog();
                    break;
                case 6:
                    System.out.println("Exiting... Make sustainable choices! 🌎");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
