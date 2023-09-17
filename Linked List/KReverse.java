import java.util.*;
class Node {
    int data;
    Node next;
    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
public class KReverse {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Node head = null;
        Node tail = null;
        for (int j = 0; j < N; j++)
        {
            int data = sc.nextInt();
            Node newNode = new Node(data);
            if (head == null)
            {
                head = newNode;
                tail = newNode;
            } else
            {
                tail.next = newNode;
                tail = newNode;
            }
        }
        head = reverseInGroups(head, K);
        printLinkedList(head);
        sc.close();
    }
    private static Node reverseInGroups(Node head, int k)
    {
        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            head.next = reverseInGroups(next, k);
        }
        return prev;
    }
    private static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;}}}
