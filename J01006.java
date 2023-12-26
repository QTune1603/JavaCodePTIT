import java.util.Scanner;

public class J01006 {
    public static boolean checkSnt(long n) {
        if(n < 2) return false;
        for(int i = 2 ; i <= Math.sqrt(n) ; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long f2 = 0, f1 = 1;
            long fn = 0;
            for(int i = 1 ; i <= n ; i++){
                fn = f1 + f2;
                f1 = f2;
                f2 = fn;
            }
            System.out.println(fn);
            
        }
        sc.close();
    }
}
