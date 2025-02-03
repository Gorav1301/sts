import java.util.*;

public class OddEven {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        Node head = createLinkedList(input);
        head = rearrangeOddEven(head);
        printLinkedList(head);

        sc.close();
    }

    public static Node createLinkedList(String[] input) {
        Node head = null, tail = null;

        for (String value : input) {
            if (value.equals("-1")) break;
            int data = Integer.parseInt(value);

            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    public static Node rearrangeOddEven(Node head) {
        if (head == null) return null;

        Node oddHead = null, oddTail = null;
        Node evenHead = null, evenTail = null;

        Node current = head;

        while (current != null) {
            if (current.data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = current;
                    evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
            } else {
                if (oddHead == null) {
                    oddHead = current;
                    oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }
            }
            current = current.next;
        }

        if (oddTail != null) oddTail.next = evenHead;
        if (evenTail != null) evenTail.next = null;

        return oddHead != null ? oddHead : evenHead;
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
