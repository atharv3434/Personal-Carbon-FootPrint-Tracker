import java.io.*;
import java.util.*;

public class DataStorage1 {
    private static final String FILE_PATH = "carbon_data.txt";

    // Save activity logs to file
    public static void saveActivityLogs(List<ActivityLog> activityLogs) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(activityLogs);
        } catch (IOException e) {
            System.out.println("❌ Error saving activity logs.");
        }
    }

    // Load activity logs from file
    public static List<ActivityLog> loadActivityLogs() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<ActivityLog>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
