import java.util.Scanner;

public class J02006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[m];
        int check[] = new int[1005];
        for(int i = 0 ; i < n ; i++){
            a[i] = sc.nextInt();
            check[a[i]] = 1;
        }
        for(int i = 0 ; i < m ; i++){
            b[i] = sc.nextInt();
            check[b[i]] = 1;
        }
        for(int i = 0 ; i <= 1000 ; i++){
            if(check[i] == 1){
                System.out.print(i + " ");
            }
        }
        sc.close();
    }
}
