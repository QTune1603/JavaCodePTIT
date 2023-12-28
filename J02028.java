import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class J02028 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        // if (System.getProperty("ONLINE_JUDGE") == null) { 
        //     try { 
        //         System.setOut(new PrintStream( 
        //             new FileOutputStream("java_output.txt"))); 
        //         scanner = new Scanner(new File("java_input.txt")); 
        //     } 
        //     catch (Exception e) { 
        //     } 
        // }    

        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            int n = scanner.nextInt();
            long k = scanner.nextLong();
            long a[] = new long[n], pref[] = new long[n];
            for (int i = 0; i < n; ++i) {
                a[i] = scanner.nextLong();
                pref[i] = (i == 0) ? a[i] : pref[i - 1] + a[i];
            }
            boolean oge = false;
            for (int i = 0; i < n; ++i) {
                int l = 1, r = n - i;
                while (l <= r) {
                    int m = (l + r) / 2;
                    long val = (i == 0) ? pref[m - 1] : pref[m + i - 1] - pref[i - 1];
                    if (val == k) {
                        // System.out.println(i + " " + m);
                        oge = true;
                        break;
                    } 
                    if (val < k) l = m + 1;
                    else r = m - 1; 
                }
                if (oge) break;
            }
            if (oge) System.out.println("YES");
            else System.out.println("NO");
        }
        scanner.close();
    }
}
