import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class IntSet {
    private int[] a;
//    private int n;

    public IntSet (int[] a) {
        this.a = standardLize(a);
    }

    public int[] standardLize(int[] a) {
        int[] res = new int[a.length];
        Set<Integer> st = new TreeSet<>();
        for (int x : a) {
            st.add(x);
        }
        int i = 0;
        for (int x : st) {
            res[i++] = x;
        }
        return res;
    }
    public IntSet union (IntSet other) {
        int[] u = new int[this.a.length + other.a.length];
        int i = 0;

        for (int x : this.a) {
            u[i++] = x;
        }

        for (int x : other.a) {
            u[i++] = x;
        }

        IntSet res = new IntSet(u);
        return res;
    }

    public IntSet intersection (IntSet other) {
        int[] inter = new int[this.a.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int x: this.a) {
            map.put(x, 1);
        }
        int ind = 0;
        for (int y: other.a) {
            if (map.containsKey(y)) {
                inter[ind++] = y;
            }
        }
        IntSet res = new IntSet(inter);
        return res;
    }

    @Override
    public String toString() {
        String res = "";
        for(int i = 0; i < a.length; i++) {
            if (a[i] == 0 && i != 0)
                break;
            if (a[i] != 0)
                res += (a[i] + " ");
        }
        return res.trim();
    }

}

public class J07009 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
    public static void main4687254(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
    public static void main5525440(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
    public static void main2919048(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
}
