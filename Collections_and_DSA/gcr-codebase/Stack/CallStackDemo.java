public class CallStackDemo {

    static class CallStack {

        private static class Frame {
            String functionName;
            Frame next;

            Frame(String functionName, Frame next) {
                this.functionName = functionName;
                this.next = next;
            }
        }

        private Frame top;
        private int size;

        CallStack() {
            top = null;
            size = 0;
        }

        public void push(String functionName) {
            Frame newFrame = new Frame(functionName, top);

            top = newFrame;
            size++;
        }

        public String pop() {
            if (isEmpty()) {
                throw new RuntimeException(
                    "No active call to return from"
                );
            }

            String functionName = top.functionName;

            top = top.next;
            size--;

            return functionName;
        }

        public String peek() {
            if (isEmpty()) {
                throw new RuntimeException(
                    "There is no currently executing function"
                );
            }

            return top.functionName;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public int size() {
            return size;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Call stack is empty.");
                return;
            }

            System.out.println("Call stack from top to bottom:");

            Frame current = top;

            while (current != null) {
                System.out.println(current.functionName);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        CallStack callStack = new CallStack();

        callStack.push("main()");
        callStack.push("processRequest()");
        callStack.push("validateUser()");
        callStack.push("checkDatabase()");

        callStack.display();

        System.out.println(
            "Currently executing: " + callStack.peek()
        );

        System.out.println(
            "Returning from: " + callStack.pop()
        );

        System.out.println(
            "Now executing: " + callStack.peek()
        );

        System.out.println(
            "Active function calls: " + callStack.size()
        );

        callStack.display();
    }
}