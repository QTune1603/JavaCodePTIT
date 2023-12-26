import java.math.BigInteger;
import java.util.Scanner;

public class J03033 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        String s1,s2;
        while(t-- > 0){
            s1 = sc.nextLine();
            s2 = sc.nextLine();
            BigInteger x,y;
            x = new BigInteger(s1,10);
            y = new BigInteger(s2,10);
            BigInteger bcnn = x.gcd(y);
            x = x.multiply(y);
            bcnn = x.divide(bcnn);
            System.out.println(bcnn);
        }
        sc.close();
    }
}
