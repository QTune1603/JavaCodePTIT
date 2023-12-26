import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class J03014 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        BigInteger c = a.add(b);
        System.out.println(c.toString());
        sc.close();
    }
}
