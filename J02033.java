import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

public class J02033 {
    public static void main(String args[]) throws IOException, FileNotFoundException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), k = scanner.nextInt();
        long a[] = new long[n];
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            a[i] = scanner.nextLong();
        }
        Arrays.sort(a);
        for (int i = 0; i < n; ++i) {
            if (a[i] >= 0) {
                break;
            }
            --k;
            a[i] = -a[i];
            if (k == 0) break;
        }       
        Arrays.sort(a);
        if (k % 2 == 1) a[0] = -a[0];
        for (int i = 0; i < n; ++i) ans += a[i];
        System.out.println(ans);  
        
        scanner.close();
    }
}
