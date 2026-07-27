import java.util.*;

class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class TriageQueue {

    private PriorityQueue<Patient> queue =
            new PriorityQueue<>((a, b) ->
                    Integer.compare(b.severity, a.severity));

    public void addPatient(Patient patient) {
        queue.offer(patient);
    }

    public Patient treatNext() {
        if (queue.isEmpty()) {
            return null;
        }

        return queue.poll();
    }

    public Patient mostSeverePatient() {
        return queue.peek();
    }

    public static void main(String[] args) {
        TriageQueue triage = new TriageQueue();

        triage.addPatient(new Patient("Aman", 4));
        triage.addPatient(new Patient("Riya", 9));
        triage.addPatient(new Patient("Karan", 6));

        Patient patient = triage.treatNext();

        System.out.println(patient.name + " " + patient.severity);
    }
}