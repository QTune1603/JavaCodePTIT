import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class A {
    int a, b;
    A(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int first() {
        return a;
    }
    public int second() {
        return b;
    }
}
public class J08022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            int n = scanner.nextInt();
            int a[] = new int[n];
            int ans[] = new int[n];
            Arrays.fill(ans, -1);
            for (int i = 0; i < n; ++i) a[i] = scanner.nextInt();
            Stack<Integer> st = new Stack();
            for (int i = 0; i < n; ++i) {
                if (st.empty() || a[st.peek()] >= a[i]) {
                    st.add(i);
                    continue;
                }
                while (!st.empty() && a[st.peek()] < a[i]) {
                    ans[st.pop()] = a[i];
                }
                st.add(i);
            }
            for (int i = 0; i < n; ++i) System.out.print(ans[i] + " ");
            System.out.println();
        }
        scanner.close();
    }
}
