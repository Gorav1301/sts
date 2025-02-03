import java.util.*;

public class MinStack {

    static Stack<Integer> mainStack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();

    public static void getMin() {
        if (mainStack.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            int min = minStack.peek();
            System.out.println(min);
        }
    }

    public static void peek() {
        if (mainStack.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            int top = mainStack.peek();
            System.out.println("Top element: " + top);
        }
    }

    public static void pop() {
        if (mainStack.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            int poppedElement = mainStack.pop();
            if (!minStack.isEmpty() && poppedElement == minStack.peek()) {
                minStack.pop();
            }
            System.out.println("Popped element: " + poppedElement);
        }
    }

    public static void push(int value) {
        mainStack.push(value);
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalElements = scanner.nextInt();
        int operations = scanner.nextInt();
        
        for (int i = 0; i < operations; i++) {
            int element = scanner.nextInt();
            push(element);
        }
        
        getMin();
    }
}
