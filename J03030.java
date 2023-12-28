import java.io.FileNotFoundException;
import java.util.Scanner;

public class J03030 {
    public static void main (String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        s = " " + s;
        int a[] = new int[n + 1];
        int b[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i) == 'A') {
                a[i] = a[i - 1];
                b[i] = Math.min(b[i - 1] + 1, a[i - 1] + 1);
            } else {
                a[i] = Math.min(a[i - 1] + 1, b[i - 1] + 1);
                b[i] = b[i - 1];
            }
        }
        System.out.print(Math.min(a[n], b[n] + 1));
        sc.close();
    }
}
