public class ReverseBrowserHistory {

    static class Node {
        String page;
        Node next;

        Node(String page) {
            this.page = page;
            this.next = null;
        }
    }

    public static Node reverseHistory(Node head) {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;

            current.next = previous;

            previous = current;
            current = nextNode;
        }

        return previous;
    }

    public static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.page);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node("Google");
        head.next = new Node("YouTube");
        head.next.next = new Node("GitHub");
        head.next.next.next = new Node("LeetCode");

        System.out.println("Original browser history:");
        printList(head);

        head = reverseHistory(head);

        System.out.println("Reversed browser history:");
        printList(head);
    }
}