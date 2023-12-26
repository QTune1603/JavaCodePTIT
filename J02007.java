import java.util.Scanner;

public class J02007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = 1;
        while(t-- > 0){
            int n = sc.nextInt();
            int a[] = new int[n];
            int cnt[] = new int[100005];
            for(int i = 0 ; i < n ; i++){
                a[i] = sc.nextInt();
                cnt[a[i]]++;
            }
            System.out.println("Test " + k + ":");
            k++;
            for(int i = 0 ; i < n ; i++){
                if(cnt[a[i]] != 0){
                    System.out.println(a[i] + " xuat hien " + cnt[a[i]] + " lan");
                    cnt[a[i]] = 0;
                }
            }
            System.out.println("");
        }
        sc.close();
    }
}
