public class UndoBufferDemo {

    static class UndoBuffer {
        private final String[] data;
        private int top;

        UndoBuffer(int maxDepth) {
            if (maxDepth <= 0) {
                throw new IllegalArgumentException(
                    "Maximum depth must be greater than zero"
                );
            }

            data = new String[maxDepth];
            top = -1;
        }

        public boolean push(String edit) {
            if (isFull()) {
                System.out.println(
                    "Undo buffer is full. Cannot add: " + edit
                );
                return false;
            }

            top++;
            data[top] = edit;

            return true;
        }

        public String pop() {
            if (isEmpty()) {
                throw new RuntimeException("Nothing to undo");
            }

            String removedEdit = data[top];

            // Remove the reference from the array
            data[top] = null;
            top--;

            return removedEdit;
        }

        public String peek() {
            if (isEmpty()) {
                throw new RuntimeException("Undo buffer is empty");
            }

            return data[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == data.length - 1;
        }

        public int size() {
            return top + 1;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Undo buffer is empty.");
                return;
            }

            System.out.println("Undo actions from latest to oldest:");

            for (int i = top; i >= 0; i--) {
                System.out.println(data[i]);
            }
        }
    }

    public static void main(String[] args) {
        UndoBuffer undoBuffer = new UndoBuffer(3);

        undoBuffer.push("Typed Hello");
        undoBuffer.push("Changed font size");
        undoBuffer.push("Deleted paragraph");

        undoBuffer.display();

        // Capacity is already 3, so this push will be rejected.
        undoBuffer.push("Inserted image");

        System.out.println(
            "Most recent edit: " + undoBuffer.peek()
        );

        System.out.println(
            "Undoing: " + undoBuffer.pop()
        );

        System.out.println(
            "New most recent edit: " + undoBuffer.peek()
        );

        System.out.println(
            "Current size: " + undoBuffer.size()
        );

        undoBuffer.display();
    }
}