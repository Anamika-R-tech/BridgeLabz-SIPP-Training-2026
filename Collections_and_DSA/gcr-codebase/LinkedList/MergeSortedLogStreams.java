public class MergeSortedLogStreams {

    static class Node {
        int timestamp;
        Node next;

        Node(int timestamp) {
            this.timestamp = timestamp;
            this.next = null;
        }
    }

    public static Node mergeLogStreams(Node first, Node second) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (first != null && second != null) {
            if (first.timestamp <= second.timestamp) {
                tail.next = first;
                first = first.next;
            } else {
                tail.next = second;
                second = second.next;
            }

            tail = tail.next;
        }

        if (first != null) {
            tail.next = first;
        } else {
            tail.next = second;
        }

        return dummy.next;
    }

    public static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.timestamp);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(3);
        first.next.next = new Node(5);
        first.next.next.next = new Node(8);

        Node second = new Node(2);
        second.next = new Node(4);
        second.next.next = new Node(6);
        second.next.next.next = new Node(7);

        System.out.println("First log stream:");
        printList(first);

        System.out.println("Second log stream:");
        printList(second);

        Node mergedHead = mergeLogStreams(first, second);

        System.out.println("Merged log stream:");
        printList(mergedHead);
    }
}