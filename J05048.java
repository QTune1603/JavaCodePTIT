import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

class A implements Comparable <A> {
    String a;
    Long b, c, d, e, f;
    A(String a, Long b) {
        this.a = a;
        this.b = b;
        this.c = (long)Math.round((a.charAt(0) == 'A') ? this.b * 0.6 : this.b * 0.7);
        this.d = (a.charAt(a.length() - 1) == 'Y') ? 110000L : 135000L;
        this.e = this.c * this.d;
        this.f = (long)Math.round((a.charAt(0) == 'A' && a.charAt(a.length() - 1) == 'Y') ? this.e * 8 / 100 : (a.charAt(0) == 'A' && a.charAt(a.length() - 1) == 'N') ? this.e * 11 / 100 : (a.charAt(0) == 'B' && a.charAt(a.length() - 1) == 'Y') ? this.e * 17 / 100 : this.e * 22 / 100);
    }
    @Override
    public int compareTo(A a) {
        return a.c.compareTo(this.c);
    }
    @Override
    public String toString() {
        return (a + " " + b.toString() + " " + c.toString() + " " + d.toString() + " " + e.toString() + " " + f.toString());
    }
}

public class J05048 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        

        int t = Integer.parseInt(scanner.nextLine());
        Integer num = 0;
        ArrayList<A> a = new ArrayList<>();
        while (t-- > 0) {
            String b = scanner.nextLine();
            long c = Long.parseLong(scanner.nextLine());
            a.add(new A(b, c));
        }
        // Collections.sort(a);
        for (A i : a) System.out.println(i);

        scanner.close();
    }
}
