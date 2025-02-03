import java.util.Scanner;

public class MergeSortDLL {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        if (left.data <= right.data) {
            left.next = merge(left.next, right);
            left.next.prev = left;
            left.prev = null;
            return left;
        } else {
            right.next = merge(left, right.next);
            right.next.prev = right;
            right.prev = null;
            return right;
        }
    }

    static Node split(Node head) {
        if (head == null || head.next == null) return head;

        Node slow = head;
        Node fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node middle = slow.next;
        slow.next = null;

        return middle;
    }

    static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        Node middle = split(head);
        Node left = mergeSort(head);
        Node right = mergeSort(middle);

        return merge(left, right);
    }

    static void printAscending(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void printDescending(Node head) {
        if (head == null) return;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            head = insert(head, data);
        }

        head = mergeSort(head);
        printAscending(head);
        printDescending(head);
    }
}
