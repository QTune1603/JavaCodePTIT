import java.util.Scanner;

public class J01004 {
    public static boolean checkSnt(long n) {
        if(n < 2) return false;
        for(int i = 2 ; i <= Math.sqrt(n) ; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        while(i < t){
            long n = sc.nextLong();
            if(checkSnt(n)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
            i++;
        }
        sc.close();
    }
}
