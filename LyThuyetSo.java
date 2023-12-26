import java.util.Scanner;

public class LyThuyetSo {
    public static boolean checkSnt(long x) {
        for(int i = 2 ; i <= Math.sqrt(x) ; i++){
            if(x % i == 0){
                return false;
            }
        }
        return x > 1;
    }
    
    public static boolean checkScp(long x) {
        long a = (int)Math.sqrt(x);
        if(1L*a*a == x) return true;
        return false;
    }
    public static int soLocPhat(long x) {
        while(x != 0){
            int r = (int)x%10;
            if(r != 0 && r != 6 && r != 8){
                return 0;
            }
            x /= 10;
        }
        return 1;
    }  
    public static long giaiThua (long n) {
        long sum = 1;
        for(int i = 1 ; i <= n ; i++){
            sum *= i;
        }
        return sum;
    }
   
    public static boolean phanTichSnt(long n) {
        int cnt = 0;
        for(long i = 2 ; i <= Math.sqrt(n) ; i++){
            if(n % i == 0){
                ++cnt;
                while(n%i==0){
                    n /= i;
                }
            }
        }
        if(n != 1) cnt++;
        return cnt >= 3;
    }
    public static int tong(long x) {
        int sum = 0;
        while(x != 0){
            sum += x%10;
            x /= 10;
        }
        return sum;
    }
    public static boolean smith(long n) {
        int tong1 = tong(n);
        int tong2 = 0;
        long tmp = n;
        for(int i = 2 ; i <= Math.sqrt(n) ; i++){
            if(n % i == 0){
                while(n % i == 0){
                    tong2 += tong(i);
                    n /= i;
                }
            }
        }
        if(tmp == n) return false;
        if(n > 1){
            tong2 += tong(n);
        }
        return tong1 == tong2;
    }
    public static long uocMax(long n) {
        long res = 0;
        for(int i = 2 ; i <= Math.sqrt(n) ; i++){
            while(n % i == 0){
                res = i;
                n /= i;
            }
        }
        if(n != 1) res = n;
        return res;
    }
    public static int soDep(long n) {
        int ok = 0;
        for(int i = 2 ; i <= Math.sqrt(n); i++){
            int cnt = 0;
            while(n%i==0){
                cnt++;
                n /= i;
            }
            if(cnt == 1) return 0;
            if(cnt >= 2) ok = 1;
        }
        if(n != 1) return 0;
        return ok;
    }
    
    public static void phanTichSnt2(long n) {
        for(long i = 2 ; i <= Math.sqrt(n) ; i++){
            if(n % i == 0){
                int cnt = 0;
                while(n % i == 0){
                    ++cnt;
                    n /= i;
                }
                System.out.print(i + "^" + cnt);
                if(n != 1) System.out.print(" * ");
            }
        }
        if(n != 1){
            System.out.print(n + "^1" );
        }
    }
    public static boolean checkLast(long n) {
        long r = n%10;
        n /= 10;
        while(n != 0){
            long l = n%10;
            if(l > r) return false;
            n /= 10;
        }
        return true;
    }
    
    public static int soHH(long n) {
        long sum = 1;
        for(int i = 2 ; i <= Math.sqrt(n) ; i++){
            if(n % i == 0){
                if(i != n/i){
                    sum += i + n/i;
                }
                else sum += i;
            }
        }  
        if(sum == n) return 1;
        else return 0;
        
    }
    public static boolean checkSoTn(int n) {
        int tmp = n;
        int sum = 0;
        while(n != 0){
            sum = sum*10 + n%10;
            n /= 10;
        }
        return sum == tmp;
    }
    public static boolean soLp(int n) {
        int x = tong(n);
        if(x % 10 != 8) return false;
        int cnt = 0;
        while(n != 0){
            int r = n%10;
            if(r == 6) cnt++;
            n /= 10;
        }
        if(cnt == 0) return false;
        return true;
    }
    public static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b,a%b);
    }
    
    public static long lcm(long a, long b) {
        return a/gcd(a,b)*b;
    }
    public static int count(long n, int p) {
        int cnt = 0;
        for(int i = p ; i <= n ; i++){
            int tmp = i;
            while(tmp % p == 0) {
                cnt++;
                tmp /= p;
            }
        }
        return cnt;
    }
    
    public static int count2(int n, int p) {
        int cnt = 0;
        for(int i = p ; i <= n ; i*= p){
            cnt += n/i;
        }
        return cnt;
    }
    
    public static long count3(long n) {
        long cnt = 0;
        for(long i = 5 ; i <= n ; i*=5){
            cnt += n/i;
        }
        return cnt;
    }
    public static long fiBo(long n) {
        long f2 = 0, f1 = 1;
        long fn = 0;
        for(int i = 2 ; i <= n ; i++){
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }
    
    public static long powMod(long a, long b) {
        long res = 1;
        while(b != 0){
            if(b % 2 == 1){
                res *= a;
                res %= (int)(1e9+7);
            }
            a *= a;
            a %= (int)(1000000007);
            b /= 2;
        }
        return res;
    }
    
    public static long[] fibo = new long[100];
    
    public static void sinh() {
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i = 2 ; i < 100 ; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
    }
    
    public static long checkFibo(long n) {
        if(n == 0 || n == 1) return 1;
        long f2 = 0, f1 = 1;
        long fn = 0;
        for(int i = 2 ; i <= 92 ; i++){
            fn = f2 + f1;
            f2 = f1;
            f1 = fn;
            if(fn >= n) {
                return fn;
            }
        }
        return 0;
    }
    
    public static int[] prime =new int[1000001];
    public static void sang() {
        for(int i = 0 ; i <= 1000000 ; i++){
            prime[i] = 1;
        }
        prime[0] = prime[1] = 0;
        for(int i = 2 ; i <= 1000 ; i++){
            if(prime[i] == 1){
                for(int j = i*i ; j <= 1000000 ; j += i){
                    prime[j] = 0;
                }
            }
        }
    }
    
    public static void reverse(int a[], int n){
        int l = 0, r = n-1;
        while(l <= r){
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
            ++l; --r;
        }
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
