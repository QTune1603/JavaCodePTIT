import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class J03018 {
    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            BigInteger n = new BigInteger(scanner.nextLine());
            int ans = 1;
            if (n.mod(new BigInteger("2")).equals(new BigInteger("0"))) ++ans;
            else ans += 4;
            if (n.mod(new BigInteger("4")).equals(new BigInteger("1"))) ans += 5;
            if (n.mod(new BigInteger("4")).equals(new BigInteger("2"))) ans += 8;
            if (n.mod(new BigInteger("4")).equals(new BigInteger("3"))) ans += 5;
            if (n.mod(new BigInteger("4")).equals(new BigInteger("0"))) ans += 2;
            System.out.println(ans % 5);
        }
        scanner.close();
    }
}
