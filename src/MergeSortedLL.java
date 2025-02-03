import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortedLL {
    static Node head1 = null;
    static Node head2 = null;

    public static void insert(Node head, int data) {
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

    public static Node mergeSortedLists(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        if (head1.data < head2.data) {
            head1.next = mergeSortedLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeSortedLists(head1, head2.next);
            return head2;
        }
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        for (int i = 0; i < n1; i++) {
            int data = sc.nextInt();
            insert(head1, data);
        }

        int n2 = sc.nextInt();
        for (int i = 0; i < n2; i++) {
            int data = sc.nextInt();
            insert(head2, data);
        }

        Node mergedHead = mergeSortedLists(head1, head2);
        printList(mergedHead);
    }
}
