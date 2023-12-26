import java.util.Scanner;

public class J01022 {
    public static long d[] = new long[100];
    public static void sieve(){
        d[1] = 1L; d[2] = 1L;
        for(int i = 3 ; i < 100 ; i++){
            d[i] = d[i-2] + d[i-1];
        }
    }
    public static char xau(int n, long k) {
        if(n == 1){
            return '0';
        }
        if(n == 2){
            return '1';
        }
        if(k <= d[n-2]){
            return xau(n-2,k);
        }
        return xau(n-1,k-d[n-2]);
    }
    
    public static void main(String[] args) {
        sieve();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long k = sc.nextLong();
            System.out.println(xau(n,k));
        }
        sc.close();
    }
}
