import java.util.Scanner;

public class J02101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            for(int i = 0 ; i < n ; i++) {
                for(int j = 0 ; j < n ; j++){
                    a[i][j] = sc.nextInt();
                }
            }
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(i % 2 == 0){
                        System.out.print(a[i][j] + " ");
                    }
                    else {
                        System.out.print(a[i][n-j-1] + " ");
                    }
                }
            }
            System.out.println("");
        }
        sc.close();
    }
}
