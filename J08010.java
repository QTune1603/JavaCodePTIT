import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class A {
    String a, b;
    Long c;
    A(String a, String b, Long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
class B implements Comparable<B> {
    String id, a, d, e;
    int b, c;
    B(String a, int b, int c, String d, String e, Integer num) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.id = "HP" + (num < 10 ? "00" : num < 100 ? "0" : "") + num.toString();
    }
    @Override
    public int compareTo(B a) {
        if (this.b != a.b) return this.b - a.b;
        if (this.c != a.c) return this.c - a.c;
        return this.d.compareTo(a.d);
    }
}
public class J08010 {
    public static boolean isPalin(String a) {
        for (int i = 0; i < a.length() / 2; ++i)
            if (a.charAt(i) != a.charAt(a.length() - 1 - i)) return false;
        return true;
    }
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        
        HashMap<String, Integer> mp = new HashMap<>();
        HashMap<String, Boolean> used = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        int maxLen = 0;
        while (scanner.hasNextLine()) {
            String a[] = scanner.nextLine().trim().split("\\s+");
            for (String i : a) {
                if (isPalin(i)) {
                    maxLen = Math.max(maxLen, i.length());
                    if (!mp.containsKey(i)) mp.put(i, 1);
                    else mp.put(i, mp.get(i) + 1);
                    ans.add(i);
                } 
            }
        }
        for (String i : ans) {
            if (!used.containsKey(i) && i.length() == maxLen) {
                System.out.println(i + " " + mp.get(i));
                used.put(i, true);
            }
        }
        scanner.close();
    }
}
