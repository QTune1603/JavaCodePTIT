import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;


class IntSet {
    SortedSet<Integer> a = new TreeSet<>();
    IntSet(int a[]) {
        for (int i : a) this.a.add(i);
    }
    public IntSet union(IntSet b) {
        for (int i : b.a) this.a.add(i);
        return this;
    }
    @Override
    public String toString() {
        String ans = "";
        for (int i : a) {
            Integer x = i;
            ans += x.toString() + " ";
        }
        return ans;
    }
}

public class J04021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
        sc.close();
    }
    public static void main3084590(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
        sc.close();
    }
}
