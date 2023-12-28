import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class A implements Comparable<A> {
    String a;
    int b, c;
    A(String a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public int compareTo(A a) {
        if (this.b != a.b) return a.b - this.b;
        return this.c - a.c;
    }
}

public class J08011 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        
        HashMap<String, Integer> freq = new HashMap<>(), pos = new HashMap<>();
        ArrayList<String> t = new ArrayList<>();
        ArrayList<A> b = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String a[] = scanner.nextLine().trim().split("\\s+");
            for (int i = 0; i < a.length; ++i) {
                if (check(a[i])) {
                    if (!freq.containsKey(a[i])) {
                        freq.put(a[i], 1);
                        pos.put(a[i], i);
                        t.add(a[i]);
                    }
                    else freq.put(a[i], freq.get(a[i]) + 1);
                } 
            }
        }
        for (String i : t) b.add(new A(i, freq.get(i), pos.get(i)));
        Collections.sort(b);
        for (A i : b) {
            System.out.println(i.a + " " + i.b);
        }
        scanner.close();
    }
    public static boolean check(String a) {
        for (int i = 1; i < a.length(); ++i)
            if (a.charAt(i) < a.charAt(i - 1)) return false;
        return true;
    }
}
