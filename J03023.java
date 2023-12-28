import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class J03023 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        
        int t = Integer.parseInt(scanner.nextLine()), num = 0;
        while (t-- > 0) {
            String a = scanner.nextLine();
            long ans = 0;
            for (int i = 0; i < a.length(); ++i) {
                if (i < a.length() - 1 && check(a.charAt(i), a.charAt(i + 1)) != 0) {
                    ans += check(a.charAt(i), a.charAt(i + 1));
                    ++i;
                }
                else {
                    if (a.charAt(i) == 'I') ++ans;
                    if (a.charAt(i) == 'V') ans += 5;                    
                    if (a.charAt(i) == 'X') ans += 10;
                    if (a.charAt(i) == 'L') ans += 50;
                    if (a.charAt(i) == 'C') ans += 100;
                    if (a.charAt(i) == 'D') ans += 500;
                    if (a.charAt(i) == 'M') ans += 1000;
                }
            }          
            System.out.println(ans);
            scanner.close();
        }
    }  
    public static long check(char x, char y) {
        if (x == 'I' && (y == 'V' || y == 'X')) 
            return (y == 'V') ? 4 : 9;
        if (x == 'X' && (y == 'L' || y == 'C'))
            return (y == 'L') ? 40 : 90;
        if (x == 'C' && (y == 'D' || y == 'M')) 
            return (y == 'D') ? 400 : 900;
        return 0;
    }
}
