import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class A implements Comparable<A> {
    String a;
    Long b;
    A(String a, Long b) {
       this.a = a;
       this.b = b;
    }
    @Override 
    public int compareTo (A ob) {
        return (this.b > ob.b) ? -1 : (this.b < ob.b) ? 1 : 0;
    }
    @Override 
    public String toString() {
        String ans = a + " " + b.toString();
        return ans;
    }
}
public class J07084 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(new File ("ONLINE.in"));
        
        int t = Integer.parseInt(scanner.nextLine()), test = 0;
        ArrayList<A> a = new ArrayList<>();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");        
        while (t-- > 0) {
            String b = scanner.nextLine();
            String x[] = scanner.nextLine().split("\\s+");
            Date c = s.parse(x[0]);
            String d = x[1];
            String y[] = scanner.nextLine().split("\\s+");
            Date e = s.parse(y[0]);
            String f = y[1];
            Long g = c.getTime() / 1000 + ((d.charAt(0) - '0') * 10 + (d.charAt(1) - '0')) * 3600 + ((d.charAt(3) - '0') * 10 + d.charAt(4)) * 60 + (d.charAt(6) - '0') * 10 + (d.charAt(7) - '0');            
            Long h = e.getTime() / 1000 + ((f.charAt(0) - '0') * 10 + (f.charAt(1) - '0')) * 3600 + ((f.charAt(3) - '0') * 10 + f.charAt(4)) * 60 + (f.charAt(6) - '0') * 10 + (f.charAt(7) - '0');            
            a.add(new A(b, (h - g) / 60));
        }
        Collections.sort(a);
        for (A i : a) {
            System.out.println(i);
        }
        scanner.close();
    } 
}
