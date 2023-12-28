import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class A {
    long x, y, c;
    A(long a, long b, long c) {
        this.x = a;
        this.y = b;
        this.c = c;
    }
}

public class J01020 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            BigInteger a = new BigInteger(scanner.nextLine());
            if (a.equals(new BigInteger("0"))) {
                System.out.println("Impossible");
                continue;
            }
            Long cur = 0L;
            String ans = "";
            Set<Character> s = new TreeSet<>();
            do {
                BigInteger b = a.multiply(new BigInteger((++cur).toString()));
                for (char i : b.toString().toCharArray()) s.add(i);
                ans = b.toString();
            }
            while (s.size() < 10);
            System.out.println(ans);
        }
        scanner.close();
    }
}
