import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J08024 {
    static ArrayList<String> a = new ArrayList<>();
    public static void f(String cur) {
        a.add(cur);
        if (cur.length() == 10) return;
        f(cur + "0");
        f(cur + "9");
    }
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            long n = scanner.nextLong();
            f("9");
            Collections.sort(a, (x, y) -> (x.length() < y.length()) ? -1 : (x.length() > y.length()) ? 1 : x.compareTo(y));
            for (String i : a) {
                Long x = Long.parseLong(i);
                if (x % n == 0) {
                    System.out.println(x); 
                    break;
                }
            }
        }
        scanner.close();
    }
}
