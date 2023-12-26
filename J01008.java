import java.util.Scanner;

public class J01008 {
    public static boolean checkSnt(long n) {
        if(n < 2) return false;
        for(int i = 2 ; i <= Math.sqrt(n) ; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static long[] fibo = new long[100];
    
    public static void sinh() {
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i = 2 ; i < 100 ; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
    }
    
    public static boolean check(long n) {
        for(long i : fibo){
            if(i == n){
                return true;
            }
            else if(i > n) {
                return false;
            }
        }
        return false;
    }
    
    public static void ptSnt(long n) {
        for(int i = 2 ; i <= Math.sqrt(n) ; i++){
            int cnt = 0;
            if(n%i == 0){
                while(n%i == 0){
                    cnt++;
                    n /= i;
                }
                System.out.print(i + "(" + cnt + ")" + " ");
            }
        }
        if(n != 1) System.out.print(n + "(1)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 1;
        while(t-- > 0){
            long n = sc.nextLong();
            System.out.print("Test " + i + ": ");
            ptSnt(n);
            System.out.println("");
            i++;
        }
        sc.close();
    }
}
