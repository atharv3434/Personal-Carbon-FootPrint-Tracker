public class ActivityLog {
    private String activityType;
    private double co2Emission; // kg CO2

    public ActivityLog(String activityType, double co2Emission) {
        this.activityType = activityType;
        this.co2Emission = co2Emission;
    }

    public String getActivityType() { return activityType; }
    public double getCo2Emission() { return co2Emission; }

    @Override
    public String toString() {
        return "🚀 Activity: " + activityType + " | 🌍 CO₂ Emission: " + co2Emission + " kg";
    }
}
