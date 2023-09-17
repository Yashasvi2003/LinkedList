import java.util.*;
public class MergeSortedLists {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int tcase= sc.nextInt();
        while(tcase-- > 0) {
            int n1 = sc.nextInt();
            List<Integer> l1 = new LinkedList<>();
            for(int i=0; i<n1; i++)
                l1.add(sc.nextInt());

            int n2 = sc.nextInt();
            List<Integer> l2 = new LinkedList<>();
            for(int i=0; i<n2; i++)
                l2.add(sc.nextInt());

            Merge(l1, l2);
        }
    }

    private static void Merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new LinkedList<>();
        while(!l1.isEmpty() && !l2.isEmpty()) {
            if(l1.get(0) < l2.get(0)) {
                res.add(l1.get(0));
                l1.remove(0);
            }
            else {
                res.add(l2.get(0));
                l2.remove(0);
            }
        }
        while(!l1.isEmpty()) {
            res.add(l1.get(0));
            l1.remove(0);
        }

        while(!l2.isEmpty()) {
            res.add(l2.get(0));
            l2.remove(0);
        }

        Iterator<Integer> t = res.iterator();
        while(t.hasNext()) {
            System.out.print(t.next() + " ");
        }
        System.out.println();
    }
}

