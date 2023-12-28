import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class A implements Comparable<A> {
    String id, name, on, off;
    long num;

    public A(String id, String name, long num, String off, String on) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.off = off;
        this.on = on;
    }
    @Override
    public int compareTo(A a) {
        return this.id.compareTo(a.id);
    }
    @Override
    public String toString() {
        return id + " " + name + " " + num + " " + off + " " + on; 
    }
}

public class J07073 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("MONHOC.in"));

        ArrayList<A> a = new ArrayList<>();
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            String id = scanner.nextLine();
            String name = scanner.nextLine();
            long num = Long.parseLong(scanner.nextLine());
            String off = scanner.nextLine();
            String on = scanner.nextLine();
            a.add(new A(id, name, num, off, on));
        }
        Collections.sort(a);
        for (A i : a) {
            if (i.on.toLowerCase().trim().equals("truc tuyen") || i.on.trim().contains("ptit.edu.vn")) {
                System.out.println(i);
            }
        }
        scanner.close();
    }
}
