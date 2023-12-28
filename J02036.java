import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class J02036 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        
        int t = Integer.parseInt(scanner.nextLine()), num = 0;
        while (t-- > 0) {
            int n = scanner.nextInt();
            Long a[] = new Long[n];
            for (int i = 0; i < n; ++i) {
                a[i] = scanner.nextLong();
            }
            ArrayList<Long> ans = new ArrayList<>();
            ans.add(a[0]);
            for (int i = 1; i < n; ++i) ans.add(a[i] * a[i - 1] / gcd(a[i], a[i - 1])); 
            ans.add(a[n - 1]);
            for (Long i : ans) System.out.print(i + " ");
            System.out.println();
        }
        scanner.close();
    }   
    public static Long gcd(Long a, Long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
}
