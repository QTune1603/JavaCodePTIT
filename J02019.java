import java.io.IOException;
import java.util.Scanner;

public class J02019 {
    public static void main(String args[]) throws IOException { 
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int ans = 0, s[] = new int[m + 5];
        for (int i = 2; i < m; ++i)
            for (int j = i * 2; j <= m; j += i) s[j] += i;
        for (int i = n; i <= m; ++i) {
            if (s[i] + 1 > i) ++ans;
        }
        System.out.println(ans);
        scanner.close();
    }
}
