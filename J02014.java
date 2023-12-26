import java.util.Scanner;

public class J02014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int a[] = new int[n+1];
            int sum = 0;
            int prefix[] = new int[n+1];
            for(int i = 0 ; i < n ; i++){
                a[i] = sc.nextInt();
                sum += a[i];
                if(i == 0){
                    prefix[i] = a[i];
                }
                else {
                    prefix[i] = prefix[i-1] + a[i];
                }
            }
            int cnt = 0;
            for(int i = 1 ; i < n ; i++){
                if(prefix[i-1] == sum - prefix[i]){
                    System.out.println(i+1);
                    cnt++; break;
                }
            }
            if(cnt == 0)System.out.println("-1");
        }
        sc.close();
    }
}
