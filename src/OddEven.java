import java.util.Scanner;

public class OddEven {
    private Node head;

    class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    public void addNode(int data1) {
        Node newNode = new Node(data1);
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

    public void segregateEvenOdd() {
        if (head == null || head.next == null) {
            return;
        }
        Node temp = head;
        Node evenHead = null;
        Node oddHead = null;
        Node evenTail = null;
        Node oddTail = null;

        while (temp != null) {
            if (temp.data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = evenTail = temp;
                } else {
                    evenTail.next = temp;
                    evenTail = evenTail.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = oddTail = temp;
                } else {
                    oddTail.next = temp;
                    oddTail = oddTail.next;
                }
            }
            temp = temp.next;
        }

        if (oddTail != null) {
            oddTail.next = evenHead;
        }

        if (evenTail != null) {
            evenTail.next = null;
        }

        head = oddHead;
    }

    public void printlst() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        int data;
        Scanner input = new Scanner(System.in);
        OddEven list1 = new OddEven();

        while (true) {
            data = input.nextInt();
            if (data == -1) {
                break;
            }
            list1.addNode(data);
        }

        list1.segregateEvenOdd();
        list1.printlst();
    }
}
