import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class J03028 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
          

        int t = Integer.parseInt(scanner.nextLine()), num = 0;
        while (t-- > 0) {
            String a = scanner.nextLine();
            String b1 = a.substring(0, a.length() / 2), b2 = a.substring(a.length() / 2);
            String ans = "", c1 = "", c2 = "";
            long n1 = 0, n2 = 0;
            for (char i : b1.toCharArray()) n1 += i - 'A';
            for (char i : b2.toCharArray()) n2 += i - 'A';
            for (char i : b1.toCharArray()) c1 += f(i, n1) + "";            
            for (char i : b2.toCharArray()) c2 += f(i, n2) + "";
            for (int i = 0; i < c1.length(); ++i)
                ans += f(c1.charAt(i), c2.charAt(i) - 'A') + "";
            System.out.println(ans);
        }
        scanner.close();
    }  
    public static char f(char x, long y) {
        return (char)((x - 'A' + y) % 26 + 'A');
    }
}
