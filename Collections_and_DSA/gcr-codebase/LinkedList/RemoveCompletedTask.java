public class RemoveCompletedTask {

    static class Node {
        int taskId;
        Node next;

        Node(int taskId) {
            this.taskId = taskId;
            this.next = null;
        }
    }

    public static Node removeTask(Node head, int taskId) {
        if (head == null) {
            return null;
        }

        if (head.taskId == taskId) {
            return head.next;
        }

        Node previous = head;
        Node current = head.next;

        while (current != null && current.taskId != taskId) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
        }

        return head;
    }

    public static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.taskId);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("Original task queue:");
        printList(head);

        head = removeTask(head, 30);

        System.out.println("After removing task 30:");
        printList(head);

        head = removeTask(head, 10);

        System.out.println("After removing the head task 10:");
        printList(head);
    }
}