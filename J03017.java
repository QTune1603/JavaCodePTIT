import java.util.Scanner;
import java.util.Stack;

public class J03017 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            String a = scanner.nextLine();
            a = "0" + a;
            int ans = 0;
            Stack<Integer> st = new Stack();
            for (int i = 0; i < a.length(); ++i) {
                if (st.size() < 2) {
                    st.add(i);
                    continue;
                }
                int x = st.pop();
                int y = st.pop();
                if (a.charAt(y) != '1' || a.charAt(x) != '0' || a.charAt(i) != '0') {
                    st.add(y);
                    st.add(x);
                    st.add(i);
                    continue;
                }
                ans = Math.max(ans, i - st.peek());
            }
            System.out.println(ans);
        }
        scanner.close();
    }
}
