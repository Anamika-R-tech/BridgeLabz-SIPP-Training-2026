public class InsertTrackAfterCurrent {

    static class Node {
        int trackId;
        Node next;

        Node(int trackId) {
            this.trackId = trackId;
            this.next = null;
        }
    }

    public static void insertAfter(Node current, int trackId) {
        if (current == null) {
            return;
        }

        Node newNode = new Node(trackId);

        newNode.next = current.next;
        current.next = newNode;
    }

    public static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.trackId);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(101);
        head.next = new Node(102);
        head.next.next = new Node(103);

        System.out.println("Original playlist:");
        printList(head);

        Node currentlyPlaying = head.next;

        insertAfter(currentlyPlaying, 999);

        System.out.println("Playlist after insertion:");
        printList(head);
    }
}