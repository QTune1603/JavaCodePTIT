import java.util.Scanner;

public class J01005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), h = sc.nextInt();
            for (double i = 1; i < n; i++) {
                System.out.printf("%.6f ", Math.sqrt(i / n) * h);
            }
            System.out.println("");
        }
        sc.close();
    }
}
