import java.util.ArrayList;
import java.util.Scanner;

class A {
    static int count = 0;
    String name, gender, birth, home, id;

    public A(String name, String gender, String birth, String home) {
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.home = home;
        this.id = String.format("KH%03d", ++count);
    }

}

class B {
    static int count = 0;
    String name, unit, id;
    long buy, sell;

    public B(String name, String unit, long buy, long sell) {
        this.name = name;
        this.unit = unit;
        this.buy = buy;
        this.sell = sell;
        this.id = String.format("MH%03d", ++count);
    }

}

class C {
    String idkh, idmh;
    long sl;

    public C(String idkh, String idmh, long sl) {
        this.idkh = idkh;
        this.idmh = idmh;
        this.sl = sl;
    }

}

public class J06005 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        ArrayList<A> a = new ArrayList<>();
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            String name = scanner.nextLine();
            String gender = scanner.nextLine();
            String birth = scanner.nextLine();
            String add = scanner.nextLine();
            a.add(new A(name, gender, birth, add));
        }

        ArrayList<B> b = new ArrayList<>();
        t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            String name = scanner.nextLine();
            String unit = scanner.nextLine();
            long buy = Long.parseLong(scanner.nextLine());
            long sell = Long.parseLong(scanner.nextLine());
            b.add(new B(name, unit, buy, sell));
        }

        ArrayList<C> c = new ArrayList<>();
        t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            String x[] = scanner.nextLine().trim().split("\\s+");
            String idkh = x[0];
            String idmh = x[1];
            long sl = Long.parseLong(x[2]);
            c.add(new C(idkh, idmh, sl));
        }

        int coun = 1;
        for (C i : c) {
            for (A j : a) {
                if (j.id.equals(i.idkh)) {
                    for (B k : b) {
                        if (k.id.equals(i.idmh)) {
                            System.out.println("HD" + (coun < 10 ? "00" : coun < 100 ? "0" : "") + coun + " " + j.name
                                    + " " + j.home + " " + k.name + " " + k.unit + " " + k.buy + " " + k.sell + " "
                                    + i.sl + " " + (i.sl * k.sell));
                            ++coun;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        scanner.close();
    }
}
