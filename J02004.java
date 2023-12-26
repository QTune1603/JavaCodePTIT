import java.util.Scanner;

public class J02004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i = 0 ; i < n ; i++) {
                a[i] = sc.nextInt();
            }
            int l = 0, r = n-1;
            int flag = 0;
            while(l <= r){
                if(a[l] != a[r]){
                    flag = 1;
                    break;
                }
                l++;
                r--;
            }
            if(flag == 1) System.out.println("NO");
            else System.out.println("YES");
        }
        sc.close();
    }
}
