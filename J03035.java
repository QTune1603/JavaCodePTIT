import java.util.Scanner;

public class J03035 {
    static String a, b;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            a = scanner.nextLine();
            b = scanner.nextLine();
            ans = 0;
            f(0, a);
            System.out.println(ans);
        }
        scanner.close();
    }   
    private static void f(int cur, String s) {
        if (cur == s.length()) {
            long x = Long.parseLong(s);
            long y = Long.parseLong(b);
            if (x > y) ++ans;
            return;
        }
        if (s.charAt(cur) != '?') {
            f(cur + 1, s);
            return;
        }
        for (int i = 0; i < 10; ++i) {
            f(cur + 1, s.substring(0, cur) + i + s.substring(cur + 1));
        }
    }
}
