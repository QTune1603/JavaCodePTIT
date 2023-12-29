import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class A implements Comparable<A> {
    String a, c, d, e;
    ArrayList<String> b = new ArrayList<>();
    A(String a, String b, String c, String e) {
        this.a = a;
        this.c = c;
        this.e = e;
        String temp[] = b.trim().split(" ");
        for (String i : temp) this.b.add(i);
        for (int i = 1; i < temp.length - 1; ++i) this.d += temp[i] + " ";
    }
    @Override 
    public int compareTo (A ob) {
        if (!this.b.get(this.b.size() - 1).equals(ob.b.get(ob.b.size() - 1))) return this.b.get(this.b.size() - 1).compareTo(ob.b.get(ob.b.size() - 1)); 
        if (!this.b.get(0).equals(ob.b.get(0))) return this.b.get(0).compareTo(ob.b.get(0));
        if (!this.d.equals(ob.d)) return this.d.compareTo(ob.d);
        return this.a.compareTo(ob.a);
    }
    @Override 
    public String toString() {
        String ans = a + " ";
        for (String i : b) ans += i + " ";
        ans += c + " " + e;
        return ans;
    }
}
public class J07081 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(new File ("SINHVIEN.in"));
        
        int t = Integer.parseInt(scanner.nextLine()), test = 0;
        ArrayList<A> a = new ArrayList<>();
        // SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");        
        while (t-- > 0) {
            String b = scanner.nextLine();
            String c = scanner.nextLine();
            String d = scanner.nextLine();
            String e = scanner.nextLine();
            a.add(new A(b, c, d, e));
        }
        Collections.sort(a);
        for (A i : a) {
            System.out.println(i);
        }
        scanner.close();
    }   
}
