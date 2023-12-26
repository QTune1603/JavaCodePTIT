import java.math.BigInteger;
import java.util.Scanner;

public class J03016 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            BigInteger s = sc.nextBigInteger();
            System.out.println(s.mod(new BigInteger("11")).toString().equals("0") ? "1" : "0");
        }
        sc.close();
    }
}
