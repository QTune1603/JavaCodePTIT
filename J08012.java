import java.util.Scanner;

class A {
    int a, b;
    A(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int first() {
        return a;
    }
    public int second() {
        return b;
    }
}
public class J08012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       
        int n = Integer.parseInt(scanner.nextLine());
        int a[] = new int[n + 1];
        for (int i = 0; i < n - 1; ++i) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            ++a[x];
            ++a[y];
        }
        boolean found_1 = false, found_2 = true;
        for (int i = 1; i <= n; ++i) {
            if (a[i] == n - 1) found_1 = true;
            else if (a[i] != 1) found_2 = false;
        } 
        if (found_1 && found_2) System.out.println("Yes");
        else System.out.println("No");
        scanner.close();
    }
}
