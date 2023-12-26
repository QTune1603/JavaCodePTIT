import java.util.Scanner;

public class J01002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        while(i < t){
            long n = sc.nextLong();
            System.out.println((n+1)*n/2);
            i++;
        }
        sc.close();
    }
}
