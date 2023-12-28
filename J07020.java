import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
  
class A implements Comparable<A> {
    String a, b, c, d, id;
    A(Integer id, String a, String b, String c, String d) {
        this.id = "KH" + (id < 10 ? "00" : id < 100 ? "0" : "") + id.toString();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    @Override
    public int compareTo(A a) {
        return a.d.compareTo(this.d);
    }
    @Override
    public String toString() {
        return a + " " + b + " " + c.toString() + " " +  d.toString();
    }
}
class B {
    String id, a, b;
    Long c, d;
    B(Integer id, String a, String b, long c, long d) {
        this.id = "MH" + (id < 10 ? "00" : id < 100 ? "0" : "") + id.toString();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}

public class J07020 {
    public static void main(String args[]) throws IOException {
        Scanner scanner1 = new Scanner(new File("KH.in"));
        Scanner scanner2 = new Scanner(new File("MH.in"));
        Scanner scanner3 = new Scanner(new File("HD.in"));

        int t = Integer.parseInt(scanner1.nextLine());
        Integer num = 0;
        ArrayList<A> a = new ArrayList<>();
        while (t-- > 0) {
            String b = scanner1.nextLine();
            String c = scanner1.nextLine();
            String d = scanner1.nextLine();
            String e = scanner1.nextLine();            
            a.add(new A(++num, b, c, d, e));
        }

        ArrayList<B> b = new ArrayList<>();        
        int u = Integer.parseInt(scanner2.nextLine());
        num = 0;
        while (u-- > 0) {
            String c = scanner2.nextLine();
            String d = scanner2.nextLine();
            long e = Long.parseLong(scanner2.nextLine());
            long f = Long.parseLong(scanner2.nextLine());
            b.add(new B(++num, c, d, e, f));
        }
        
        int w = Integer.parseInt(scanner3.nextLine());
        num = 0;
        while (w-- > 0) {
            String x[] = scanner3.nextLine().split("\\s+");
            String c = x[0], d = x[1];
            long e = Long.parseLong(x[2]);
            for (A i : a) {
                if (i.id.equals(c)) {
                    String y = "HD" + (++num < 10 ? "00" : num < 100 ? "0" : "") + num.toString();
                    System.out.print(y + " " + i.a + " " + i.d + " ");
                    for (B j : b) {
                        if (j.id.equals(d)) {
                            System.out.println(j.a + " " + j.b + " " + j.c + " " + j.d + " " + e + " " + (e * j.d));
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
}
