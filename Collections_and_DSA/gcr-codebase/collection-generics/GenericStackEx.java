import java.util.ArrayList;

class MyStack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.println(stack);
    }
}

public class GenericStackEx {
    public static void main(String[] args) {
        MyStack<Integer> intStack = new MyStack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        intStack.display();
        System.out.println("Popped: " + intStack.pop());
        System.out.println("Top: " + intStack.peek());

        MyStack<String> stringStack = new MyStack<>();
        stringStack.push("Java");
        stringStack.push("Generics");

        stringStack.display();
    }
}