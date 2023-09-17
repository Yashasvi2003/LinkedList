import java.util.Scanner;
class Node2 {
    int data;
    Node next;

    public Node2(int data) {
        this.data = data;
        this.next = null;
    }
}

public class KthElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = createList(sc);
        int k = sc.nextInt();

        int kth = KthFromLast(head, k);
        System.out.println(kth);

        sc.close();
    }

    public static Node createList(Scanner sc) {
        Node head = null;
        Node tail = null;

        while (true) {
            int data = sc.nextInt();
            if (data == -1) {
                break;
            }

            Node nNode = new Node(data);

            if (head == null) {
                head = nNode;
                tail = nNode;
            } else {
                tail.next = nNode;
                tail = nNode;
            }
        }

        return head;
    }

    public static int KthFromLast(Node head, int k) {
        if (head == null || k <= 0) {
            return -1;
        }

        Node first = head;
        Node second = head;


        for (int i = 0; i < k; i++) {
            if (second == null) {
                return -1;
            }
            second = second.next;
        }

        while (second != null) {
            first = first.next;
            second = second.next;
        }

        return first.data;
    }
}
