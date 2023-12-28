import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class A {
    String id, name, phone;

    public A(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}

class C implements Comparable<C> {
    String id;
    int stt;

    public C(String id, int stt) {
        this.id = id;
        this.stt = stt;
    }
    @Override
    public int compareTo(C a) {
        return this.id.compareTo(a.id);
    }
}

public class J07027 {
    public static void main(String[] args) throws Exception {
        Scanner scanner1 = new Scanner(new File("SINHVIEN.in"));
        Scanner scanner2 = new Scanner(new File("BAITAP.in"));
        Scanner scanner3 = new Scanner(new File("NHOM.in"));
     
        int t = Integer.parseInt(scanner1.nextLine());
        ArrayList<A> a = new ArrayList<>();
        while (t-- > 0) {
            String id = scanner1.nextLine();
            String name = scanner1.nextLine();
            String phone = scanner1.nextLine();
            a.add(new A(id, name, phone));
        }
        
        ArrayList<String> b = new ArrayList<>();
        int n;
        t = Integer.parseInt(scanner2.nextLine());
        while (t-- > 0) {
            String name = scanner2.nextLine();
            b.add(name);
        }
        
        ArrayList<C> c = new ArrayList<>();
        while (scanner3.hasNextLine()) {
            String x[] = scanner3.nextLine().trim().split("\\s+");
            String id = x[0];                            
            int stt = Integer.parseInt(x[1]);
            c.add(new C(id, stt));
        }
        Collections.sort(c);
        for (C i : c) {
            for (A j : a) {
                if (i.id.equals(j.id)) {
                    System.out.println(i.id + " " + j.name + " " + j.phone + " " + i.stt + " " + b.get(i.stt - 1));
                }
            }
        }
    }    
}
