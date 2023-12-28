import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
    

public class J05008 {
    public static void main(String args[]) throws IOException { 
        Scanner scanner = new Scanner(System.in);
        

        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            ArrayList<Integer> x = new ArrayList<>(), y = new ArrayList<>();
            int n = scanner.nextInt();
            for (int i = 0; i < n; ++i) {
                x.add(scanner.nextInt());
                y.add(scanner.nextInt());
            }
            double ans = 0;
            for (int i = 0; i < n - 1; ++i) {
                ans += x.get(i) * y.get(i + 1) - x.get(i + 1) * y.get(i);
            }
            ans += x.get(n - 1) * y.get(0) - x.get(0) * y.get(n - 1);
            ans *= 0.5;
            System.out.printf("%.3f\n", ans);
        }
        scanner.close();
    }
}
