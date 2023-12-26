import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Scanner;

public class J03011 {
    public static void main(String args[]) throws IOException, FileNotFoundException, ClassNotFoundException, ParseException {
        Scanner sc = new Scanner(System.in);  
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            System.out.println(a.gcd(b));
        }
        sc.close();
    }
}
