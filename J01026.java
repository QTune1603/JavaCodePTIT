import java.util.Scanner;

public class J01026 {
    public static boolean checkScp(long x) {
        long a = (int)Math.sqrt(x);
        if(1L*a*a == x) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long n = sc.nextLong();
            if(checkScp(n)) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }
}
