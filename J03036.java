import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class J03036 {
    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> a = new ArrayList<>();
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            a.add(scanner.nextLine());   
        }
        int ans = 9999999;
        boolean oge = false;
        for (int i = 0; i < a.get(0).length(); ++i) {
            String pattern = a.get(0).substring(i) + a.get(0).substring(0, i);
            int count = 0;
            boolean found = true;
            for (int j = 0; j < a.size(); ++j) {
                int res = shift(pattern, a.get(j), 0);
                if (res == -1) {
                    found = false;
                    break;
                }
                count += res;
            } 
            if (found) {
                oge = true;
                ans = Math.min(ans, count);
            }
        }
        if (oge) System.out.println(ans);
        else System.out.println(-1);

        scanner.close();
    }
    public static int shift(String pattern, String a, int operators) {
        if (a.length() != pattern.length() || operators > a.length()) return -1;
        if (a.equals(pattern)) return operators;
        String t = a.substring(1) + a.charAt(0);
        return shift(pattern, t, operators + 1);
    }
}
