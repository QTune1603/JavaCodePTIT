import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

public class J02027 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);  

        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a);
            long ans = 0;
            for (int i = 0; i < n; ++i) {
                int need = a[i] + k;
                int l = i + 1, r = n - 1, pos = -1;
                while (l <= r) {
                    int m = (l + r) / 2;
                    if (a[m] >= need) r = m - 1;
                    else {
                        pos = m;
                        l = m + 1;
                    }
                }
                // System.out.println(l);
                if (pos != -1) ans += pos - i; 
            }
            System.out.println(ans);
        }
        scanner.close();
    }
}
