import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;

public class J03031 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
            

        int t = Integer.parseInt(scanner.nextLine()), num = 0;
        while (t-- > 0) {
            String a = scanner.nextLine();
            long k = Long.parseLong(scanner.nextLine());
            HashMap<Character, Boolean> mp = new HashMap<>();
            for (char i : a.toCharArray()) {
                if (!mp.containsKey(i)) mp.put(i, true);
            }
            if (26 - mp.size() <= k) System.out.println("YES");
            else System.out.println("NO");
        }
        scanner.close();
    }
}
