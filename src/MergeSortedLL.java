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
    static Node mergedHead;

    public static Node insert(Node head, int data) {
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
        return head;  
    }

    static void merge() {
        Node temp1 = head1;
        Node temp2 = head2;
        Node mergedTail = null;
        mergedHead = null;

        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                if (mergedHead == null) {
                    mergedHead = temp1;
                    mergedTail = mergedHead;
                } else {
                    mergedTail.next = temp1;
                    mergedTail = mergedTail.next;
                }
                temp1 = temp1.next;
            } else {
                if (mergedHead == null) {
                    mergedHead = temp2;
                    mergedTail = mergedHead;
                } else {
                    mergedTail.next = temp2;
                    mergedTail = mergedTail.next;
                }
                temp2 = temp2.next;
            }
        }

        if (temp1 != null) {
            mergedTail.next = temp1;
        } else if (temp2 != null) {
            mergedTail.next = temp2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        for (int i = 0; i < n1; i++) {
            int data = sc.nextInt();
            head1 = insert(head1, data);  
        }

        int n2 = sc.nextInt();
        for (int i = 0; i < n2; i++) {
            int data = sc.nextInt();
            head2 = insert(head2, data); 
        }

        merge();

        while(mergedHead != null) {
            System.out.print(mergedHead.data + "->");
            mergedHead = mergedHead.next;
        } System.out.print("NULL");
    }
}