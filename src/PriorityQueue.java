import java.util.*;

public class PriorityQueue {
    static class Node {
        int data;
        int priority;
        Node next;
    }

    static Node insert(Node head, int data, int priority) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.priority = priority;

        if (head == null || head.priority > priority) {
            newNode.next = head;
            return newNode;
        }

        Node temp = head;
        while (temp.next != null && temp.next.priority <= priority) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    static Node delete(Node head) {
        if (head == null) {
            System.out.println("Error List Empty");
            return null;
        }
        return head.next;
    }

    static void display(Node head) {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        System.out.print("Queue: ");
        while (head != null) {
            System.out.print(head.data + " " + head.priority + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;

        while (true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int data = sc.nextInt();
                    int priority = sc.nextInt();
                    head = insert(head, data, priority);
                    break;
                case 2:
                    head = delete(head);
                    break;
                case 3:
                    display(head);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong Choice");
            }
        }
    }
}