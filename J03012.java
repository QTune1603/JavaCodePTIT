import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Scanner;

public class J03012 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
            

        int t = Integer.parseInt(scanner.nextLine()), num = 0;
        while (t-- > 0) {
            BigInteger a = new BigInteger(scanner.next());
            BigInteger b = new BigInteger(scanner.next()); 
            System.out.println(a.add(b));          
        }
        scanner.close();
    }
}
