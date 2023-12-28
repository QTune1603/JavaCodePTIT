import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;

public class J08015 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
           
        int t = scanner.nextInt();
        while (t-- > 0) {
            HashMap<Long, Long> mp = new HashMap<>();
            int n = scanner.nextInt();
            long k = scanner.nextLong();
            long a[] = new long[n];
            for (int i = 0; i < n; ++i) {
                a[i] = scanner.nextLong();
                if (mp.get(a[i]) == null) mp.put(a[i], 1L);
                else mp.put(a[i], mp.get(a[i]) + 1);
            } 
            long ans = 0;
            HashMap<Long, Boolean> used = new HashMap<>();
            for (long i : a) {
                if (used.get(i) != null) continue;
                used.put(i, true);
                used.put(k - i, true);
                if (i == k - i) ans += mp.get(i) * (mp.get(i) - 1) / 2;
                else ans += mp.get(i) * ((mp.get(k - i) == null) ? 0 : mp.get(k - i));
            }
            System.out.println(ans);
        }
        scanner.close();
    }   
}
