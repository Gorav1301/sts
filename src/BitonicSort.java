import java.util.*;

public class BitonicSort {
    static class Node {
        int data;
        Node next;
        Node prev;
    }

    static Node insert(Node head, int data) {
        Node newNode = new Node();
        newNode.data = data;
        
        if (head == null) {
            return newNode;
        }
        
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    static Node sortBiotonicList(Node head) {
        if (head == null || head.next == null) return head;

        Node increasing = head;
        while (increasing.next != null && increasing.data <= increasing.next.data) {
            increasing = increasing.next;
        }

        if (increasing.next == null) return head;

        Node decreasing = increasing.next;
        increasing.next = null;
        if (decreasing != null) decreasing.prev = null;

        decreasing = reverse(decreasing);

        return mergeLists(head, decreasing);
    }

    static Node reverse(Node head) {
        Node prev = null, current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }
        return prev;
    }

    static Node mergeLists(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node dummy = new Node();
        Node tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1.prev = tail;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2.prev = tail;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        if (head1 != null) {
            tail.next = head1;
            head1.prev = tail;
        }
        if (head2 != null) {
            tail.next = head2;
            head2.prev = tail;
        }

        return dummy.next;
    }

    static void display(Node head) {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            String[] values = sc.nextLine().split(" ");
            Node head = null;
            for (String val : values) {
                if (val.equals("-1")) break;
                head = insert(head, Integer.parseInt(val));
            }
            head = sortBiotonicList(head);
            display(head);
        }
    }
}
