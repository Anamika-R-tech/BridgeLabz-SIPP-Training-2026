
interface Trackable {
    void logActivity();

    default void resetData() {
        System.out.println("Fitness data reset successfully.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert();
}

class FitnessDevice implements Trackable, Reportable, Notifiable {

    public void logActivity() {
        System.out.println("Activity logged: 5000 steps completed.");
    }

    public void generateReport() {
        System.out.println("Report generated: Calories burned = 250.");
    }

    public void sendAlert() {
        System.out.println("Alert sent: Drink water!");
    }
}

public class FitnessTracker {
    public static void main(String[] args) {

        FitnessDevice device = new FitnessDevice();

        device.logActivity();
        device.generateReport();
        device.sendAlert();
        device.resetData();
    }
}