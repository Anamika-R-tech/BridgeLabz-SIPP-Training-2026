import java.util.ArrayDeque;
import java.util.Deque;

class PrintServer {
    private final Deque<Integer> printQueue;

    public PrintServer() {
        printQueue = new ArrayDeque<>();
    }

    public void submitJob(int jobId) {
        printQueue.addLast(jobId);
        System.out.println("Normal job submitted: " + jobId);
    }

    public void submitUrgentJob(int jobId) {
        printQueue.addFirst(jobId);
        System.out.println("Urgent job submitted: " + jobId);
    }

    public int printNextJob() {
        if (printQueue.isEmpty()) {
            throw new RuntimeException("No print jobs available");
        }

        return printQueue.removeFirst();
    }

    public int viewNextJob() {
        if (printQueue.isEmpty()) {
            throw new RuntimeException("No print jobs available");
        }

        return printQueue.peekFirst();
    }

    public boolean isEmpty() {
        return printQueue.isEmpty();
    }
}

public class PrintServerDemo {
    public static void main(String[] args) {
        PrintServer server = new PrintServer();

        server.submitJob(101);
        server.submitJob(102);
        server.submitJob(103);

        server.submitUrgentJob(999);

        System.out.println("Printing: " + server.printNextJob()); // 999
        System.out.println("Printing: " + server.printNextJob()); // 101
        System.out.println("Printing: " + server.printNextJob()); // 102
        System.out.println("Printing: " + server.printNextJob()); // 103
    }
}