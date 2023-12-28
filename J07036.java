import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class A {
    String id, name, cl, email;

    public A(String id, String name, String cl, String email) {
        this.id = id;
        this.name = f(name);
        this.cl = cl;
        this.email = email;
    }
    private String f(String a) {
        String x[] = a.trim().toLowerCase().split("\\s+");
        a = "";
        for (String i : x) {
            a += String.valueOf(i.charAt(0)).toUpperCase() + i.substring(1).toLowerCase() + " ";
        }
        return a.trim();
    }
}

class B {
    String id, name;
    long num;

    public B(String id, String name, long num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }
    
}

class C implements Comparable<C> {
    String idsv, idmon;
    double mark;

    public C(String idsv, String idmon, double mark) {
        this.idsv = idsv;
        this.idmon = idmon;
        this.mark = mark;
    }
    @Override 
    public int compareTo(C a) {
     
        return this.idsv.compareTo(a.idsv);
    }
}
class D implements Comparable<D> {
    A a;
    B b;
    C c;

    public D(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public int compareTo(D a) {
        if (!this.b.id.equals(a.b.id)) return this.b.id.compareTo(a.b.id);
        return this.c.idsv.compareTo(a.c.idsv);
    }
    @Override
    public String toString() {
        return c.idsv + " " + a.name + " " + b.id + " " + b.name + " " + new DecimalFormat().format(c.mark);
    }
}
public class J07036 {
    public static void main(String[] args) throws Exception {
        Scanner scanner1 = new Scanner(new File("SINHVIEN.in"));
        Scanner scanner2 = new Scanner(new File("MONHOC.in"));
        Scanner scanner3 = new Scanner(new File("BANGDIEM.in"));

//        Scanner scanner = new Scanner(System.in);
//        if (System.getProperty("ONLINE_JUDGE") == null) { 
//            try { 
//                System.setOut(new PrintStream( 
//                    new FileOutputStream("output.txt"))); 
//                scanner = new Scanner(new File("input.txt")); 
//            } 
//            catch (Exception e) { 
//            } 
//        }
        
        ArrayList<A> a = new ArrayList<>();
        ArrayList<B> b = new ArrayList<>();
        ArrayList<C> c = new ArrayList<>();
        int t = Integer.parseInt(scanner1.nextLine());
        while (t-- > 0) {
            String id = scanner1.nextLine();
            String name = scanner1.nextLine().trim();
            String cl = scanner1.nextLine();
            String email = scanner1.nextLine();
            a.add(new A(id, name, cl, email));
        }
        
        t = Integer.parseInt(scanner2.nextLine());
        while (t-- > 0) {
            String id = scanner2.nextLine();
            String name = scanner2.nextLine();
            long num = Long.parseLong(scanner2.nextLine());
            b.add(new B(id, name, num));
        }
        
        t = Integer.parseInt(scanner3.nextLine());        
        while (t-- > 0) {
            String x[] = scanner3.nextLine().trim().split("\\s+");
            String idsv = x[0];
            String idmon = x[1];
            double mark = Double.parseDouble(x[2]);
            c.add(new C(idsv, idmon, mark));
        }
        t = Integer.parseInt(scanner3.nextLine());        
        while (t-- > 0) {
            String cl = scanner3.nextLine();
            System.out.println("BANG DIEM lop " + cl + ":");
            ArrayList<D> d = new ArrayList<>();
            for (B i : b) {
                for (A j : a) {
                    for (C k : c) {
                        if (i.id.equals(k.idmon) && k.idsv.equals(j.id) && j.cl.equals(cl)) {
                            d.add(new D(j, i, k));
                        }
                    }
                }
            }
            Collections.sort(d);
            for (D i : d) {
                System.out.println(i);
            }
        }
    }
}
