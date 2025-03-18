import java.util.*;

public class CarbonManager {
    private List<ActivityLog> activityLogs;
    private Scanner sc;

    public CarbonManager() {
        this.activityLogs = DataStorage1.loadActivityLogs();
        this.sc = new Scanner(System.in);
    }

    public void logActivity() {
        System.out.println("Select an activity type:");
        System.out.println("1. Car Travel (per km) - 0.12 kg CO₂");
        System.out.println("2. Public Transport (per km) - 0.05 kg CO₂");
        System.out.println("3. Meat-Based Meal - 3.0 kg CO₂");
        System.out.println("4. Vegetarian Meal - 1.5 kg CO₂");
        System.out.println("5. Electricity Usage (per kWh) - 0.45 kg CO₂");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        double emission = 0;
        String activity = "";

        switch (choice) {
            case 1:
                System.out.print("Enter distance traveled (km): ");
                double distance = sc.nextDouble();
                emission = distance * 0.12;
                activity = "Car Travel (" + distance + " km)";
                break;
            case 2:
                System.out.print("Enter distance traveled (km): ");
                distance = sc.nextDouble();
                emission = distance * 0.05;
                activity = "Public Transport (" + distance + " km)";
                break;
            case 3:
                emission = 3.0;
                activity = "Meat-Based Meal";
                break;
            case 4:
                emission = 1.5;
                activity = "Vegetarian Meal";
                break;
            case 5:
                System.out.print("Enter electricity usage (kWh): ");
                double usage = sc.nextDouble();
                emission = usage * 0.45;
                activity = "Electricity (" + usage + " kWh)";
                break;
            default:
                System.out.println("❌ Invalid choice.");
                return;
        }

        activityLogs.add(new ActivityLog(activity, emission));
        DataStorage1.saveActivityLogs(activityLogs);
        System.out.println("✅ Activity Logged Successfully!");
    }

    public void viewCarbonReport() {
        if (activityLogs.isEmpty()) {
            System.out.println("📄 No activity logs found.");
            return;
        }

        double totalEmissions = 0;
        System.out.println("\n📊 Your Carbon Footprint Report:");
        for (ActivityLog log : activityLogs) {
            System.out.println(log);
            totalEmissions += log.getCo2Emission();
        }

        System.out.println("\n🌍 Total CO₂ Emissions: " + String.format("%.2f", totalEmissions) + " kg");
    }

    public void getEcoSuggestion() {
        if (activityLogs.isEmpty()) {
            System.out.println("📌 No data available for AI suggestions.");
            return;
        }

        String latestActivity = activityLogs.get(activityLogs.size() - 1).getActivityType();
        System.out.println("🤖 AI Eco-Friendly Tip for: " + latestActivity);
        System.out.println(EcoAssistant.getSuggestion(latestActivity));
    }

    public void compareWithGlobal() {
        double globalAvg = 20.0; // Average daily CO₂ emission in kg per person
        double totalEmissions = activityLogs.stream().mapToDouble(ActivityLog::getCo2Emission).sum();

        System.out.println("\n🌍 Your Total Daily CO₂ Emission: " + String.format("%.2f", totalEmissions) + " kg");
        System.out.println("📊 Global Average CO₂ Emission: " + globalAvg + " kg");

        if (totalEmissions < globalAvg) {
            System.out.println("✅ You're below the global average! Keep it up! 🌿");
        } else {
            System.out.println("⚠️ Your footprint is above the global average. Try reducing high-carbon activities.");
        }
    }

    public void deleteLog() {
        viewCarbonReport();
        System.out.print("Enter log number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < activityLogs.size()) {
            activityLogs.remove(index);
            DataStorage1.saveActivityLogs(activityLogs);
            System.out.println("✅ Activity Log Deleted Successfully!");
        } else {
            System.out.println("❌ Invalid entry number.");
        }
    }
}
