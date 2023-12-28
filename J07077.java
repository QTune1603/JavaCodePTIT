import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Stack;

public class J07077 {
    public static void main(String args[]) throws IOException, FileNotFoundException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(new File("BIEUTHUC.in"));
        
        int t = Integer.parseInt(scanner.nextLine());   
        while(t-- > 0) {
            String a = scanner.nextLine(), ans = "";
            Stack<Character> operator = new Stack<>();
            for (int i = 0; i < a.length(); ++i) {
                if (a.charAt(i) >= '0' && a.charAt(i) <= '9') {
                    String x = "";
                    int j = i;
                    while (j < a.length() && a.charAt(j) >= '0' && a.charAt(j) <= '9') {
                        x += a.charAt(j);
                        ++j;
                    }
                    i = j - 1;
                    ans += x + " ";
                }
                else if (a.charAt(i) == '(') operator.add(a.charAt(i));
                else if (a.charAt(i) == ')') {
                    while (!operator.isEmpty() && operator.peek() != '(') {
                        ans += operator.pop() + " ";
                    }
                    if (!operator.isEmpty()) operator.pop();
                }
                else {
                    if (operator.isEmpty()) operator.add(a.charAt(i));
                    else if (order(a.charAt(i)) > order(operator.peek())) {
                        operator.add(a.charAt(i));
                    }
                    else {
                        ans += operator.pop() + " ";
                        if (operator.isEmpty() || order(a.charAt(i)) > order(operator.peek())) operator.add(a.charAt(i));
                        else {
                            ans += operator.pop() + " ";
                            operator.add(a.charAt(i));
                        }
                    }
                }
            }
            while (!operator.isEmpty()) ans += operator.pop() + " ";
            // System.out.println(ans);
            Stack<Long> st = new Stack<>();
            String x[] = ans.trim().split("\\s+");
            for (String i : x) {
                if (i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/")) {
                    long z = st.pop();
                    long y = st.pop();
                    Long m = i.equals("+") ? y + z : i.equals("-") ? y - z : i.equals("*") ? y * z : y / z;
                    st.add(m);
                }
                else st.add(Long.parseLong(i));
            }
            System.out.println(st.peek());
        }
    }
    public static int order(char x) {
        if (x == '(') return -1;
        if (x == '+' || x == '-') return 0;
        return 1;
    }
}
