import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J02026 {
    static int n, k;
    static ArrayList<Integer> a;
    public static void f(int pos, int len, String cur) {
        if (len == k) {
            System.out.println(cur.substring(1));
            return;
        }
        for (int i = pos; i < n; ++i) f(i + 1, len + 1, cur + " " + a.get(i).toString());
    }
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
           
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            a = new ArrayList<>();
            for (int i = 0; i < n; ++i) a.add(scanner.nextInt());
            Collections.sort(a);   
            f(0, 0, "");         
        }
        scanner.close();
    }
}
