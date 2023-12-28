import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class J020356 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        Long s = scanner.nextLong();
        if ((s == 0 && n > 1) || 9 * n < s) {
            System.out.print("-1 -1");
            return;
        }
        if (s == 0 && n == 1) {
            System.out.print("0 0");
            return;
        }
        String ans = "";
        while (n > 0) {
            Long t = s;
            if (s >= 9) ans += "9";
            else ans += t.toString();
            --n;
            s -= Math.min(9, s);
        }
        Character temp[] = new Character[ans.length()];
        for (int i = 0; i < ans.length(); ++i) temp[i] = ans.charAt(i);
        if (temp[ans.length() - 1] == '0') {
            temp[ans.length() - 1] = '1';
            for (int i = ans.length() - 2; i >= 0; --i) 
                if (temp[i] != '0') {
                    --temp[i];
                    break;
                }
        }
        for (int i = temp.length - 1; i >= 0; --i) 
            System.out.print(temp[i]);
        System.out.print(" "); 
        System.out.print(" " + ans);
        scanner.close();
    }
}
