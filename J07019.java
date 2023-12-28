import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class A {
    String id, name;
    long dongia1, dongia2;

    public A(String id, String name, long dongia1, long dongia2) {
        this.id = id;
        this.name = name;
        this.dongia1 = dongia1;
        this.dongia2 = dongia2;
    }

}

class B {
    String id;
    long sl;

    public B(String id, long sl) {
        this.id = id;
        this.sl = sl;
    }

}

public class J07019 {
    public static void main(String[] args) throws Exception {
        Scanner scanner1 = new Scanner(new File("DATA1.in"));
        Scanner scanner2 = new Scanner(new File("DATA2.in"));

        int t = Integer.parseInt(scanner1.nextLine());
        ArrayList<A> a = new ArrayList<>();
        while (t-- > 0) {
            String id = scanner1.nextLine();
            String name = scanner1.nextLine();
            long dongia1 = Long.parseLong(scanner1.nextLine());
            long dongia2 = Long.parseLong(scanner1.nextLine());
            a.add(new A(id, name, dongia1, dongia2));
        }

        ArrayList<B> b = new ArrayList<>();
        t = Integer.parseInt(scanner2.nextLine());
        while (t-- > 0) {
            String x[] = scanner2.nextLine().split("\\s+");
            String id = x[0];
            long sl = Long.parseLong(x[1]);
            b.add(new B(id, sl));
        }

        int count = 0;
        for (B i : b) {
            for (A j : a) {
                if (i.id.substring(0, 2).equals(j.id)) {
                    long cost = (i.id.charAt(2) == '1' ? j.dongia1 : j.dongia2) * i.sl;
                    long x = Math.round(i.sl >= 150 ? cost * 1.0 / 2
                            : i.sl >= 100 ? cost * 3 * 1.0 / 10 : i.sl >= 50 ? cost * 15 * 1.0 / 100 : 0);
                    cost -= x;
                    System.out
                            .println(i.id + "-" + String.format("%03d", ++count) + " " + j.name + " " + x + " " + cost);
                    break;
                }
            }
        }
    }
}
