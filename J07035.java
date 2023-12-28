import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
  
class A implements Comparable<A> {
    String a, b, c, d;
    A(String a, String b, String c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    @Override
    public int compareTo(A a) {
        if (!this.b.equals(a.b)) return a.b.compareTo(this.b);
        return this.a.compareTo(a.a);
    }
    @Override
    public String toString() {
        return a;
    }
}
class B implements Comparable<B> { 
    String a, b;
    Long c;
    B(String a, String b, long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public int compareTo(B a) {
        return this.a.compareTo(a.a);
    }
    @Override
    public String toString() {
        return a + " " + b + " " + c;
    }
}
class C {
    String a, b;
    Double c;
    C(String a, String b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
class D implements Comparable<D> {
    String a;
    Double b;
    D(String a, double b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public int compareTo(D a) {
        if (!this.b.equals(a.b)) return a.b.compareTo(this.b);
        return this.a.compareTo(a.a);
    }
    @Override
    public String toString() {
        return a + " " + b;
    }
}

public class J07035 {
    public static void main(String args[]) throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner scanner1 = new Scanner(new File("SINHVIEN.in"));        
        Scanner scanner2 = new Scanner(new File("MONHOC.in"));        
        Scanner scanner3 = new Scanner(new File("BANGDIEM.in"));        
        
        int t = Integer.parseInt(scanner1.nextLine());
        ArrayList<A> a = new ArrayList<>();
        while (t-- > 0) {
            String b = scanner1.nextLine();
            String c = scanner1.nextLine();
            String d = scanner1.nextLine();
            String e = scanner1.nextLine();
            String x[] = c.trim().toLowerCase().split("\\s+");
            c = "";
            for (String i : x) {
                c += String.valueOf(i.charAt(0)).toUpperCase() + i.substring(1) + " ";
            }
            c = c.trim();
            a.add(new A(b, c, d, e));
        }

        t = Integer.parseInt(scanner2.nextLine());
        ArrayList<B> b = new ArrayList<>();
        while (t-- > 0) {
            String c = scanner2.nextLine();
            String d = scanner2.nextLine();
            long e = Long.parseLong(scanner2.nextLine());
            b.add(new B(c, d, e));
        }

        t = Integer.parseInt(scanner3.nextLine());
        ArrayList<C> c = new ArrayList<>();
        while (t-- > 0) {
            String x[] = scanner3.nextLine().split("\\s+");
            c.add(new C(x[0], x[1], Double.parseDouble(x[2])));
        }

        t = Integer.parseInt(scanner3.nextLine());
        while (t-- > 0) {
            String e = scanner3.nextLine();
            System.out.print("BANG DIEM MON ");
            for (B i : b) if (i.a.equals(e)) 
                System.out.println(i.b + ":");
            ArrayList<D> d = new ArrayList<>();
            for (C i : c) {
                if (i.b.equals(e)) {
                    for (A j : a) {
                        if (j.a.equals(i.a)) {
                            d.add(new D(j.a, i.c));
                            break;
                        }
                    }
                }
            }
            Collections.sort(d);
            for (D i : d) {
                for (A j : a) {
                    if (j.a.equals(i.a)) System.out.println(i.a + " " + j.b + " " + " " + j.c + " " + new DecimalFormat().format(i.b));
                }
            }
        }
    }
}
