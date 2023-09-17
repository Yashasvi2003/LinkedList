import java.util.Scanner;
class Node1 {
    int data;
    Node next;

    public Node1(int data) {
        this.data = data;
        this.next = null;
    }
}

public class EvenAfterOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = createList(sc, n);
        Node reHead = rearrangeOddEven(head);
        printList(reHead);
        sc.close();
    }

    public static Node createList(Scanner sc, int n) {
        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
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

    public static Node rearrangeOddEven(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node oddHead = null;
        Node evenHead = null;
        Node oddTail = null;
        Node evenTail = null;

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
        if (oddTail != null) {
            oddTail.next = evenHead;
        }

        if (evenTail != null) {
            evenTail.next = null;
        }


        return (oddHead != null) ? oddHead : evenHead;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}