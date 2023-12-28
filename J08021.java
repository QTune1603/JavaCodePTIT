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

public class J08021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            int ans = 0;
            String a = scanner.nextLine();
            a = ")" + a;
            Stack<Integer> st = new Stack();
            st.add(0);
            for (int i = 0; i < a.length(); ++i) {
                if (!match(a.charAt(st.peek()), a.charAt(i))) {
                    st.add(i);
                    continue;
                }
                st.pop();
                ans = Math.max(ans, i - st.peek() + 1);
            }
            System.out.println(ans - 1);
        }
        scanner.close();
    }

    private static boolean match(Character x, Character y) {
        return x == '(' && y == ')';
    }
}
