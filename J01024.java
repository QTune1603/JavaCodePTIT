import java.util.Scanner;

public class J01024 {
     public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long s = sc.nextLong();
            int flag = 0;
            long k = s;
            while(k != 0){
                if(k%10 != 0 && k%10 != 1 && k%10 != 2){
                    System.out.println("NO");
                    flag++;
                    break;
                }
                k /= 10;
            }
            if(flag == 0)System.out.println("YES");
        }
        sc.close();
    }
}
