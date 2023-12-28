import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class J02035 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        
        int t = Integer.parseInt(scanner.nextLine()), num = 0;
        while (t-- > 0) {
            int n = scanner.nextInt();
            long a[] = new long[n], maxVal = 0;
            for (int i = 0; i < n; ++i) {
                a[i] = scanner.nextLong();
                maxVal = Math.max(maxVal, a[i]);
            }
            long ans = 0;
            for (int i = 0; i < n; ++i) {
                if (a[i] == maxVal && i < n - 1) {
                    ans = i + 1;
                    break;
                }
            }
            System.out.println(ans);
        }
        scanner.close();
    }
}
