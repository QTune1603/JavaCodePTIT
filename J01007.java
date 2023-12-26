import java.util.Scanner;

public class J01007 {
    public static long a[] = new long[100];
    
    public static void sinh(){
        a[0] = a[1] = 0; a[2] = 1;
        for(int i = 3 ; i <= 93 ; i++){
            a[i] = a[i-1] + a[i-2];
        }
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       sinh();
       while(t-- > 0){
           long n = sc.nextLong();
           int cnt = 0;
           for(int i = 0 ; i <= 93 ; i++){
               if(a[i] == n){
                   System.out.println("YES");
                   cnt++;
                   break;
               }
           }
           if(cnt == 0) System.out.println("NO");
       }
       sc.close();
   }
}
