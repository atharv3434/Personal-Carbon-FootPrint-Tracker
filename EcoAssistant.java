import java.util.HashMap;
import java.util.Map;

public class EcoAssistant {
    private static final Map<String, String> ecoTips = new HashMap<>();

    static {
        ecoTips.put("Car Travel", "🚲 Try cycling or walking for short distances!");
        ecoTips.put("Meat-Based Meal", "🥗 Reduce meat consumption to lower your carbon footprint.");
        ecoTips.put("Electricity", "🔋 Save power by using energy-efficient appliances.");
    }

    public static String getSuggestion(String activity) {
        return ecoTips.getOrDefault(activity, "♻️ Try adopting more sustainable habits!");
    }
}
