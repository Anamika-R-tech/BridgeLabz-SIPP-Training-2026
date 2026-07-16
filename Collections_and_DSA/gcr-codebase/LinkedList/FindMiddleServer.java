public class FindMiddleServer {

    static class Node {
        int serverId;
        Node next;

        Node(int serverId) {
            this.serverId = serverId;
            this.next = null;
        }
    }

    public static Node findMiddleServer(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.serverId);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Server chain:");
        printList(head);

        Node middle = findMiddleServer(head);

        if (middle != null) {
            System.out.println("Middle server: " + middle.serverId);
        } else {
            System.out.println("Server chain is empty.");
        }
    }
}