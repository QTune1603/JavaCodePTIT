import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;

public class J03037 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        
        String a = scanner.nextLine();
        long ans = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < a.length(); ++i) mp.put(a.charAt(i), i);
        for (int i = 0; i < a.length(); ++i) {
            for (int j = i + 1; j < a.length(); ++j) 
                if (a.charAt(i) == a.charAt(j)) {
                    for (int k = i + 1; k < j; ++k) {
                        int pos = mp.get(a.charAt(k));
                        if (pos < i || pos > j) ++ans;
                    }
                    break;
                }
        }
        System.out.print(ans);
        scanner.close();
    }
}
