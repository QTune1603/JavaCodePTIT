import java.util.Arrays;
import java.util.Scanner;

public class J02016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long a[] = new long[n];
            for(int i = 0 ; i < n ; i++){
                a[i] = sc.nextLong();
            }
            Arrays.sort(a);
            boolean check = false;
            for(int i = n-1 ; i >= 2 ; i--){
                long c = a[i]*a[i];
                int l = 0, r = i-1;
                
                while(l < r){
                    long x = a[l]*a[l];
                    long y = a[r]*a[r];
                    
                    if(x + y == c){
                        check = true;
                        break;
                    }
                    else if(x + y < c){
                        l++;
                    }
                    else {
                        r--;
                    }
                }
                if(check){
                    break;
                }
            }
            
            if(check){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
