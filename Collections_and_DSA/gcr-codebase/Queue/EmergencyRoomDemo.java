import java.util.PriorityQueue;

class Patient {
    int priority;
    String name;
    int arrivalOrder;

    public Patient(int priority, String name, int arrivalOrder) {
        this.priority = priority;
        this.name = name;
        this.arrivalOrder = arrivalOrder;
    }

    @Override
    public String toString() {
        return name + " - Priority: " + priority;
    }
}

class EmergencyRoom {
    private final PriorityQueue<Patient> triageQueue;
    private int arrivalCounter;

    public EmergencyRoom() {
        arrivalCounter = 0;

        triageQueue = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) {
                return Integer.compare(a.priority, b.priority);
            }

            // Same priority: patient who arrived earlier is served first
            return Integer.compare(a.arrivalOrder, b.arrivalOrder);
        });
    }

    public void admitPatient(String name, int priority) {
        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException(
                "Priority must be between 1 and 5"
            );
        }

        Patient patient = new Patient(priority, name, arrivalCounter++);
        triageQueue.offer(patient);
    }

    public Patient callNextPatient() {
        if (triageQueue.isEmpty()) {
            throw new RuntimeException("No patients are waiting");
        }

        return triageQueue.poll();
    }

    public Patient viewMostUrgentPatient() {
        if (triageQueue.isEmpty()) {
            throw new RuntimeException("No patients are waiting");
        }

        return triageQueue.peek();
    }

    public boolean isEmpty() {
        return triageQueue.isEmpty();
    }
}

public class EmergencyRoomDemo {
    public static void main(String[] args) {
        EmergencyRoom emergencyRoom = new EmergencyRoom();

        emergencyRoom.admitPatient("Aman", 4);
        emergencyRoom.admitPatient("Riya", 1);
        emergencyRoom.admitPatient("Neha", 3);
        emergencyRoom.admitPatient("Rahul", 1);

        System.out.println(emergencyRoom.callNextPatient());
        System.out.println(emergencyRoom.callNextPatient());
        System.out.println(emergencyRoom.callNextPatient());
        System.out.println(emergencyRoom.callNextPatient());
    }
}