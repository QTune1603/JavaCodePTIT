import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Stack;
public class J08027 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        Stack<Character> st1 = new Stack<>(), st2 = new Stack<>();
        for (char i : a.toCharArray()) {
            if (i == '>') {
                if (!st2.empty()) {
                    st1.push(st2.peek());
                    st2.pop();
                }
            }
            else if (i == '<') {
                if (!st1.empty()) {
                    st2.push(st1.peek());
                    st1.pop();
                }
            }
            else if (i == '-') {
                if (!st1.empty()) st1.pop();
            }
            else st1.push(i);
        }
        for (char i : st1) System.out.print(i);
        while (!st2.empty()) {
            System.out.print(st2.peek());
            st2.pop();
        }
        scanner.close();
    }
}
