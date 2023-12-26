import java.util.Scanner;

public class J02013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n-1 ; i++){
            boolean ok = true;
            for(int j = 0 ; j < n-1 ; j++){
                if(a[j] > a[j+1]){
                    ok = false;
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
            if(ok){
                return;
            }
            System.out.printf("Buoc %d: ",i+1);
            for(int k = 0 ; k < n ; k++){
                System.out.print(a[k] + " ");
            }
            System.out.println("");
        }
        sc.close();
    }
}
