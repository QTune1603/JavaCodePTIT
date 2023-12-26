import java.util.Scanner;

public class J02106 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            if(a+b+c > 1) cnt++;
        }
        System.out.println(cnt);
        sc.close();
    }
}
