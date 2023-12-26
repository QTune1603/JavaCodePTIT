import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class A implements Comparable<A> {
    String a, id, b;
    Double c;
    A(String a, Integer id, Double c) {
        this.c = c;
        String temp[] = a.trim().toLowerCase().split("\\s+");
        a = "";
        for (String i : temp) {
            a += String.valueOf(i.charAt(0)).toUpperCase() + i.substring(1) + " ";
        }
        this.a = a.trim();
        this.id = (id < 10 ? "SV0" + id.toString() : "SV" + id.toString());
        this.b = c.toString();
    }
    @Override 
    public int compareTo (A ob) {
        return ob.c.compareTo(this.c);
    }
    @Override 
    public String toString() {
        String ans = id + " " + a + " " + String.format("%.2f", c);
        return ans;
    }
}
public class J07054 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
 
        Scanner scanner = new Scanner(new File ("BANGDIEM.in"));
 
        int t = Integer.parseInt(scanner.nextLine()), test = 0;
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");        
        ArrayList<A> a = new ArrayList<>();
        while (t-- > 0) {
            String b = scanner.nextLine();
            double c = Double.parseDouble(scanner.nextLine());
            double d = Double.parseDouble(scanner.nextLine());
            double e = Double.parseDouble(scanner.nextLine());
            a.add(new A(b, ++test, (c * 3 + d * 3 + e * 2) / 8));
        }
        Collections.sort(a);
        int f = 1, g = 1;
        for (int i = 0; i < a.size(); ++i) {
            System.out.print(a.get(i));
            if (i == 0) {
                System.out.println(" 1");
                continue;
            }
            if (a.get(i).c.equals(a.get(i - 1).c)) {
                ++g;
                System.out.println(" " + f);    
            }
            else {
                f += g;
                System.out.println(" " + f);
                g = 1;
            }
        }
        scanner.close();
    }   
}
