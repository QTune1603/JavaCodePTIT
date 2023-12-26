import java.util.Scanner;

public class J02012 {
     /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n ; i++){
            int id = i;
            while(id > 0 && a[id] < a[id-1]){
                int tmp = a[id];
                a[id] = a[id-1];
                a[id-1] = tmp;
                id--;
            }
            System.out.printf("Buoc %d: ", i);
            for(int p = 0 ; p <= i ; p++){
                System.out.print(a[p] + " ");
            }
            System.out.println("");
        }
        sc.close();
    }
}
