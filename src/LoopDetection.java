import java.util.HashSet;
import java.util.Scanner;

public class LoopDetection {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public boolean hasCycle() {
        HashSet<Integer> seen = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if (seen.contains(temp.data)) {
                return true;
            }
            seen.add(temp.data);
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LoopDetection list = new LoopDetection();
        
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            list.insert(data);
        }

        if (list.hasCycle()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
