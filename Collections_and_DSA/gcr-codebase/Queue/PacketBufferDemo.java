class PacketBuffer {
    private final int[] data;
    private int front;
    private int count;

    public PacketBuffer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }

        data = new int[capacity];
        front = 0;
        count = 0;
    }

    public boolean enqueue(int packetId) {
        if (isFull()) {
            return false; // reject the new packet
        }

        int rear = (front + count) % data.length;
        data[rear] = packetId;
        count++;

        return true;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Buffer is empty");
        }

        int packetId = data[front];

        front = (front + 1) % data.length;
        count--;

        return packetId;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Buffer is empty");
        }

        return data[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == data.length;
    }

    public int size() {
        return count;
    }
}

public class PacketBufferDemo {
    public static void main(String[] args) {
        PacketBuffer buffer = new PacketBuffer(3);

        System.out.println(buffer.enqueue(101)); // true
        System.out.println(buffer.enqueue(102)); // true
        System.out.println(buffer.enqueue(103)); // true
        System.out.println(buffer.enqueue(104)); // false

        System.out.println(buffer.dequeue()); // 101
        System.out.println(buffer.dequeue()); // 102

        buffer.enqueue(104);
        buffer.enqueue(105);

        System.out.println(buffer.dequeue()); // 103
        System.out.println(buffer.dequeue()); // 104
        System.out.println(buffer.dequeue()); // 105
    }
}