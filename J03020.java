import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class J03020 {
    public static boolean isPalin(String a) {
        for (int i = 0; i < a.length() / 2; ++i) {
            if (a.charAt(i) != a.charAt(a.length() - i - 1)) return false;
        }
        return true;
    }
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> a = new ArrayList<>(), ans = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String t[] = scanner.nextLine().trim().split("\\s+");
            for (String i : t) a.add(i);
        }
        HashMap<String,Integer> mp = new HashMap<>();
        int maxLen = 0;
        for (String i : a) {
            if (isPalin(i)) {
                if (!mp.containsKey(i)) {
                    mp.put(i, 1);
                    ans.add(i);
                    maxLen = Math.max(maxLen, i.length());
                }
                else mp.put(i, mp.get(i) + 1);
            }
        }
        for (String i : ans) {
            if (maxLen == i.length()) System.out.println(i + " " + mp.get(i));
        }
        scanner.close();
    }
}
