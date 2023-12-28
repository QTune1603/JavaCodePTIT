import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Stack;

class A {
    long a, b;
    A(long a, long b) {
        this.a = a;
        this.b = b;
    }
}

public class J08028 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long a[] = new long[m];
        long ans = 0;
        for (int i = 0; i < m; ++i) {
            a[i] = scanner.nextLong();
            ans = Math.max(ans, a[i]);
        }
        Stack<A> st = new Stack<>();
        for (int i = 0; i < m; ++i) {
            long t = 1, cur = 0;
            while (!st.isEmpty() && st.peek().a > a[i]) {
                t += st.peek().b;
                cur += st.peek().b;
                ans = Math.max(ans, st.peek().a * cur);
                st.pop();
            }
            st.push(new A(a[i], t));
        }
        long cur = 0;
        while (!st.isEmpty()) {
            cur += st.peek().b;
            ans = Math.max(ans, st.peek().a * cur);
            st.pop();
        }

        for (int i = 0; i < m; ++i) a[i] = n - a[i];
        st = new Stack<>();
        for (int i = 0; i < m; ++i) {
            long t = 1;
            cur = 0;
            while (!st.isEmpty() && st.peek().a > a[i]) {
                t += st.peek().b;
                cur += st.peek().b;
                ans = Math.max(ans, st.peek().a * cur);
                st.pop();
            }
            st.push(new A(a[i], t));
        }
        cur = 0;
        while (!st.isEmpty()) {
            cur += st.peek().b;
            ans = Math.max(ans, st.peek().a * cur);
            st.pop();
        }
        System.out.println(ans);
        scanner.close();
    }
}
